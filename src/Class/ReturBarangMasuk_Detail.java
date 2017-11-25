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
public class ReturBarangMasuk_Detail {
    Connection _Cnn;
DBO getCn = new DBO();

  public String no_retur, no_faktur;
  public String tgl_retur, kd_barang;
  public String id_dis;
  public Double total, harga;
  public int jumlah;
  public String _Akses = "";

  
  public void Search(String no_retur, String kd_barang)
  {
      try
      {
          _Akses = "";
          _Cnn = getCn.getConnection();
          String SQL = "select * from pos_retbrgmasukdet a, pos_barang b where a.kd_barang=b.kd_barang and a.no_retur='"+ no_retur +"' and a.kd_barang='"+kd_barang+"'";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.no_retur = res.getString(1);
              this.kd_barang  = res.getString(2);
              this.harga  = res.getDouble(3);
              this.jumlah  = res.getInt(4);
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
          sql = "INSERT INTO pos_retbrgmasukdet VALUES(?,?,?,?)";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_retur);
              stat.setString(2,this.kd_barang);
              stat.setDouble(3,this.harga);
              stat.setDouble(4,this.jumlah);
              stat.executeUpdate();
              stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }
}
