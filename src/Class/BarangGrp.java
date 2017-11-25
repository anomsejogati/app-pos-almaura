package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BarangGrp {
Connection _Cnn;
    DBO getCn = new DBO();

    public String kd_group, kelompok;
   
    public String _Akses = "";
    
    
    
    public void SearchGrpBrg(String kelompok) {
        try{
            _Akses = "";
            _Cnn = getCn.getConnection();
            
            String sql = "select * from pos_grpbarang "
                    + "where kelompok='"+kelompok+"'";
            
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()){
                _Akses = "";
                this.kd_group = res.getString(1);
                this.kelompok = res.getString(2);
                
            }
            stat.close();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void SaveGrpBrg() {
        try {
            String sql = "";
            _Cnn = getCn.getConnection();
            sql = "insert into pos_grpbarang values(?,?)";
            
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.kd_group);
            stat.setString(2, this.kelompok);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void UpdateGrpBrg() {
        try{
            String sql = "";
            _Cnn = getCn.getConnection();
            
            sql = "update pos_grpbarang set"
                    + "kelompok=? "
                    + "where kd_group='"+kd_group+"'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.kelompok);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void DeleteGrpBrg(String kode){
        try{
            _Cnn = getCn.getConnection();
            String sql = "Delete from pos_grpbarang where kd_group = '"+kode+"'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
