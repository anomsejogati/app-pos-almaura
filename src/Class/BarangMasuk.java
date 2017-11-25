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
 * @author Ogat Dezaign
 */
public class BarangMasuk {
    Connection _Cnn;
DBO getCn = new DBO();

  public String no_faktur, tgl_masuk, id_dis, id_peg;
  public Double total;
  public String _Akses = "";

  public void Search(String no_faktur)
  {
      try
      {
          _Akses = "";
          _Cnn = getCn.getConnection();
          String SQL = "select * from pos_brgmasuk a, pos_distributor b where a.id_dis=b.id_dis and a.no_faktur='"+ no_faktur +"'";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.no_faktur  = res.getString(1);
              this.tgl_masuk  = res.getString(2);
              this.id_dis  = res.getString(3);
              this.id_peg  = res.getString(4);
              this.total  = res.getDouble(5);
          }
          stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
  }
  
  public void Refresh()
  {
      try
      {
          _Akses = "";
          _Cnn = getCn.getConnection();
          String SQL = "select * from pos_brgmasuk a, pos_distributor b where a.id_dis=b.id_dis and a.no_faktur=''";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.no_faktur  = res.getString(1);
              this.tgl_masuk  = res.getString(2);
              this.id_dis  = res.getString(3);
              this.id_peg  = res.getString(4);
              this.total  = res.getDouble(5);
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
              sql = "INSERT INTO pos_brgmasuk VALUES(?,?,?,?,?)";
          }
          else
          {
              sql = "UPDATE pos_brgmasuk SET no_faktur=?,tgl_masuk=?,id_dis=?,id_peg=?,total=? WHERE no_faktur='"+ no_faktur +"'";
          }
              PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_faktur);
              stat.setString(2,this.tgl_masuk);
              stat.setString(3,this.id_dis);
              stat.setString(4,this.id_peg);
              stat.setDouble(5,this.total);
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
          sql = "INSERT INTO pos_brgmasuk VALUES(?,?,?,?,?)";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_faktur);
              stat.setString(2,this.tgl_masuk);
              stat.setString(3,this.id_dis);
              stat.setString(4,this.id_peg);
              stat.setDouble(5,this.total);
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
              sql = "UPDATE pos_brgmasuk SET tgl_masuk=?,id_dis=?,id_peg=?,total=? WHERE no_faktur='"+ no_faktur +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.tgl_masuk);
              stat.setString(2,this.id_dis);
              stat.setString(3,this.id_peg);
              stat.setDouble(4,this.total);
              stat.executeUpdate();
              stat.close();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
  }

  public void Delete(String no_faktur)
  {
      try
      {
          _Cnn = getCn.getConnection();
          String sql = "DELETE FROM pos_brgmasuk WHERE no_faktur='"+ no_faktur +"'";
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
