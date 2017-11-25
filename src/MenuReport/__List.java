package MenuReport;

import MenuTransPenjualan.__Entry;
import Class.DBO;
import Class.FrmViewReport;
import Class.Member;
import Class.Print_Faktur;
import Class.Print_Report;
import Class.Penjualan;
import Class.Penjualan_Detail;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class __List extends javax.swing.JFrame {
    private DefaultTableModel _Tampungttrs_mstr_customer;
    Connection _Cnn;
    String _User;
    public __List() {
        initComponents();
        String[] kolom = {"No","Faktur","Tanggal","Customer","Total"};
        _Tampungttrs_mstr_customer = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.Double.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _Tampungttrs_mstr_customer.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        Tblttrs_mstr_user.setModel(_Tampungttrs_mstr_customer);
        LoadData();
    }
    public void HapusTabel(){
        int row = _Tampungttrs_mstr_customer.getRowCount();
        for (int i = 0;i < row;i++){
            _Tampungttrs_mstr_customer.removeRow(0);
        }
    }
    private void LoadData(){
        try{
            Double ttl = 0.0;
            Integer urut = 1;
            _Cnn = null;
            DBO getCnn = new DBO();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            SimpleDateFormat t2 = new SimpleDateFormat("yyyy-MM-dd");
            String ttg = t2.format(TxtAwal.getDate());

            SimpleDateFormat t3 = new SimpleDateFormat("yyyy-MM-dd");
            String ttg1 = t3.format(TxtAkhir.getDate());
            
            String sql = "" +
                     "   SELECT pj.faktur,pj.tanggal,cus.nama,fk.bayar" +
                     "   FROM ttrs_penjualan pj" +
                     "   	,mstr_customer cus" +
                     "   	,(	SELECT sum( (prd.harga * pd.qty) - ((prd.harga * pd.qty) * (pd.diskon/100))) as bayar,pd.faktur" +
                     "   		FROM ttrs_penjualan_detail pd" +
                     "   			,mstr_product prd" +
                     "   		WHERE pd.prd_id=prd.prd_id" +
                     "   		GROUP BY pd.faktur ) fk" +
                     "   WHERE pj.faktur=fk.faktur" +
                     "   	AND pj.cust_id=cus.cust_id" +
                     "          AND pj.tanggal >= '"+ ttg +" 00:00:00' AND pj.tanggal <'"+ ttg1 +" 60:00:00'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String faktur = res.getString(1);
                SimpleDateFormat ta = new SimpleDateFormat("d MMMM yyyy");
                String tta = ta.format(res.getDate(2));
                String tanggal = tta;
                String nama = res.getString(3);
                Double bayar = res.getDouble(4);
                ttl += ttl+bayar;
                Object[] data = {urut++,faktur,tanggal,nama,bayar};
                _Tampungttrs_mstr_customer.addRow(data);
            }
            TxtTotal.setValue(ttl);
            Tblttrs_mstr_user.getColumnModel().getColumn(0).setPreferredWidth(40);
            Tblttrs_mstr_user.getColumnModel().getColumn(1).setPreferredWidth(80);
            Tblttrs_mstr_user.getColumnModel().getColumn(2).setPreferredWidth(80);
            Tblttrs_mstr_user.getColumnModel().getColumn(3).setPreferredWidth(300);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        BtnSearch = new javax.swing.JButton();
        TxtAkhir = new org.jdesktop.swingx.JXDatePicker();
        TxtAwal = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tblttrs_mstr_user = new javax.swing.JTable();
        TxtTotal = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        BtnSave1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_logout.png"))); // NOI18N
        jButton2.setText("Keluar");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Find.gif"))); // NOI18N
        BtnSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("Tanggal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnSearch)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(TxtAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTitledPanel1.setTitle("+ Data User");

        Tblttrs_mstr_user.setModel(new javax.swing.table.DefaultTableModel(
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
        Tblttrs_mstr_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tblttrs_mstr_userKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tblttrs_mstr_user);

        TxtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtTotal.setText("0.0");
        TxtTotal.setEnabled(false);
        TxtTotal.setValue(0.0);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Grand Total");

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel1Layout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        BtnSave1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Print16.gif"))); // NOI18N
        BtnSave1.setText("Cetak");
        BtnSave1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSave1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(506, Short.MAX_VALUE)
                .addComponent(BtnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    __Entry f;
    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        try{
           LoadData();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void Tblttrs_mstr_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tblttrs_mstr_userKeyPressed

    }//GEN-LAST:event_Tblttrs_mstr_userKeyPressed

    private void BtnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSave1ActionPerformed
        try{
            HashMap param = new HashMap();
            param.put("total", TxtTotal.getValue());

            Print_Report bku = new Print_Report(_Tampungttrs_mstr_customer);
            String fileName = "./print/report.jasper";
            FrmViewReport viewer = new FrmViewReport(bku,fileName,param);
            viewer.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showConfirmDialog(this, ex);
        }
    }//GEN-LAST:event_BtnSave1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnSave1;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JTable Tblttrs_mstr_user;
    private org.jdesktop.swingx.JXDatePicker TxtAkhir;
    private org.jdesktop.swingx.JXDatePicker TxtAwal;
    private javax.swing.JFormattedTextField TxtTotal;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    // End of variables declaration//GEN-END:variables
    
}
