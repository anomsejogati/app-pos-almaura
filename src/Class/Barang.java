package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Barang {
  Connection _Cnn;
    DBO getCn = new DBO();
    
    public String kd_barang;
    public String nm_barang;
    public String kd_group;
    public String satuan;
    public Double harga_net;
    public Double harga_jual;
    public Double jml_stok;
    public String _Akses = "";
    
    
    public void Search(String kd_barang){
        try {
            _Akses = "";
            _Cnn = getCn.getConnection();
            
            String SQL = "select * from pos_barang where kd_barang = '"+kd_barang+"'";
            
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(SQL);
            while (res.next()) {
                _Akses = "-";
                this.kd_barang = res.getString(1);
                this.nm_barang = res.getString(2);
                this.kd_group = res.getString(3);
                this.satuan = res.getString(4);
                this.harga_net = res.getDouble(5);
                this.harga_jual = res.getDouble(6);
                this.jml_stok = res.getDouble(7);
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
            sql = "insert into pos_barang values(?,?,?,?,?,?,0)";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.kd_barang);
            stat.setString(2, this.nm_barang);
            stat.setString(3, this.kd_group);
            stat.setString(4, this.satuan);
            stat.setDouble(5, this.harga_net);
            stat.setDouble(6, this.harga_jual);            
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
            sql = "update pos_barang set nm_barang=?, satuan=?, harga_net=?, harga_jual=?, jml_stok=? "
                    + " where kd_barang ='"+kd_barang+"'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.nm_barang);
            stat.setString(2, this.satuan);
            stat.setDouble(3, this.harga_net);
            stat.setDouble(4, this.harga_jual);
            stat.setDouble(5, this.jml_stok);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void Delete(String kd_barang){
        try{
            _Cnn = getCn.getConnection();
            String sql = "Delete from pos_barang where kd_barang = '" + kd_barang + "'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
