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
public class ReturBarangMasuk {
        Connection _Cnn;
DBO getCn = new DBO();

  public String no_retur, no_faktur;
  public String tgl_retur, kd_barang, nm_distributor;
  public String id_dis;
  public Double total, harga;
  public int jumlah;
  public String _Akses = "";

  public void Search(String no_retur)
  {
      try
      {
          _Akses = "";
          _Cnn = getCn.getConnection();
          String SQL = "select * from pos_retbrgmasuk a, pos_penjualan b, pos_distributor c where a.no_faktur=b.no_faktur and a.id_dis=c.id_dis and a.no_retur='"+ no_retur +"'";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.no_retur = res.getString(1);
              this.no_faktur  = res.getString(2);
              this.tgl_retur  = res.getString(3);
              this.id_dis  = res.getString(4);
              this.total  = res.getDouble(5);
              
          }
          stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
  }
  
  public void SearchNama(String no_faktur)
  {
      try
      {
          _Akses = "";
          _Cnn = getCn.getConnection();
          String SQL = "select a.no_faktur, a.id_dis, b.nm_distributor from pos_retbrgmasuk a, pos_distributor b "
                  + "where a.id_dis=c.id_dis and a.no_faktur='"+ no_faktur +"'";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.nm_distributor  = res.getString(3);     
          }
          stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
  }

  public void Save()
  {
      try
      {
          String sql ="";
          _Cnn = getCn.getConnection();
          sql = "INSERT INTO pos_retbrgmasuk VALUES(?,?,?,?,?)";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_retur);
              stat.setString(2,this.no_faktur);
              stat.setString(3,this.tgl_retur);
              stat.setString(4,this.id_dis);
              stat.setDouble(5,this.total);
              stat.executeUpdate();
              stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
  
    
}
