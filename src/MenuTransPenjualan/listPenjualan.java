package MenuTransPenjualan;

import MenuBarang.*;
import Class.DBO;
import Class.Barang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class listPenjualan extends javax.swing.JFrame {
    private DefaultTableModel _tbl_penjualan;
    Connection _Cnn;
    DBO getCnn = new DBO();
    String _User;
    public listPenjualan() {
        initComponents();
        String[] kolom = {"No. Faktur","Tgl Transaksi","No. Member","Total","Discon","Total+Discon","Jml Bayar","Kembalian","Keterangan"};
        _tbl_penjualan = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.Double.class,
               java.lang.Double.class,
               java.lang.Double.class,
               java.lang.Double.class,
               java.lang.Double.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tbl_penjualan.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        tbPenjualan.setModel(_tbl_penjualan);
        LoadPenjualan();
    }
    public void HapusTabel(){
        int row = _tbl_penjualan.getRowCount();
        for (int i = 0;i < row;i++){
            _tbl_penjualan.removeRow(0);
        }
    }
    void LoadData(){
        try{
            _Cnn = null;
            DBO getCnn = new DBO();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            String sql = "select no_faktur, tgl_penjualan, no_member, total, disc, (total-(total*disc/100)) as tot_disc, ket, jml_bayar, jml_kembali "
                    + "from pos_penjualan";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_faktur = res.getString(1);
                String tgl_penjualan = res.getString(2);
                String no_member = res.getString(3);
                String total = res.getString(4);
                Double disc = res.getDouble(5);
                Double tot_disc = res.getDouble(6);
                String ket = res.getString(7);
                Double jml_bayar = res.getDouble(8);
                Double jml_kembali = res.getDouble(9);
                Object[] data = {no_faktur, tgl_penjualan, no_member, total, disc, tot_disc, ket, jml_bayar, jml_kembali};
                _tbl_penjualan.addRow(data);
            }
            tbPenjualan.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbPenjualan.getColumnModel().getColumn(1).setPreferredWidth(75);
            tbPenjualan.getColumnModel().getColumn(2).setPreferredWidth(125);
            tbPenjualan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(4).setPreferredWidth(50);
            tbPenjualan.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(8).setPreferredWidth(200);
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    
    public void LoadPenjualan(){
        try{
            _Cnn = null;
            DBO getCnn = new DBO();
            _Cnn = getCnn.getConnection();
            HapusTabel();   
            //String sql = "" +
            //         "   SELECT pj.faktur,pj.tanggal,cus.nama,fk.bayar" +
            //         "   FROM ttrs_penjualan pj" +
            //         "   	,mstr_customer cus" +
            //         "   	,(	SELECT sum( (prd.harga * pd.qty) - ((prd.harga * pd.qty) * (pd.diskon/100))) as bayar,pd.faktur" +
            //         "   		FROM ttrs_penjualan_detail pd" +
            //         "   			,mstr_product prd" +
            //         "   		WHERE pd.prd_id=prd.prd_id" +
            //         "   		GROUP BY pd.faktur ) fk" +
            //         "   WHERE pj.faktur=fk.faktur" +
            //         "   	AND pj.cust_id=cus.cust_id";
            Statement stat = _Cnn.createStatement();
            String sql = "" +
                    "   SELECT a.no_faktur, a.tgl_penjualan, a.no_member, a.total, a.disc, ((a.total)-(a.total*a.disc/100)) as total_akhir, "
                    + "a.jml_bayar, a.jml_kembali, a.ket FROM pos_penjualan a order by a.no_faktur asc" ;
                    //"         OR b.nm_member LIKE'%"+ TxtSearch.getText() +"%' ";
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_faktur = res.getString(1);
                String tgl_penjualan = res.getString(2);
                String nm_member = res.getString(3);
                Double total = res.getDouble(4);
                Double disc = res.getDouble(5);
                Double total_akhir = res.getDouble(6);
                Double jml_bayar = res.getDouble(7);
                Double jml_kembali = res.getDouble(8);
                String ket = res.getString(9);
                Object[] data = {no_faktur,tgl_penjualan,nm_member,total,disc,total_akhir,jml_bayar,jml_kembali,ket};
                _tbl_penjualan.addRow(data);
            }
            tbPenjualan.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbPenjualan.getColumnModel().getColumn(1).setPreferredWidth(75);
            tbPenjualan.getColumnModel().getColumn(2).setPreferredWidth(125);
            tbPenjualan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(4).setPreferredWidth(50);
            tbPenjualan.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(8).setPreferredWidth(200);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    
    private void filter_penjualan(){
        try{
            SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
            String t1 = tanggal.format(dtTglAwal.getDate());
            String t2 = tanggal.format(dtTglAkhir.getDate());
            _Cnn = null;
            DBO getCnn = new DBO();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            //String sql = "" +
            //         "   SELECT pj.faktur,pj.tanggal,cus.nama,fk.bayar" +
            //         "   FROM ttrs_penjualan pj" +
            //         "   	,mstr_customer cus" +
            //         "   	,(	SELECT sum( (prd.harga * pd.qty) - ((prd.harga * pd.qty) * (pd.diskon/100))) as bayar,pd.faktur" +
            //         "   		FROM ttrs_penjualan_detail pd" +
            //         "   			,mstr_product prd" +
            //         "   		WHERE pd.prd_id=prd.prd_id" +
            //         "   		GROUP BY pd.faktur ) fk" +
            //         "   WHERE pj.faktur=fk.faktur" +
            //         "   	AND pj.cust_id=cus.cust_id";
            Statement stat = _Cnn.createStatement();
            String sql = "" +
                    "   SELECT a.no_faktur, a.tgl_penjualan, a.no_member, a.total, a.disc, ((a.total)-(a.total*a.disc/100)) as total_akhir, "
                    + "a.jml_bayar, a.jml_kembali, a.ket FROM pos_penjualan a "
                    + "where a.tgl_penjualan>='"+t1+"' and a.tgl_penjualan<='"+t2+"' order by a.no_faktur asc" ;
                    //"         OR b.nm_member LIKE'%"+ TxtSearch.getText() +"%' ";
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_faktur = res.getString(1);
                String tgl_penjualan = res.getString(2);
                String nm_member = res.getString(3);
                Double total = res.getDouble(4);
                Double disc = res.getDouble(5);
                Double total_akhir = res.getDouble(6);
                Double jml_bayar = res.getDouble(7);
                Double jml_kembali = res.getDouble(8);
                String ket = res.getString(9);
                Object[] data = {no_faktur,tgl_penjualan,nm_member,total,disc,total_akhir,jml_bayar,jml_kembali,ket};
                _tbl_penjualan.addRow(data);
            }
            tbPenjualan.getColumnModel().getColumn(0).setPreferredWidth(75);
            tbPenjualan.getColumnModel().getColumn(1).setPreferredWidth(75);
            tbPenjualan.getColumnModel().getColumn(2).setPreferredWidth(125);
            tbPenjualan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(4).setPreferredWidth(50);
            tbPenjualan.getColumnModel().getColumn(5).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(6).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(7).setPreferredWidth(100);
            tbPenjualan.getColumnModel().getColumn(8).setPreferredWidth(200);
            int dtotal = tbPenjualan.getColumnCount();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    ActionListener actionListener;
    private javax.swing.Timer timer = new javax.swing.Timer(100, actionListener);
    private void Refresh(){
        try {
            ActionListener al = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    LoadData();
                    timer.stop();
                }
            };
            timer = new javax.swing.Timer(100, al);
            timer.start();
        } catch(Exception ex) {
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnAdd = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        BtnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dtTglAkhir = new org.jdesktop.swingx.JXDatePicker();
        dtTglAwal = new org.jdesktop.swingx.JXDatePicker();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPenjualan = new javax.swing.JTable();
        btFaktur = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BtnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_obj.gif"))); // NOI18N
        BtnAdd.setText("Tambah");
        BtnAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Find.gif"))); // NOI18N
        BtnSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Tanggal");

        jLabel2.setText("s.d");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtTglAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtTglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dtTglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dtTglAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTitledPanel1.setTitle("(+) Data Penjualan");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tbPenjualan.setAutoCreateRowSorter(true);
        tbPenjualan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbPenjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPenjualan.setRowHeight(22);
        tbPenjualan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbPenjualanKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbPenjualan);

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );

        btFaktur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btFaktur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        btFaktur.setText("Faktur");
        btFaktur.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFakturActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFaktur))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    __Entry f;
    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
        try{
            f = new __Entry("", "", "Add");
            f.setVisible(true);
            f.BtnClose.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    LoadData();
                }
            });
            f.BtnSave.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Refresh();
                }
            });
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
}//GEN-LAST:event_BtnAddActionPerformed

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        try{
           filter_penjualan();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void tbPenjualanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPenjualanKeyPressed
        
    }//GEN-LAST:event_tbPenjualanKeyPressed

    private void btFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFakturActionPerformed
        cetakFaktur1();
    }//GEN-LAST:event_btFakturActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JButton btFaktur;
    private org.jdesktop.swingx.JXDatePicker dtTglAkhir;
    private org.jdesktop.swingx.JXDatePicker dtTglAwal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JTable tbPenjualan;
    // End of variables declaration//GEN-END:variables
    
    private void cetakFaktur1(){
         String kode = tbPenjualan.getValueAt(tbPenjualan.getSelectedRow(), 0).toString();
         String pth = System.getProperty("user.dir") + "/MenuReport/rpFakturAlmaura.jrxml";
        try{
            Map<String, Object> parameters = new HashMap<String, Object>();
            //_Cnn = null;
                    _Cnn = getCnn.getConnection();
            parameters.put("pNo_Faktur", kode);
            
            JasperReport jrpt = JasperCompileManager.compileReport(pth);
            JasperPrint jprint = JasperFillManager.fillReport(jrpt, parameters, _Cnn);
            
            JasperViewer.viewReport(jprint, false);
            
        }catch(Exception ex){
            JOptionPane.showConfirmDialog(null, "Tidak ada faktur", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
