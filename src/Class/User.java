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
public class User {
    Connection _Cnn;
    DBO getCn = new DBO();
    
    public String id_user;
    public String nm_user;
    public String pass;
    public String lev_user;
    public String _Akses = "";
    
    
    public void Search(String id_user){
        try {
            _Akses = "";
            _Cnn = getCn.getConnection();
            
            String SQL = "select * from pos_user where id_user = '"+id_user+"'";
            
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(SQL);
            while (res.next()) {
                _Akses = "-";
                this.id_user = res.getString(1);
                this.nm_user = res.getString(2);
                this.pass = res.getString(3);
                this.lev_user = res.getString(4);
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
            sql = "insert into pos_user values(?,?,?,?)";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.id_user);
            stat.setString(2, this.nm_user);
            stat.setString(3, this.pass);
            stat.setString(4, this.lev_user);            
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
            sql = "update pos_user set nm_user=?, pass=?, lev_user=? "
                    + " where id_user ='"+id_user+"'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.setString(1, this.nm_user);
            stat.setString(2, this.pass);
            stat.setString(3, this.lev_user);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void Delete(String id_user){
        try{
            _Cnn = getCn.getConnection();
            String sql = "Delete from pos_user where id_user = '" + id_user + "'";
            PreparedStatement stat = _Cnn.prepareStatement(sql);
            stat.executeUpdate();
            stat.close();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
