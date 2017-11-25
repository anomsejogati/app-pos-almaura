package MenuGrpBarang;

import Class.DBO;
import Class.BarangGrp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class __List extends javax.swing.JFrame {
    private DefaultTableModel _tbl_grpbarang;
    Connection _Cnn;
    DBO getCnn = new DBO();
    String _User;
    public __List() {
        initComponents();
        String[] kolom = {"Kode","Kelompok"};
        _tbl_grpbarang = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tbl_grpbarang.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        tbGrpBarang.setModel(_tbl_grpbarang);
        LoadData();
    }
    public void HapusTabel(){
        int row = _tbl_grpbarang.getRowCount();
        for (int i = 0;i < row;i++){
            _tbl_grpbarang.removeRow(0);
        }
    }
    private void LoadData(){
        try{
            _Cnn = null;
            DBO getCnn = new DBO();
            _Cnn = getCnn.getConnection();
            HapusTabel();
            String sql = "select * from pos_grpbarang where kelompok like'%"+TxtSearch.getText()+"%'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String kd_group = res.getString(1);
                String kelompok = res.getString(2);
                Object[] data = {kd_group,kelompok};
                _tbl_grpbarang.addRow(data);
            }
            tbGrpBarang.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbGrpBarang.getColumnModel().getColumn(1).setPreferredWidth(700);
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
        BtnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtSearch = new javax.swing.JTextField();
        BtnSearch = new javax.swing.JButton();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbGrpBarang = new javax.swing.JTable();

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

        BtnDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete16.gif"))); // NOI18N
        BtnDelete.setText("Hapus");
        BtnDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Pencarian");

        TxtSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSearchActionPerformed(evt);
            }
        });
        TxtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtSearchKeyTyped(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTitledPanel1.setTitle("(+) Master Kelompok Barang");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbGrpBarang.setAutoCreateRowSorter(true);
        tbGrpBarang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbGrpBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbGrpBarang.setRowHeight(22);
        tbGrpBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGrpBarangMouseClicked(evt);
            }
        });
        tbGrpBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbGrpBarangKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbGrpBarang);

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void TxtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSearchKeyTyped

}//GEN-LAST:event_TxtSearchKeyTyped

    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        try{
           LoadData();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void tbGrpBarangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbGrpBarangKeyPressed
        try{
           JOptionPane.showMessageDialog(this, "TES");
           BtnDelete.setText("Hapus ? "+tbGrpBarang.getValueAt(tbGrpBarang.getSelectedRow(), 0).toString());
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_tbGrpBarangKeyPressed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
                String kode = tbGrpBarang.getValueAt(tbGrpBarang.getSelectedRow(), 0).toString();
        try {
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT * FROM pos_barang WHERE kd_group='"+kode+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if(res.first()){
                JOptionPane.showConfirmDialog(null, "Data ini masih digunakan, Anda tidak bisa menghapusnya !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }else{
                 int jawab = JOptionPane.showConfirmDialog(this,"Hapus ? Data Kelompok Barang : "+kode,"Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            BarangGrp x = new BarangGrp();
            x.DeleteGrpBrg(kode);
            LoadData();
        }
            }
        } catch(Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void TxtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSearchActionPerformed
        LoadData();
    }//GEN-LAST:event_TxtSearchActionPerformed

    private void tbGrpBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGrpBarangMouseClicked
        if(evt.getClickCount()==2){
             aksi_ubah();
        } 
    }//GEN-LAST:event_tbGrpBarangMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JTextField TxtSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JTable tbGrpBarang;
    // End of variables declaration//GEN-END:variables
    
    private void aksi_ubah(){
        
    }
}
