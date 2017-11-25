package MenuReturPenjualan;

import Class.DBO;
import Class.ReturPenjualan;
import Class.ReturPenjualan_Detail;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import MenuReturPenjualan.__List;
import java.util.Date;
public class __Entry extends javax.swing.JFrame {
    Connection _Cnn;
    DBO getCnn = new DBO();
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    private DefaultTableModel _TblReturPenjualan_Detail;
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
       actionDisable();
        this.setLocation(dimensi.width/2 - this.getWidth()/2,dimensi.height/2 - this.getHeight()/2);
        String[] kolom = {"No. Retur","Kode Barang","Nama Barang","Jumlah","Harga","Sub Total"};
        _TblReturPenjualan_Detail = new DefaultTableModel(null,kolom){
        Class[] types = new Class [] {
           java.lang.String.class,
           java.lang.String.class,
           java.lang.String.class,
           java.lang.Integer.class,
           java.lang.Double.class,
           java.lang.Double.class
        };
        public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
        }
        };
        tbTabel.setModel(_TblReturPenjualan_Detail);
        LoadData();
        tbTabel.getColumnModel().getColumn(0).setPreferredWidth(150);
        tbTabel.getColumnModel().getColumn(1).setPreferredWidth(75);
        tbTabel.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbTabel.getColumnModel().getColumn(3).setPreferredWidth(75);
        tbTabel.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbTabel.getColumnModel().getColumn(5).setPreferredWidth(100);
    }
    public void HapusTabel(){
        int row = _TblReturPenjualan_Detail.getRowCount();
        for (int i = 0;i < row;i++){
                _TblReturPenjualan_Detail.removeRow(0);
        }
    }
    private void LoadData(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            HapusTabel();
            String sql = "select a.no_retur, a.kd_barang, b.nm_barang, a.jumlah, a.harga, (a.jumlah*a.harga) as subtotal from pos_retpenjualandet a, pos_barang b "
                    + "where a.kd_barang=b.kd_barang and a.no_retur='"+tNoRetur.getText()+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_retur = res.getString(1);
                String kd_barang = res.getString(2);
                String nm_barang = res.getString(3);
                Integer jumlah = res.getInt(4);
                Double harga = res.getDouble(5);
                Double subtotal = res.getDouble(6);
                Object[] data = {no_retur,kd_barang,nm_barang,jumlah,harga,subtotal};
                _TblReturPenjualan_Detail.addRow(data);
            } 
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sql = "select sum(a.jumlah*a.harga) from pos_retpenjualandet a, pos_barang b where a.kd_barang=b.kd_barang "
                    + "and a.no_retur='"+tNoRetur.getText()+"'";
            stat = _Cnn.createStatement();
            res = stat.executeQuery(sql);
            while(res.next()){
                tTotal.setValue(res.getDouble(1));
            }
            
            btBaru.setFocusable(true);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
        
    }
    
    private void ClearDetailTrans(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "select a.no_retur, a.kd_barang, b.nm_barang, a.harga, a.jumlah, (a.jumlah*a.harga) as subtotal from pos_retpenjualandet a, pos_barang b "
                    + "where a.kd_barang=b.kd_barang and a.no_retur='"+tNoRetur.getText()+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_retur = res.getString(1);
                String kd_barang = res.getString(2);
                String nm_barang = res.getString(3);
                Integer jumlah = res.getInt(4);
                Double harga = res.getDouble(5);
                Double subtotal = res.getDouble(6);
                Object[] data = {no_retur,kd_barang,nm_barang,jumlah,harga,subtotal};
                _TblReturPenjualan_Detail.addRow(data);
            } 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        dtTanggal = new org.jdesktop.swingx.JXDatePicker();
        jLabel2 = new javax.swing.JLabel();
        tNoRetur = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tNoFaktur = new javax.swing.JTextField();
        tMember = new javax.swing.JTextField();
        jXTitledPanel2 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTabel = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tHarga = new javax.swing.JFormattedTextField();
        BtnDelete = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tJumlah = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tTotal = new javax.swing.JFormattedTextField();
        btSave = new javax.swing.JButton();
        tKdBarang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        BtnClose = new javax.swing.JButton();
        btBaru = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                FormClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                FormClosing(evt);
            }
        });

        jXTitledPanel1.setInheritAlpha(false);
        jXTitledPanel1.setTitle(" + Manipulasi Transaksi");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dtTanggal.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("No. Retur");

        tNoRetur.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tNoRetur.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tNoRetur.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("No. Nota / Faktur");

        tNoFaktur.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tNoFaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNoFakturActionPerformed(evt);
            }
        });
        tNoFaktur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tNoFakturFocusLost(evt);
            }
        });

        tMember.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tMember.setForeground(new java.awt.Color(51, 51, 51));
        tMember.setCaretColor(new java.awt.Color(240, 240, 240));
        tMember.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tMember.setEnabled(false);

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addComponent(tNoRetur, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                        .addComponent(tNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tMember)))
                .addContainerGap())
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNoRetur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTitledPanel2.setTitle("------- >Detail Transaksi");
        jXTitledPanel2.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tbTabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTabel.setRowHeight(20);
        jScrollPane1.setViewportView(tbTabel);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("Barang");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setText("Harga - Jumlah Retur");

        tHarga.setBackground(new java.awt.Color(255, 204, 102));
        tHarga.setForeground(new java.awt.Color(255, 255, 255));
        tHarga.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tHarga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tHarga.setCaretColor(new java.awt.Color(255, 255, 255));
        tHarga.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tHarga.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tHarga.setValue(0.0);

        BtnDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/btn_delete.png"))); // NOI18N
        BtnDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        BtnSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add_obj.gif"))); // NOI18N
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

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("  -");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tJumlah.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tJumlah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tJumlah.setText("0");
        tJumlah.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJumlahActionPerformed(evt);
            }
        });
        tJumlah.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tJumlahFocusLost(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("Total : Rp. ");

        tTotal.setBorder(null);
        tTotal.setForeground(new java.awt.Color(255, 0, 0));
        tTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tTotal.setText("0.0");
        tTotal.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        tTotal.setEnabled(false);
        tTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tTotal.setValue(0.0);

        btSave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        tKdBarang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tKdBarang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tKdBarang.setText("[ Input Kode Barang ]");
        tKdBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tKdBarangMouseClicked(evt);
            }
        });
        tKdBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tKdBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXTitledPanel2Layout = new javax.swing.GroupLayout(jXTitledPanel2.getContentContainer());
        jXTitledPanel2.getContentContainer().setLayout(jXTitledPanel2Layout);
        jXTitledPanel2Layout.setHorizontalGroup(
            jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btSave))
                .addContainerGap())
        );
        jXTitledPanel2Layout.setVerticalGroup(
            jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navigasi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel2.setToolTipText("Navigasi");
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        BtnClose.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_logout.png"))); // NOI18N
        BtnClose.setText("Keluar");
        BtnClose.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });

        btBaru.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btBaru.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btBaru.setText("Baru");
        btBaru.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBaruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setText("Retur Penjualan");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_57.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Form ini digunakan untuk input retur penjualan, otomatis menambah jumlah stok barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXTitledPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXTitledPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    __List f;
    
    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        if(tKdBarang.getText().equals("[ Input Kode Barang ]")){
            JOptionPane.showConfirmDialog(null, "Anda belum memilih barang", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
        try{
            ReturPenjualan_Detail xs = new ReturPenjualan_Detail();
            String produk = tKdBarang.getText();
            xs.Search(tNoRetur.getText(),produk);
            xs.no_retur =  tNoRetur.getText();
            xs.kd_barang =  produk;
            xs.harga =  Double.parseDouble(tHarga.getValue().toString());
            xs.jumlah =  Integer.parseInt(tJumlah.getText());
            
            xs.SaveData();
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
        updatestokbarang();
            LoadData();
            clearformtransdet();
            btSave.setFocusable(true);
        }
}//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        if(!tTotal.getText().equals("0")){
            JOptionPane.showConfirmDialog(null, "Mohon selesaikan proses transaksi terlebih dahulu !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
        f = new __List();
        f.LoadData();
        dispose();
        }
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        String kode = tbTabel.getValueAt(tbTabel.getSelectedRow(), 1).toString();
        int jawab = JOptionPane.showConfirmDialog(this,"Delete ? "+kode,"Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            deletedet();
            ClearDetailTrans();
            LoadData();
            tJumlah.setText("0");
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void btBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBaruActionPerformed
        LoadData();
        clearformtrans();
        Date skrg= new Date();
        SimpleDateFormat format= new SimpleDateFormat("ddMMyyyy-Hmmss");
        String tgl = format.format(skrg);
        tNoRetur.setText(format.format(skrg));
        actionSave();
    }//GEN-LAST:event_btBaruActionPerformed

    private void tJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tJumlahActionPerformed

    private void tJumlahFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tJumlahFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tJumlahFocusLost

    private void FormClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FormClosed
        // TODO add your handling code here:
        f = new __List();
        f.LoadData();
    }//GEN-LAST:event_FormClosed

    private void BtnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSaveKeyPressed
                try{
            ReturPenjualan_Detail xs = new ReturPenjualan_Detail();
            String produk = tKdBarang.getText();
            xs.Search(tNoRetur.getText(),produk);
            xs.no_retur =  tNoRetur.getText();
            xs.kd_barang =  produk;
            xs.jumlah =  Integer.parseInt(tJumlah.getText());
            xs.harga =  Double.parseDouble(tHarga.getValue().toString());
            xs.SaveData();
            
            JOptionPane.showMessageDialog(null, "Berhasil");
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
        updatestokbarang();
            LoadData();
            clearformtransdet();
            btSave.setFocusable(true);

    }//GEN-LAST:event_BtnSaveKeyPressed

    private void FormClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FormClosing
        f = new MenuReturPenjualan.__List();
        f.LoadData();
        dispose();
    }//GEN-LAST:event_FormClosing

    private void tNoFakturFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tNoFakturFocusLost
        
    }//GEN-LAST:event_tNoFakturFocusLost

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        String no_member = null;
        try{
            
            SimpleDateFormat t2 = new SimpleDateFormat("yyyy-MM-dd");
            String t = t2.format(dtTanggal.getDate());
            String no_retur = tNoRetur.getText();
            String no_faktur = tNoFaktur.getText();
            Double total = Double.parseDouble(tTotal.getValue().toString());
           
                    String sql = "select no_member from pos_penjualan where no_faktur='"+tNoFaktur.getText()+"'";
                    _Cnn = null;
                    _Cnn = getCnn.getConnection();
                    Statement state = _Cnn.createStatement();
                    
                    ResultSet res = state.executeQuery(sql);
                    while(res.next()){
                    no_member = res.getString(1);
                    }
               
                    String sqlinsert = "insert into pos_retpenjualan values ('"+no_retur+"','"+no_faktur+"', '"+t+"', "
                        + " '"+no_member+"', '"+total+"')";
                    
                    
                state.executeUpdate(sqlinsert);
                
                            
                tNoRetur.setEditable(false);
            
            //LoadData();
            clearformtrans();
            ClearDetailTrans();
            LoadData();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            actionDisable();
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
        f = new __List();
                //x.search;
                f.LoadData();  
                
    }//GEN-LAST:event_btSaveActionPerformed

    private void tNoFakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNoFakturActionPerformed
        String id_dist = null;
        ListProduct();
        try {
            
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT a.no_faktur, a.no_member, b.nm_member FROM pos_penjualan a, pos_member b "
                    + "  WHERE a.no_member=b.no_member and a.no_faktur='"+tNoFaktur.getText()+"'";

            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                id_dist = res.getString(3);
            }
            tMember.setText(id_dist);
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tNoFakturActionPerformed

    private void tKdBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKdBarangMouseClicked
        if(tKdBarang.getText().equals("[ Input Kode Barang ]")){
            tKdBarang.setText("");
            tKdBarang.requestFocus(true);
        }
    }//GEN-LAST:event_tKdBarangMouseClicked

    private void tKdBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKdBarangActionPerformed
        try {
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT harga_net, jml_stok FROM pos_barang WHERE kd_barang='"+ tKdBarang.getText() +"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                tHarga.setValue(res.getDouble(1));

            }
        } catch(Exception ex) {
            // JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tKdBarangActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnClose;
    private javax.swing.JButton BtnDelete;
    public javax.swing.JButton BtnSave;
    public javax.swing.JButton btBaru;
    public javax.swing.JButton btSave;
    private org.jdesktop.swingx.JXDatePicker dtTanggal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel2;
    private javax.swing.JFormattedTextField tHarga;
    private javax.swing.JTextField tJumlah;
    private javax.swing.JTextField tKdBarang;
    private javax.swing.JTextField tMember;
    private javax.swing.JTextField tNoFaktur;
    private javax.swing.JTextField tNoRetur;
    private javax.swing.JFormattedTextField tTotal;
    private javax.swing.JTable tbTabel;
    // End of variables declaration//GEN-END:variables
    String[] KeyProduct;
    private void ListProduct(){
        try{
             _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "" +
                    "   SELECT a.kd_barang, a.nm_barang, a.harga_jual, a.jml_stok, b.no_faktur " +
                    "   FROM pos_barang a, pos_penjualandet b where a.kd_barang=b.kd_barang and b.no_faktur='"+tNoFaktur.getText()+"' order by kelompok asc";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            int i = 1;
            while(res.next()){
                //cbBarang.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyProduct = new String[i+1];
            for(Integer x = 1;x < i;x++){
                KeyProduct[x] = res.getString(1);
                res.next();
            }
        } catch (Exception ex){
        }
    }
    
    private void clearformtrans(){
        tNoRetur.setText("");
        tNoFaktur.setText("");
        tMember.setText("");
        tHarga.setText("0");
        tJumlah.setText("0");
        tTotal.setText("0");
        tKdBarang.setText("[ Input Kode Barang ]");
        
    }
    
    private void clearformtransdet(){
        tHarga.setText("0");
        tJumlah.setText("0");
        tKdBarang.setText("[ Input Kode Barang ]");
        
    }
    
    private void set_no_faktur() { 
     try{ 
         _Cnn = getCnn.getConnection();
         Statement stat = _Cnn.createStatement();
         ResultSet rs = stat.executeQuery("select no_faktur from pos_penjualan");
        
        int brs=0; 
        while(rs.next()) 
        { 
          brs=rs.getRow(); 
        } 
        if(brs==0) 
            tNoFaktur.setText("1"); 
        else 
        {int nom=brs+1; 
            tNoFaktur.setText(Integer.toString(nom)); 
        } 
            rs.close(); 
       } 
         catch(SQLException e) 
         { 
             System.out.println("Error : "+e); 
         } 
    }
    
    private void updatestokbarang(){
        int jml=0, stok=0;
        String sql = "select jml_stok from pos_barang where kd_barang='"+tKdBarang.getText()+"'";
        try{ 
         _Cnn = getCnn.getConnection();
         Statement stat = _Cnn.createStatement();
         ResultSet rs = stat.executeQuery(sql);
         while(rs.next()) {
             jml=Integer.parseInt(rs.getString(1));
         }
         stok = jml + Integer.parseInt(tJumlah.getText());
         String sqlupdate = "update pos_barang set jml_stok='"+stok+"' where kd_barang='"+tKdBarang.getText()+"'";
         try{ 
             _Cnn = getCnn.getConnection();
         Statement state = _Cnn.createStatement();
         state.executeUpdate(sqlupdate);
         }catch(SQLException e) { 
 
         } 
        }catch(SQLException e) { 
 
         } 
        
    }
    
    private void deletedet(){
        int jml=0, stok=0, jumlah=0, stok1=0;
        String kode1, kode2;
        String qty;
        kode1 = tbTabel.getValueAt(tbTabel.getSelectedRow(), 0).toString();
        kode2 = tbTabel.getValueAt(tbTabel.getSelectedRow(), 1).toString();
        try
      {
          String sql = "DELETE FROM pos_retpenjualandet WHERE no_retur='"+ kode1 +"' and kd_barang='"+kode2+"'";
          _Cnn = null;
                    _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sql);
          
          String sqlstok = "select jml_stok from pos_barang where kd_barang='"+kode2+"'";
                ResultSet rs = state.executeQuery(sqlstok);
          while(rs.next()) {
             jml=Integer.parseInt(rs.getString(1));
         }          
         qty = tbTabel.getValueAt(tbTabel.getSelectedRow(), 3).toString();
         tJumlah.setText(qty);
         
         int qty1 = Integer.parseInt(tJumlah.getText());
         stok = (int) jml - qty1;
         
         String sqlupdate = "update pos_barang set jml_stok='"+stok+"' where kd_barang='"+kode2+"'";
         state.executeUpdate(sqlupdate);
         
         String sqljumlah = "select jumlah from pos_retpenjualandet where no_retur='"+kode1+"' and kd_barang='"+kode2+"'";
                ResultSet res = state.executeQuery(sqljumlah);
          while(res.next()) {
             jumlah=Integer.parseInt(res.getString(1));
         }          
         
         stok1 = (int) jumlah - qty1;
         
         String sqlupdate1 = "update pos_retpenjualandet set jumlah='"+stok1+"' where no_retur='"+kode1+"' and kd_barang='"+kode2+"'";
         state.executeUpdate(sqlupdate);
          
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
    }
    
    private void actionDisable(){
        dtTanggal.setEnabled(false);
        tKdBarang.setEnabled(false);
        tNoFaktur.setEnabled(false);
        tHarga.setEnabled(false);
        tJumlah.setEnabled(false);
        BtnSave.setEnabled(false);
        BtnDelete.setEnabled(false);
        BtnClose.setEnabled(false);
        btBaru.setEnabled(true);
    }
    
    private void actionSave(){
        
        dtTanggal.setEnabled(true);
        tKdBarang.setEnabled(true);
        tNoFaktur.setEnabled(true);
        tHarga.setEnabled(true);
        tJumlah.setEnabled(true);
        BtnSave.setEnabled(true);
        BtnDelete.setEnabled(true);
        BtnClose.setEnabled(true);
        btBaru.setEnabled(false);
    }

    
}
