package MenuBarang;

import Class.DBO;
import Class.Barang;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
public class __Entry extends javax.swing.JFrame {
    Connection _Cnn;
    DBO getCnn = new DBO();
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    String _PID; // untuk primarykey
    String _Status; // save atau delete
    String _User; // pengguna
    public __Entry(String User,String pid,String status) {
        initComponents();
        _PID = pid;
        if(status.equals("edit")){
            BtnSave.setText("Update");
        }
        _Status = status;
        _User = User;
        Search();
        ListKelompok();
        
        this.setLocation(dimensi.width/2 - this.getWidth()/2,dimensi.height/2 - this.getHeight()/2);
    }

    public __Entry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnClose = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel2 = new javax.swing.JLabel();
        tKdBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tNmBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tSatuan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tHargaJual = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cKelompok = new javax.swing.JComboBox();
        tHargaNet = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tStok = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BtnClose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_logout.png"))); // NOI18N
        BtnClose.setText("Keluar");
        BtnClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });

        BtnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Ubah.gif"))); // NOI18N
        BtnSave.setText("Save");
        BtnSave.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });
        BtnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BtnSaveKeyReleased(evt);
            }
        });

        jXTitledPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jXTitledPanel1.setForeground(new java.awt.Color(255, 102, 0));
        jXTitledPanel1.setTitle("(+) Form");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jXTitledPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Kode Barang");

        tKdBarang.setBackground(new java.awt.Color(255, 204, 51));
        tKdBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tKdBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tKdBarangKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Kelompok");

        tNmBarang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tNmBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tNmBarangKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Satuan");

        tSatuan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tSatuan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tSatuanKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Harga Jual");

        tHargaJual.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tHargaJual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tHargaJual.setValue(0.0);
        tHargaJual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tHargaJualKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Harga Net");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Nama Barang");

        cKelompok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cKelompok.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih Kelompok Barang -" }));
        cKelompok.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cKelompokItemStateChanged(evt);
            }
        });

        tHargaNet.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tHargaNet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tHargaNet.setValue(0.0);
        tHargaNet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tHargaNetKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Jumlah Stok");

        tStok.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tStok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tStok.setValue(0.0);
        tStok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tStokKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tStok))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXTitledPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tSatuan))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tHargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tNmBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tNmBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tHargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_54.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setText("Data Barang");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Form ini digunakan untuk input/update data barang ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void Search(){
        try {
            Barang x = new Barang();
            x.Search(_PID);
            if(x._Akses.equals("-")){
                tKdBarang.setText(x.kd_barang);
                tNmBarang.setText(x.nm_barang);
                cKelompok.setSelectedItem(x.kd_group);
                tSatuan.setText(x.satuan);
                tHargaNet.setValue(x.harga_net);
                tHargaJual.setValue(x.harga_jual);
                tStok.setValue(x.jml_stok);
                tKdBarang.setEditable(false);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        try{
            Barang x = new Barang();
            x.Search(tKdBarang.getText());
            x.kd_barang =  tKdBarang.getText();
            x.nm_barang =  tNmBarang.getText();
            x.kd_group =  KeyKelompok[cKelompok.getSelectedIndex()];
            x.satuan =  tSatuan.getText();
            x.harga_net =  Double.parseDouble(tHargaNet.getValue().toString());
            x.harga_jual =  Double.parseDouble(tHargaJual.getValue().toString());
            x.jml_stok =  Double.parseDouble(tStok.getValue().toString());
            if(x._Akses.equals("-")){
                x.UpdateData();
                tKdBarang.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
                dispose();
            }else{
                x.SaveData();
                tKdBarang.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
                dispose();
            }
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
}//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void tKdBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tKdBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String kode = tKdBarang.getText();
        try {
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT * FROM pos_barang WHERE kd_barang='"+kode+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if(res.first()){
                JOptionPane.showConfirmDialog(null, "KODE ini sudah ada, silakan buat KODE yang lain !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                tKdBarang.setText("");
                this.tKdBarang.requestFocus();
                
            }else if(!tKdBarang.getText().equals("")){
                this.tNmBarang.requestFocus();
            }
        } catch(Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }  
        }
    }//GEN-LAST:event_tKdBarangKeyReleased

    private void tNmBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNmBarangKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String kode = tNmBarang.getText();
        try {
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT * FROM pos_barang WHERE nm_barang='"+kode+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if(res.first()){
                JOptionPane.showConfirmDialog(null, "NAMA ini sudah ada, silakan buat NAMA yang lebih spesifik !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                tNmBarang.setText("");
                this.tNmBarang.requestFocus();
                
            }else if(!tNmBarang.getText().equals("")){
                this.cKelompok.requestFocus();
            }
        } catch(Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }  
        }
    }//GEN-LAST:event_tNmBarangKeyReleased

    private void tSatuanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSatuanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tHargaNet.requestFocus();
        }
    }//GEN-LAST:event_tSatuanKeyReleased

    private void tHargaNetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tHargaNetKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tHargaJual.requestFocus();
        }
    }//GEN-LAST:event_tHargaNetKeyReleased

    private void tHargaJualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tHargaJualKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tStok.requestFocus();
        }
    }//GEN-LAST:event_tHargaJualKeyReleased

    private void tStokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tStokKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.BtnSave.requestFocus();
        }
    }//GEN-LAST:event_tStokKeyReleased

    private void BtnSaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSaveKeyReleased
        try{
            Barang x = new Barang();
            x.Search(tKdBarang.getText());
            x.kd_barang =  tKdBarang.getText();
            x.nm_barang =  tNmBarang.getText();
            x.kd_group =  KeyKelompok[cKelompok.getSelectedIndex()];
            x.satuan =  tSatuan.getText();
            x.harga_net =  Double.parseDouble(tHargaNet.getValue().toString());
            x.harga_jual =  Double.parseDouble(tHargaJual.getValue().toString());
            x.jml_stok =  Double.parseDouble(tStok.getValue().toString());
            if(x._Akses.equals("-")){
                x.UpdateData();
                tKdBarang.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
                this.dispose();
            }else{
                x.SaveData();
                tKdBarang.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
                this.dispose();
            }
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_BtnSaveKeyReleased

    private void cKelompokItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cKelompokItemStateChanged
        //set_kode_barang();
        //AutoNumber();
        buat_kode_barang();
    }//GEN-LAST:event_cKelompokItemStateChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnClose;
    public javax.swing.JButton BtnSave;
    private javax.swing.JComboBox cKelompok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JFormattedTextField tHargaJual;
    private javax.swing.JFormattedTextField tHargaNet;
    private javax.swing.JTextField tKdBarang;
    private javax.swing.JTextField tNmBarang;
    private javax.swing.JTextField tSatuan;
    private javax.swing.JFormattedTextField tStok;
    // End of variables declaration//GEN-END:variables
    String[] KeyKelompok;
    private void ListKelompok(){
        try{
             _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "" +
                    "   SELECT kd_group, kelompok from pos_grpbarang order by kelompok asc";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            //cbBarang.removeAllItems();
            int i = 1;
            while(res.next()){
                cKelompok.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyKelompok = new String[i+1];
            for(Integer x = 1;x < i;x++){
                KeyKelompok[x] = res.getString(1);
                res.next();
            }
            //res.first();
            //tHargaJual.setValue(res.getDouble(3));
            //tStok.setText(res.getString(4));
        } catch (Exception ex){
        }
    }
    
    private void set_kode_barang() {
        String kode =KeyKelompok[(cKelompok.getSelectedIndex())];
        try{          
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "select kd_barang from pos_barang where kd_group='"+KeyKelompok[(cKelompok.getSelectedIndex())]+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            res.last();
            String s,s1;
            Integer j,pnj = null;
            s=Integer.toString(res.getRow()+1);
            j=s.length();
            s1="";
            for(int i = 1;i<=pnj-j;i++){
                s1=s1+"0";
            }
            tKdBarang.setText(kode+s1+s);
            //rs.close();
            //stat.close();          
           
         }catch(Exception e){
            System.out.println("Pesan Error : "+e);
            JOptionPane.showMessageDialog(null,"Maaf, Query tidak bisa dijalankan...!!!!");
         }
    } 
    
    public void AutoNumber() {
        String kode =KeyKelompok[(cKelompok.getSelectedIndex())];
        try{          
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "select right(kd_barang,3) from pos_barang where kd_group='"+KeyKelompok[(cKelompok.getSelectedIndex())]+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if (res.next()) {
                String kd_barang = res.getString("kd_barang").substring(1);
                String AN = "" + (Integer.parseInt(kd_barang) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}
                tKdBarang.setText(kode + Nol + AN);//sesuaikan dengan variable namenya
            } else {
                tKdBarang.setText(kode+"0001");//sesuaikan dengan variable namenya
            }
           // res.close();
           // conn.close();
        } catch (Exception e) {
            e.printStackTrace();//penanganan masalah
        }
    }
    
    private void buat_kode_barang(){
        String kode =KeyKelompok[(cKelompok.getSelectedIndex())];
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "select right(kd_barang,3) from pos_barang where kd_group='"+kode+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                if(res.first()==false){
                    tKdBarang.setText(kode+"001");
                }else{
                    res.last();
                    int noBarang = res.getInt(1) + 1;
                    String no = String.valueOf(noBarang);
                    int noLong = no.length();
                    for(int a=0;a<3-noLong;a++)
		{
                    no = "0" + no;
                }
                    tKdBarang.setText(kode + no);
                }
            }
            //res.close();
            //state.close();
        }catch(Exception ex){
            System.out.println(ex);
	}
    }
}
