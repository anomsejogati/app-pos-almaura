package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Pegawai {
  Connection _Cnn;
    DBO getCn = new DBO();
    
    public String id_peg;
    public String nm_pegawai;
    public String tmp_lahir;
    public String tgl_lahir;
    public String jns_kel;
    public String alamat;
    public String no_telp;
    public String _Akses = "";
    
    
    public void Search(String id_peg){
        try {
            _Akses = "";
            _Cnn = getCn.getConnection();
            
            String SQL = "select * from pos_pegawai where id_peg = '"+id_peg+"'";
            
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(SQL);
            while (res.next()) {
                _Akses = "-";
                this.id_peg = res.getString(1);
                this.nm_pegawai = res.getString(2);
                this.jns_kel = res.getString(3);
                this.tmp_lahir = res.getString(4);
                this.tgl_lahir = res.getString(5);
                this.alamat = res.getString(6);
                this.no_telp = res.getString(7);
            }
            stat.close();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void SaveData(){
        try{
            String sql = "";
            _Cnn = getCn.getConnection();
            sql = "insert into pos_pegawai values(?,?,?,?,?,?,?)";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.id_peg);
            stat.setString(2, this.nm_pegawai);
            stat.setString(3, this.jns_kel);
            stat.setString(4, this.tmp_lahir);
            stat.setString(5, this.tgl_lahir);
            stat.setString(6, this.alamat);
            stat.setString(7, this.no_telp);
            
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void UpdateData(){
        try{
            String sql = "";
            _Cnn = getCn.getConnection();
            sql = "update pos_pegawai set nm_pegawai=?, jns_kel=?, tmp_Lahir=?, tgl_lahir=?, alamat=?, no_telp=? "
                    + " where id_peg ='"+id_peg+"'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.nm_pegawai);
            stat.setString(2, this.jns_kel);
            stat.setString(3, this.tmp_lahir);
            stat.setString(4, this.tgl_lahir);
            stat.setString(5, this.alamat);
            stat.setString(6, this.no_telp);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void Delete(String id_peg){
        try{
            _Cnn = getCn.getConnection();
            String sql = "Delete from pos_pegawai where id_peg = '" + id_peg + "'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
