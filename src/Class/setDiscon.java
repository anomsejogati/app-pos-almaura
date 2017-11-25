package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class setDiscon {
  Connection _Cnn;
    DBO getCn = new DBO();
    
    public String id_discon;
    public Double discon, val_awal, val_akhir;
    public String sta_aktif;
    public String _Akses = "";
    
    public void getDiskon(String id_discon){
        try {
            _Akses = "";
            _Cnn = getCn.getConnection();
            String SQL = "select * from pos_discon where id_discon = '"+id_discon+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(SQL);
            while (res.next()) {
                _Akses = "-";
                this.id_discon = res.getString(1);
                this.discon = res.getDouble(2);
                this.val_awal = res.getDouble(3);
                this.val_akhir = res.getDouble(4);
                this.sta_aktif = res.getString(5);
            }
            stat.close();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void Save(){
        try{
            String sql = "";
            _Cnn = getCn.getConnection();
            sql = "insert into pos_discon values(?,?,?,?,?)";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.id_discon);
            stat.setDouble(2, this.discon);
            stat.setDouble(3, this.val_awal);
            stat.setDouble(4, this.val_akhir);
            stat.setString(5, this.sta_aktif);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void UpdateData(String id_discon){
        try{
            String sql = "";
            _Cnn = getCn.getConnection();
            sql = "update pos_discon set discon=?, val_awal=?, val_akhir=?, sta_aktif=? "
                    + " where id_discon ='"+id_discon+"'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setDouble(1, this.discon);
            stat.setDouble(2, this.val_awal);
            stat.setDouble(3, this.val_akhir);
            stat.setString(4, this.sta_aktif);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void Delete(String id_discon){
        try{
            _Cnn = getCn.getConnection();
            String sql = "Delete from pos_discon where id_discon = '" + id_discon + "'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
