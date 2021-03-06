package MenuReturPenjualan;

import Class.DBO;
import Class.Member;
import Class.ReturPenjualan;
import Class.ReturPenjualan_Detail;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class __List extends javax.swing.JFrame {
    private DefaultTableModel _Tbl_Retur_Penjualan;
    Connection _Cnn;
    String _User;
    public __List() {
        initComponents();
        String[] kolom = {"No. Retur", "No. Faktur","Tanggal Retur","Member","Jumlah Retur","Total"};
        _Tbl_Retur_Penjualan = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.Double.class,
               java.lang.Double.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _Tbl_Retur_Penjualan.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        tbReturPenjualan.setModel(_Tbl_Retur_Penjualan);
        LoadData();
    }
    public void HapusTabel(){
        int row = _Tbl_Retur_Penjualan.getRowCount();
        for (int i = 0;i < row;i++){
            _Tbl_Retur_Penjualan.removeRow(0);
        }
    }
    public void LoadData(){
        try{
            _Cnn = null;
            DBO getCnn = new DBO();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            Statement stat = _Cnn.createStatement();
            String sql = "" +
                    "   SELECT a.no_retur, a.no_faktur, a.tgl_retur, b.nm_member, count(c.no_retur) as jml_retur, a.total"
                    + " FROM pos_retpenjualan a, pos_member b, pos_retpenjualandet c " +
                    "   WHERE a.no_member=b.no_member and a.no_retur=c.no_retur group by no_retur" ;
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_retur = res.getString(1);
                String no_faktur = res.getString(2);
                String tgl_retur = res.getString(3);
                String nm_member = res.getString(4);
                Double jml_retur = res.getDouble(5);
                Double total = res.getDouble(6);
                Object[] data = {no_retur,no_faktur,tgl_retur,nm_member,jml_retur,total};
                _Tbl_Retur_Penjualan.addRow(data);
            }
            tbReturPenjualan.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbReturPenjualan.getColumnModel().getColumn(1).setPreferredWidth(10);
            tbReturPenjualan.getColumnModel().getColumn(2).setPreferredWidth(10);
            tbReturPenjualan.getColumnModel().getColumn(3).setPreferredWidth(25);
            tbReturPenjualan.getColumnModel().getColumn(4).setPreferredWidth(5);
            tbReturPenjualan.getColumnModel().getColumn(5).setPreferredWidth(10);
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
        dtTglAwal = new org.jdesktop.swingx.JXDatePicker();
        dtTglAkhir = new org.jdesktop.swingx.JXDatePicker();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReturPenjualan = new javax.swing.JTable();

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
                .addComponent(dtTglAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtTglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(dtTglAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dtTglAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTitledPanel1.setTitle("(+) Data Retur Penjualan");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tbReturPenjualan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbReturPenjualan.setForeground(new java.awt.Color(51, 51, 51));
        tbReturPenjualan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbReturPenjualan.setRowHeight(22);
        tbReturPenjualan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbReturPenjualanKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbReturPenjualan);

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tbReturPenjualanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbReturPenjualanKeyPressed
        
    }//GEN-LAST:event_tbReturPenjualanKeyPressed

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        try{
            filter_data();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_BtnSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnSearch;
    private org.jdesktop.swingx.JXDatePicker dtTglAkhir;
    private org.jdesktop.swingx.JXDatePicker dtTglAwal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JTable tbReturPenjualan;
    // End of variables declaration//GEN-END:variables
    
    private void filter_data(){
        try{
            SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
            String t1 = tanggal.format(dtTglAwal.getDate());
            String t2 = tanggal.format(dtTglAkhir.getDate());
            _Cnn = null;
            DBO getCnn = new DBO();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            Statement stat = _Cnn.createStatement();
            String sql = "" +
                    "   SELECT a.no_retur, a.no_faktur, a.tgl_retur, b.nm_member, count(c.no_retur) as jml_retur, a.total"
                    + " FROM pos_retpenjualan a, pos_member b, pos_retpenjualandet c " +
                    "   WHERE a.no_member=b.no_member and a.no_retur=c.no_retur and a.tgl_retur>='"+t1+"' and a.tgl_retur<='"+t2+"' group by no_retur" ;
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_retur = res.getString(1);
                String no_faktur = res.getString(2);
                String tgl_retur = res.getString(3);
                String nm_member = res.getString(4);
                Double jml_retur = res.getDouble(5);
                Double total = res.getDouble(6);
                Object[] data = {no_retur,no_faktur,tgl_retur,nm_member,jml_retur,total};
                _Tbl_Retur_Penjualan.addRow(data);
            }
            tbReturPenjualan.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbReturPenjualan.getColumnModel().getColumn(1).setPreferredWidth(10);
            tbReturPenjualan.getColumnModel().getColumn(2).setPreferredWidth(10);
            tbReturPenjualan.getColumnModel().getColumn(3).setPreferredWidth(25);
            tbReturPenjualan.getColumnModel().getColumn(4).setPreferredWidth(5);
            tbReturPenjualan.getColumnModel().getColumn(5).setPreferredWidth(10);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    
}
