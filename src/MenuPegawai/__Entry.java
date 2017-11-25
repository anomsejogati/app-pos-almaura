package MenuPegawai;

import Class.DBO;
import Class.Pegawai;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
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
        this.setLocation(dimensi.width/2 - this.getWidth()/2,dimensi.height/2 - this.getHeight()/2);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnClose = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel2 = new javax.swing.JLabel();
        tID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cJnsKel = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tTmpLahir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dtTglLahir = new org.jdesktop.swingx.JXDatePicker();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tAlamat = new javax.swing.JTextField();
        tNoTelp = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSaveKeyPressed(evt);
            }
        });

        jXTitledPanel1.setTitle("(+) Form");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("ID Pegawai");

        tID.setBackground(new java.awt.Color(255, 204, 0));
        tID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tIDKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Nama Lengkap");

        tNama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tNamaKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin");

        cJnsKel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cJnsKel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laki-laki", "Perempuan" }));
        cJnsKel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cJnsKelKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Tempat lahir");

        tTmpLahir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tTmpLahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tTmpLahirKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Tanggal Lahir");

        dtTglLahir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dtTglLahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dtTglLahirKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("No. Telepon");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Alamat");

        tAlamat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tAlamatKeyReleased(evt);
            }
        });

        tNoTelp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tNoTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tNoTelpKeyReleased(evt);
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
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tAlamat)
                            .addComponent(tNoTelp)))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tTmpLahir)
                            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                                .addComponent(dtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(cJnsKel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cJnsKel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_55.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("Data Pegawai");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Form ini digunakan untuk input/update data pegawai");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void Search(){
        try {
            Pegawai x = new Pegawai();
            x.Search(_PID);
            if(x._Akses.equals("-")){
                tID.setText(x.id_peg);
                tNama.setText(x.nm_pegawai);
                cJnsKel.setSelectedItem(x.jns_kel);
                tTmpLahir.setText(x.tmp_lahir);
                String _tanggal_lahir = StringUtils.substringBeforeLast(x.tgl_lahir," ");
                dtTglLahir.setDate(java.sql.Date.valueOf(_tanggal_lahir));
                tAlamat.setText(x.alamat);
                tNoTelp.setText(x.no_telp);
                tID.setEditable(false);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        try{
            Pegawai x = new Pegawai();
            x.Search(tID.getText());
            x.id_peg =  tID.getText();
            x.nm_pegawai =  tNama.getText();
            x.jns_kel =  cJnsKel.getSelectedItem().toString();
            x.tmp_lahir =  tTmpLahir.getText();
            SimpleDateFormat t5 = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_lahir = t5.format(dtTglLahir.getDate());
            x.tgl_lahir =  tgl_lahir;
            x.alamat =  tAlamat.getText();
            x.no_telp =  tNoTelp.getText();
            if(x._Akses.equals("-")){
                x.UpdateData();
                tID.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
            }else{
                x.SaveData();
                tID.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
            }
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
}//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void tIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tIDKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String kode = tID.getText();
        try {
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT * FROM pos_pegawai WHERE id_peg='"+kode+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if(res.first()){
                JOptionPane.showConfirmDialog(null, "ID ini sudah ada, silakan buat ID yang lain !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                tID.setText("");
                this.tID.requestFocus();
                
            }else if(!tID.getText().equals("")){
                this.tNama.requestFocus();
            }
        } catch(Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }  
        }
    }//GEN-LAST:event_tIDKeyReleased

    private void tNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNamaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.cJnsKel.requestFocus();
        }
    }//GEN-LAST:event_tNamaKeyReleased

    private void cJnsKelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cJnsKelKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tTmpLahir.requestFocus();
        }
    }//GEN-LAST:event_cJnsKelKeyReleased

    private void tTmpLahirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tTmpLahirKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.dtTglLahir.requestFocus();
        }
    }//GEN-LAST:event_tTmpLahirKeyReleased

    private void dtTglLahirKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtTglLahirKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tAlamat.requestFocus();
        }
    }//GEN-LAST:event_dtTglLahirKeyReleased

    private void tAlamatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tAlamatKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tNoTelp.requestFocus();
        }
    }//GEN-LAST:event_tAlamatKeyReleased

    private void tNoTelpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNoTelpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.BtnSave.requestFocus();
        }
    }//GEN-LAST:event_tNoTelpKeyReleased

    private void BtnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSaveKeyPressed
        try{
            Pegawai x = new Pegawai();
            x.Search(tID.getText());
            x.id_peg =  tID.getText();
            x.nm_pegawai =  tNama.getText();
            x.jns_kel =  cJnsKel.getSelectedItem().toString();
            x.tmp_lahir =  tTmpLahir.getText();
            SimpleDateFormat t5 = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_lahir = t5.format(dtTglLahir.getDate());
            x.tgl_lahir =  tgl_lahir;
            x.alamat =  tAlamat.getText();
            x.no_telp =  tNoTelp.getText();
            if(x._Akses.equals("-")){
                x.UpdateData();
                tID.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
            }else{
                x.SaveData();
                tID.setEditable(false);
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");
            }
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_BtnSaveKeyPressed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnClose;
    public javax.swing.JButton BtnSave;
    private javax.swing.JComboBox cJnsKel;
    private org.jdesktop.swingx.JXDatePicker dtTglLahir;
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
    private javax.swing.JTextField tAlamat;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNoTelp;
    private javax.swing.JTextField tTmpLahir;
    // End of variables declaration//GEN-END:variables
    
}
