package MenuMember;

import Class.DBO;
import Class.Member;
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
        jLabel7 = new javax.swing.JLabel();
        tAlamat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tNoTelp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cJnsKel = new javax.swing.JComboBox();
        tTmpLahir = new javax.swing.JTextField();
        dtTglLahir = new org.jdesktop.swingx.JXDatePicker();
        jLabel9 = new javax.swing.JLabel();
        cAgama = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cPendidikan = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        cStatus = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        tKota = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cPekerjaan = new javax.swing.JComboBox();
        dtTglMember = new org.jdesktop.swingx.JXDatePicker();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
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
        jXTitledPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("ID / No. Member");

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

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Alamat");

        tAlamat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tAlamatKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Telepon");

        tNoTelp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tNoTelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tNoTelpKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Tempat, Tgl Lahir");

        cJnsKel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cJnsKel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Laki-laki", "Perempuan" }));
        cJnsKel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cJnsKelKeyReleased(evt);
            }
        });

        tTmpLahir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tTmpLahir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tTmpLahirKeyReleased(evt);
            }
        });

        dtTglLahir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Agama");

        cAgama.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cAgama.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Islam", "Kristen", "Hindu", "Budha", "Konghucu" }));
        cAgama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cAgamaKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Pendidikan");

        cPendidikan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cPendidikan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SD", "SMP", "SMA", "D2", "D3", "S1", "S2", "S3" }));
        cPendidikan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cPendidikanKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Status");

        cStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Menikah", "Belum Menikah", "Pernah Menikah" }));
        cStatus.setVerifyInputWhenFocusTarget(false);
        cStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cStatusKeyReleased(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Kota");

        tKota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tKota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tKotaKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Pekerjaan");

        cPekerjaan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cPekerjaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pegawai Swasta", "Pegawai Negeri", "Guru Swasta", "Guru PNS", "Karyawan", "Pedagang", "Wiraswasta", "Buruh", "Dokter", "Ibu Rumah Tangga", "Pelajar" }));
        cPekerjaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cPekerjaanKeyReleased(evt);
            }
        });

        dtTglMember.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cJnsKel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                                    .addComponent(tTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(dtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tNoTelp))
                        .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tAlamat))
                        .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tKota))
                        .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                                    .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(12, 12, 12)
                                    .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                                            .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dtTglMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                            .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(20, 20, 20)
                            .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                                    .addComponent(cPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel14))
                                .addComponent(cStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(cAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtTglMember, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cJnsKel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(tTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dtTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cPendidikan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_55.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 0));
        jLabel13.setText("Data Member");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Form ini digunakan untuk input/update data member");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
            Member x = new Member();
            x.Search(_PID);
            if(x._Akses.equals("-")){
                tID.setText(x.no_member);
                String _tanggal_member = StringUtils.substringBeforeLast(x.tgl_member," ");
                dtTglMember.setDate(java.sql.Date.valueOf(_tanggal_member));
                tNama.setText(x.nm_member);
                cJnsKel.setSelectedItem(x.jns_kel);
                tTmpLahir.setText(x.tmp_lahir);
                String _tanggal_lahir = StringUtils.substringBeforeLast(x.tgl_lahir," ");
                dtTglLahir.setDate(java.sql.Date.valueOf(_tanggal_lahir));
                cAgama.setSelectedItem(x.agama);
                cPendidikan.setSelectedItem(x.pendidikan);
                cPekerjaan.setSelectedItem(x.pekerjaan);
                cStatus.setSelectedItem(x.status);
                tKota.setText(x.kota);
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
            Member x = new Member();
            x.Search(tID.getText());
            x.no_member =  tID.getText();
            SimpleDateFormat t4 = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_member = t4.format(dtTglMember.getDate());
            x.tgl_member =  tgl_member;
            x.nm_member =  tNama.getText();
            x.jns_kel = cJnsKel.getSelectedItem().toString();
            x.tmp_lahir =  tTmpLahir.getText();
            SimpleDateFormat t5 = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_lahir = t5.format(dtTglLahir.getDate());
            x.tgl_lahir =  tgl_lahir;
            x.agama = cAgama.getSelectedItem().toString();
            x.pendidikan = cPendidikan.getSelectedItem().toString();
            x.pekerjaan = cPekerjaan.getSelectedItem().toString();
            x.status = cStatus.getSelectedItem().toString();
            x.kota =  tKota.getText();
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
            String sql = "SELECT * FROM pos_member WHERE no_member='"+kode+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if(res.first()){
                JOptionPane.showConfirmDialog(null, "No. Member ini sudah ada, silakan buat No. Member yang lain !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
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

    private void cAgamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cAgamaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.cPendidikan.requestFocus();
        }
    }//GEN-LAST:event_cAgamaKeyReleased

    private void cPendidikanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPendidikanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.cPekerjaan.requestFocus();
        }
    }//GEN-LAST:event_cPendidikanKeyReleased

    private void cPekerjaanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPekerjaanKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.cStatus.requestFocus();
        }
    }//GEN-LAST:event_cPekerjaanKeyReleased

    private void cStatusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cStatusKeyReleased
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tKota.requestFocus();
        }
    }//GEN-LAST:event_cStatusKeyReleased

    private void tKotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tKotaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tAlamat.requestFocus();
        }
    }//GEN-LAST:event_tKotaKeyReleased

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
            Member x = new Member();
            x.Search(tID.getText());
            x.no_member =  tID.getText();
            SimpleDateFormat t4 = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_member = t4.format(dtTglMember.getDate());
            x.tgl_member =  tgl_member;
            x.nm_member =  tNama.getText();
            x.jns_kel = cJnsKel.getSelectedItem().toString();
            x.tmp_lahir =  tTmpLahir.getText();
            SimpleDateFormat t5 = new SimpleDateFormat("yyyy-MM-dd");
            String tgl_lahir = t5.format(dtTglLahir.getDate());
            x.tgl_lahir =  tgl_lahir;
            x.agama = cAgama.getSelectedItem().toString();
            x.pendidikan = cPendidikan.getSelectedItem().toString();
            x.pekerjaan = cPekerjaan.getSelectedItem().toString();
            x.status = cStatus.getSelectedItem().toString();
            x.kota =  tKota.getText();
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
    private javax.swing.JComboBox cAgama;
    private javax.swing.JComboBox cJnsKel;
    private javax.swing.JComboBox cPekerjaan;
    private javax.swing.JComboBox cPendidikan;
    private javax.swing.JComboBox cStatus;
    private org.jdesktop.swingx.JXDatePicker dtTglLahir;
    private org.jdesktop.swingx.JXDatePicker dtTglMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private javax.swing.JTextField tAlamat;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tKota;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNoTelp;
    private javax.swing.JTextField tTmpLahir;
    // End of variables declaration//GEN-END:variables
    
}
