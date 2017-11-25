package Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Penjualan {
Connection _Cnn;
DBO getCn = new DBO();

  public String no_faktur;
  public String tgl_penjualan;
  public String no_member;
  public Double total, disc, jml_bayar, jml_kembali;
  public String _Akses = "";

  public void Search(String no_faktur)
  {
      try
      {
          _Akses = "";
          _Cnn = getCn.getConnection();
          String SQL = "select * from pos_penjualan a, pos_member b where a.no_member=b.no_member and a.no_faktur='"+ no_faktur +"'";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.no_faktur  = res.getString(1);
              this.tgl_penjualan  = res.getString(2);
              this.no_member  = res.getString(3);
              this.total  = res.getDouble(4);
              this.disc  = res.getDouble(5);
              this.jml_bayar  = res.getDouble(6);
              this.jml_kembali  = res.getDouble(7);
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
          String SQL = "select * from pos_penjualan a, pos_member b where a.no_member=b.no_member and a.no_faktur=''";
          Statement stat = _Cnn.createStatement();
          ResultSet res = stat.executeQuery(SQL);
          while (res.next())
          {
              _Akses = "-";
              this.no_faktur  = res.getString(1);
              this.tgl_penjualan  = res.getString(2);
              this.no_member  = res.getString(3);
              this.total  = res.getDouble(4);
              this.disc  = res.getDouble(5);
              this.jml_bayar  = res.getDouble(6);
              this.jml_kembali  = res.getDouble(7);
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
              sql = "INSERT INTO pos_penjualan VALUES(?,?,?,?,?,?,?)";
          }
          else
          {
              sql = "UPDATE pos_penjualan SET no_faktur=?,tgl_penjualan=?,no_member=?,total=?,disc=?,jml_bayar=?,jml_kembali=? WHERE no_faktur='"+ no_faktur +"'";
          }
              PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_faktur);
              stat.setString(2,this.tgl_penjualan);
              stat.setString(3,this.no_member);
              stat.setDouble(4,this.total);
              stat.setDouble(5,this.disc);
              stat.setDouble(6,this.jml_bayar);
              stat.setDouble(7,this.jml_kembali);
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
          sql = "INSERT INTO pos_penjualan VALUES(?,?,?,?,?,?,?)";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.no_faktur);
              stat.setString(2,this.tgl_penjualan);
              stat.setString(3,this.no_member);
              stat.setDouble(4,this.total);
              stat.setDouble(5,this.disc);
              stat.setDouble(6,this.jml_bayar);
              stat.setDouble(7,this.jml_kembali);
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
              sql = "UPDATE pos_penjualan SET tgl_penjualan=?,no_member=?,total=?,disc=?,jml_bayar=?,jml_kembali=? WHERE no_faktur='"+ no_faktur +"'";
          PreparedStatement stat = _Cnn.prepareStatement(sql);
              stat.setString(1,this.tgl_penjualan);
              stat.setString(2,this.no_member);
              stat.setDouble(3,this.total);
              stat.setDouble(4,this.disc);
              stat.setDouble(5,this.jml_bayar);
              stat.setDouble(6,this.jml_kembali);
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
          String sql = "DELETE FROM pos_penjualan WHERE no_faktur='"+ no_faktur +"'";
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
