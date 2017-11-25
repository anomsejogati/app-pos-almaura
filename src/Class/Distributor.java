/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Ogatz
 */
public class Distributor {
    Connection _Cnn;
    DBO getCn = new DBO();
    
    public String id_dis;
    public String nm_distributor;
    public String kota;
    public String alamat;
    public String nm_manajer;
    public String no_telp;
    public String no_hp;
    public String email;
    public String _Akses = "";
    
    
    public void Search(String id_dis){
        try {
            _Akses = "";
            _Cnn = getCn.getConnection();
            
            String SQL = "select * from pos_distributor where id_dis = '"+id_dis+"'";
            
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(SQL);
            while (res.next()) {
                _Akses = "-";
                this.id_dis = res.getString(1);
                this.nm_distributor = res.getString(2);
                this.nm_manajer = res.getString(3);
                this.kota = res.getString(4);
                this.alamat = res.getString(5);
                this.no_telp = res.getString(6);
                this.no_hp = res.getString(7);
                this.email = res.getString(8);
               
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
            sql = "insert into pos_distributor values(?,?,?,?,?,?,?,?)";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.id_dis);
            stat.setString(2, this.nm_distributor);
            stat.setString(3, this.nm_manajer);
            stat.setString(4, this.kota);
            stat.setString(5, this.alamat);
            stat.setString(6, this.no_telp);
            stat.setString(7, this.no_hp);
            stat.setString(8, this.email);
            
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
            sql = "update pos_distributor set nm_distributor=?, nm_manajer=?, kota=?, alamat=?, no_telp=?, no_hp=?, email=? "
                    + " where id_dis ='"+id_dis+"'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.nm_distributor);
            stat.setString(2, this.nm_manajer);
            stat.setString(3, this.kota);
            stat.setString(4, this.alamat);
            stat.setString(5, this.no_telp);
            stat.setString(6, this.no_hp);
            stat.setString(7, this.email);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void Delete(String id_dis){
        try{
            _Cnn = getCn.getConnection();
            String sql = "Delete from pos_distributor where id_dis = '" + id_dis + "'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
