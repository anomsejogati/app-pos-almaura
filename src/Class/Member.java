package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Member {
  Connection _Cnn;
    DBO getCn = new DBO();
    
    public String no_member;
    public String nm_member;
    public String tmp_lahir;
    public String tgl_lahir, tgl_member;
    public String jns_kel;
    public String agama;
    public String pendidikan, pekerjaan;
    public String status;
    public String kota;
    public String alamat;
    public String no_telp;
    public String _Akses = "";
    
    
    public void Search(String no_member){
        try {
            _Akses = "";
            _Cnn = getCn.getConnection();
            
            String SQL = "select * from pos_member where no_member = '"+no_member+"'";
            
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(SQL);
            while (res.next()) {
                _Akses = "-";
                this.no_member = res.getString(1);
                this.tgl_member = res.getString(2);
                this.nm_member = res.getString(3);
                this.jns_kel = res.getString(4);
                this.tmp_lahir = res.getString(5);
                this.tgl_lahir = res.getString(6);
                this.agama = res.getString(7);
                this.pendidikan = res.getString(8);
                this.pekerjaan = res.getString(9);
                this.status = res.getString(10);
                this.kota = res.getString(11);
                this.alamat = res.getString(12);
                this.no_telp = res.getString(13);
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
            sql = "insert into pos_member values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.no_member);
            stat.setString(2, this.tgl_member);
            stat.setString(3, this.nm_member);
            stat.setString(4, this.jns_kel);
            stat.setString(5, this.tmp_lahir);
            stat.setString(6, this.tgl_lahir);
            stat.setString(7, this.agama);
            stat.setString(8, this.pendidikan);
            stat.setString(9, this.pekerjaan);
            stat.setString(10, this.status);
            stat.setString(11, this.kota);
            stat.setString(12, this.alamat);
            stat.setString(13, this.no_telp);
            
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
            sql = "update pos_member set tgl_member=?, nm_member=?, jns_kel=?, tmp_Lahir=?, tgl_lahir=?, agama=?, pendidikan=?, pekerjaan=?, status=?, kota=?, alamat=?, no_telp=? "
                    + " where no_member ='"+no_member+"'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.tgl_member);
            stat.setString(2, this.nm_member);
            stat.setString(3, this.jns_kel);
            stat.setString(4, this.tmp_lahir);
            stat.setString(5, this.tgl_lahir);
            stat.setString(6, this.agama);
            stat.setString(7, this.pendidikan);
            stat.setString(8, this.pekerjaan);
            stat.setString(9, this.status);
            stat.setString(10, this.kota);
            stat.setString(11, this.alamat);
            stat.setString(12, this.no_telp);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void Delete(String no_member){
        try{
            _Cnn = getCn.getConnection();
            String sql = "Delete from pos_member where no_member = '" + no_member + "'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
