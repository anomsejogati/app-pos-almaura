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
public class BarangMasuk_Detail {
    Connection _Cnn;
DBO getCn = new DBO();

  public String no_faktur;
  public String kd_barang;
  public Integer jumlah;
  public Double harga_baru, subtotal;
  public String _Akses = "";

  public void Search(String no_faktur,String kd_barang)
  {
      try
      {
          _Akses = "";
          _Cnn = getCn.getConnection();
          String SQL = "select * from pos_brgmasukdet where no_faktur='"+ no_faktur +"' AND kd_barang='"+ kd_barang +"'";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.no_faktur  = res.getString(1);
              this.kd_barang  = res.getString(2);
              this.jumlah  = res.getInt(3);
              this.harga_baru  = res.getDouble(4);
              this.subtotal  = res.getDouble(5);
          }
          stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
  }
  
  public void SaveOrUpdate()
  {
      try
      {
          String sql ="";
          _Cnn = getCn.getConnection();
          if(_Akses.equals(""))
          {
              sql = "INSERT INTO pos_brgmasukdet VALUES(?,?,?,?)";
          }
          else
          {
              sql = "UPDATE pos_brgmasukdet SET no_faktur=?,kd_barang=?,jumlah=?,harga_baru=? subtotal=? WHERE no_faktur='"+ no_faktur +"' AND kd_barang='"+ kd_barang +"'";
          }
              PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_faktur);
              stat.setString(2,this.kd_barang);
              stat.setInt(3,this.jumlah);
              stat.setDouble(4,this.harga_baru);
              stat.setDouble(5,this.subtotal);
              stat.executeUpdate();
              stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void SaveData()
  {
      try
      {
          _Cnn = null;
          _Cnn = getCn.getConnection();
          String sql = "INSERT INTO pos_brgmasukdet VALUES(?,?,?,?,?)";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_faktur);
              stat.setString(2,this.kd_barang);
              stat.setInt(3,this.jumlah);
              stat.setDouble(4,this.harga_baru);
              stat.setDouble(5,this.subtotal);
              stat.executeUpdate();
              stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void UpdateData()
  {
      try
      {
          String sql ="";
          _Cnn = getCn.getConnection();
              sql = "UPDATE pos_brgmasukdet SET no_faktur=?,kd_barang=?,jumlah=?,harga_baru=?,subtotal=? WHERE no_faktur='"+ no_faktur +"' AND kd_barang='"+ kd_barang +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_faktur);
              stat.setString(2,this.kd_barang);
              stat.setInt(3,this.jumlah);
              stat.setDouble(4,this.harga_baru);
              stat.setDouble(5,this.subtotal);
              stat.executeUpdate();
              stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void Delete(String no_faktur,String kd_barang)
  {
      try
      {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM pos_brgmasukdet WHERE no_faktur='"+ no_faktur +"' AND kd_barang='"+ kd_barang +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
          stat.executeUpdate();
          stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
  
  public void DeleteAll(String no_faktur)
  {
      try
      {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM pos_brgmasukdet WHERE no_faktur='"+ no_faktur +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
          stat.executeUpdate();
          stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
    
}
