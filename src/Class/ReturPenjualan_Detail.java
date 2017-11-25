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
public class ReturPenjualan_Detail {
Connection _Cnn;
DBO getCn = new DBO();

  public String no_retur;
  public String kd_barang;
  public Integer jumlah;
  public Double harga;
  public String _Akses = "";

  public void Search(String no_retur,String kd_barang)
  {
      try
      {
          _Akses = "";
          _Cnn = getCn.getConnection();
          String SQL = "select * from pos_retpenjualandet where no_retur='"+ no_retur +"' AND kd_barang='"+ kd_barang +"'";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.no_retur  = res.getString(1);
              this.kd_barang  = res.getString(2);
              this.jumlah  = res.getInt(3);
              this.harga  = res.getDouble(4);
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
              sql = "INSERT INTO pos_retpenjualandet VALUES(?,?,?,?)";
          }
          else
          {
              sql = "UPDATE pos_retpenjualandet SET kd_barang=?,jumlah=?,harga=? WHERE no_retur='"+ no_retur +"' AND kd_barang='"+ kd_barang +"'";
          }
              PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.kd_barang);
              stat.setInt(2,this.jumlah);
              stat.setDouble(3,this.harga);
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
          String sql ="";
          _Cnn = getCn.getConnection();
          sql = "INSERT INTO pos_retpenjualandet VALUES(?,?,?,?)";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_retur);
              stat.setString(2,this.kd_barang);
              stat.setInt(3,this.jumlah);
              stat.setDouble(4,this.harga);
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
              sql = "UPDATE pos_retpenjualandet SET kd_barang=?,jumlah=?,harga=? WHERE no_retur='"+ no_retur +"' AND kd_barang='"+ kd_barang +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.kd_barang);
              stat.setInt(2,this.jumlah);
              stat.setDouble(3,this.harga);
              stat.executeUpdate();
              stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void Delete(String no_retur,String kd_barang)
  {
      try
      {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM pos_retpenjualandet WHERE no_retur='"+ no_retur +"' AND kd_barang='"+ kd_barang +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
          stat.executeUpdate();
          stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
  
  public void DeleteAll(String no_retur)
  {
      try
      {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM pos_retpenjualandet WHERE no_retur='"+ no_retur +"'";
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
