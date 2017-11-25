package MenuTransBrgMasuk;

import Class.DBO;
import Class.BarangMasuk;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
public class __Entry extends javax.swing.JFrame {
    Connection _Cnn;
    DBO getCnn = new DBO();
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    private DefaultTableModel _TblBrgMasuk_Detail;
    String _PID; // untuk primarykey
    String _Status; // save atau delete
    String _User; // pengguna
    
    public __Entry(String User,String pid,String status) {
        initComponents();
        ListCustomer();
        //ListProduct();
        ListPegawai();
        actionDisable();
        _PID = pid;
        if(status.equals("edit")){
            BtnSave.setText("Update");
        }
        _Status = status;
        _User = User;
        
        Search();
        this.setLocation(dimensi.width/2 - this.getWidth()/2,dimensi.height/2 - this.getHeight()/2);
        String[] kolom = {"No. Faktur","Kode Barang","Nama Barang","Jumlah","Harga Baru","Subtotal"};
        _TblBrgMasuk_Detail = new DefaultTableModel(null,kolom){
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
        tbTransDetail.setModel(_TblBrgMasuk_Detail);
        LoadData();
        tbTransDetail.getColumnModel().getColumn(0).setPreferredWidth(75);
        tbTransDetail.getColumnModel().getColumn(1).setPreferredWidth(75);
        tbTransDetail.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbTransDetail.getColumnModel().getColumn(3).setPreferredWidth(75);
        tbTransDetail.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbTransDetail.getColumnModel().getColumn(5).setPreferredWidth(100);
    }
    
    public void HapusTabel(){
        int row = _TblBrgMasuk_Detail.getRowCount();
        for (int i = 0;i < row;i++){
                _TblBrgMasuk_Detail.removeRow(0);
        }
    }
    
    private void LoadData(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            HapusTabel();
            String sql = "select a.no_faktur, a.kd_barang, b.nm_barang, a.jumlah, a.harganet_baru, a.subtotal from pos_brgmasukdet a, pos_barang b "
                    + "where a.kd_barang=b.kd_barang and a.no_faktur='"+tNoFaktur.getText()+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_faktur = res.getString(1);
                String kd_barang = res.getString(2);
                String nm_barang = res.getString(3);
                Integer jumlah = res.getInt(4);
                Double harga_jual = res.getDouble(5);
                Double subtotal = res.getDouble(6);
                Object[] data = {no_faktur,kd_barang,nm_barang,jumlah,harga_jual,subtotal};
                _TblBrgMasuk_Detail.addRow(data);
            } 
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sql = "select sum(subtotal) as subtotal from pos_brgmasukdet "
                    + "where no_faktur='"+tNoFaktur.getText()+"'";
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
            String sql = "select a.no_faktur, a.kd_barang, b.nm_barang, a.jumlah, a.harganet_baru, a.subtotal from pos_brgmasukdet a, pos_barang b "
                    + "where a.kd_barang=b.kd_barang and a.no_faktur='"+tNoFaktur.getText()+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_faktur = res.getString(1);
                String kd_barang = res.getString(2);
                String nm_barang = res.getString(3);
                Integer jumlah = res.getInt(4);
                Double harga_baru = res.getDouble(5);
                Double subtotal = res.getDouble(6);
                Object[] data = {no_faktur,kd_barang,nm_barang,jumlah,harga_baru,subtotal};
                _TblBrgMasuk_Detail.addRow(data);
            } 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel2 = new javax.swing.JLabel();
        tNoFaktur = new javax.swing.JTextField();
        dtTanggal = new org.jdesktop.swingx.JXDatePicker();
        cDistributor = new javax.swing.JComboBox();
        cPegawai = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jXTitledPanel2 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTransDetail = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tHargaJual = new javax.swing.JFormattedTextField();
        BtnDelete = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        tJumlah = new javax.swing.JTextField();
        btBayar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        tTotal = new javax.swing.JFormattedTextField();
        tHargaNet = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tKdBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnClose = new javax.swing.JButton();
        btBaru = new javax.swing.JButton();

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
        jXTitledPanel1.setTitle("(+) Form");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Faktur");

        tNoFaktur.setEditable(false);
        tNoFaktur.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dtTanggal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        cDistributor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cDistributor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih Distributor -" }));
        cDistributor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cDistributorItemStateChanged(evt);
            }
        });

        cPegawai.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cPegawai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Pilih Pegawai Penerima -" }));
        cPegawai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cPegawaiItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cDistributor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cPegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_57.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("Transaksi Barang Masuk");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Form ini digunakan untuk input barang masuk, otomatis menambah jumlah stok barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 506, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXTitledPanel2.setTitle("(+) Detail Transaksi");
        jXTitledPanel2.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tbTransDetail.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tbTransDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        tbTransDetail.setRowHeight(20);
        tbTransDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTransDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTransDetail);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Harga Net");

        tHargaJual.setBackground(new java.awt.Color(255, 255, 204));
        tHargaJual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tHargaJual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tHargaJual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tHargaJual.setCaretColor(new java.awt.Color(255, 255, 255));
        tHargaJual.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tHargaJual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tHargaJual.setValue(0.0);

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

        tJumlah.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tJumlah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tJumlah.setText("0");
        tJumlah.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tJumlahFocusLost(evt);
            }
        });

        btBayar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/btn_save.png"))); // NOI18N
        btBayar.setText("Save");
        btBayar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btBayar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBayarActionPerformed(evt);
            }
        });
        btBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btBayarKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel17.setText("Total : Rp. ");

        tTotal.setBorder(null);
        tTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tTotal.setText("0.0");
        tTotal.setCaretColor(new java.awt.Color(204, 204, 204));
        tTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tTotal.setEnabled(false);
        tTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tTotal.setValue(0.0);

        tHargaNet.setBackground(new java.awt.Color(255, 255, 204));
        tHargaNet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tHargaNet.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tHargaNet.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tHargaNet.setCaretColor(new java.awt.Color(255, 255, 255));
        tHargaNet.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tHargaNet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tHargaNet.setValue(0.0);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Harga Jual");

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

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText(" Barang");

        javax.swing.GroupLayout jXTitledPanel2Layout = new javax.swing.GroupLayout(jXTitledPanel2.getContentContainer());
        jXTitledPanel2.getContentContainer().setLayout(jXTitledPanel2Layout);
        jXTitledPanel2Layout.setHorizontalGroup(
            jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel2Layout.createSequentialGroup()
                        .addComponent(btBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tHargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                                .addComponent(tHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jXTitledPanel2Layout.setVerticalGroup(
            jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tHargaNet, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBayar)
                .addContainerGap(16, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXTitledPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 690, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXTitledPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXTitledPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    __List f;
    
    private void Search(){
        try {
            BarangMasuk x = new BarangMasuk();
            x.Search(_PID);
            if(x._Akses.equals("-")){
                tNoFaktur.setText(x.no_faktur);
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                 String sql = "SELECT nm_distributor FROM pos_distributor WHERE id_dis='"+ x.id_dis +"'";
                Statement stat = _Cnn.createStatement();
                ResultSet res = stat.executeQuery(sql);
                while(res.next()){
                    cDistributor.setSelectedItem(res.getString(1).toString());
                }
                tNoFaktur.setEditable(false);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
       
        if(!tTotal.getText().equals("0")){
            JOptionPane.showConfirmDialog(null, "Mohon selesaikan proses transaksi terlebih dahulu !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
            f = new __List();
            f.LoadData();
            dispose();
        }   
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void btBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBaruActionPerformed
        // TODO add your handling code here: 
        ClearDetailTrans();
        clearformtransdet();
        clearformtrans();
        LoadData();
        
        set_no_faktur();
        actionSave();
        //cKdBarang.setSelectedIndex(0);
        //cMember.setSelectedIndex(0);
    }//GEN-LAST:event_btBaruActionPerformed

    private void FormClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FormClosed
        // TODO add your handling code here:
        f = new __List();
        f.LoadData();
    }//GEN-LAST:event_FormClosed

    private void FormClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FormClosing
        f = new __List();
        f.LoadData();
        dispose();
    }//GEN-LAST:event_FormClosing

    private void btBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btBayarKeyPressed
        try{
            BarangMasuk x = new BarangMasuk();
            x.Search(tNoFaktur.getText());
            x.no_faktur =  tNoFaktur.getText();
            SimpleDateFormat t2 = new SimpleDateFormat("yyyy-MM-dd");
            String t = t2.format(dtTanggal.getDate());
            x.tgl_masuk =  t;
            x.id_dis =  KeyCustomer[cDistributor.getSelectedIndex()];
            x.id_peg =  KeyPegawai[cPegawai.getSelectedIndex()];
            x.total =  Double.parseDouble(tTotal.getValue().toString());

            String no_faktur = tNoFaktur.getText();
            String id_dis = KeyCustomer[cDistributor.getSelectedIndex()];
            String id_peg = KeyPegawai[cPegawai.getSelectedIndex()];
            Double total = Double.parseDouble(tTotal.getValue().toString());
            String sqlinsert = "insert into pos_brgmasuk values ('"+no_faktur+"', '"+t+"', "
            + " '"+id_dis+"', '"+id_peg+"','"+total+"')";
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sqlinsert);
            }catch(SQLException e) {

            }
            f = new __List();
            //x.search;
            f.LoadData();
            x.Refresh();

            tNoFaktur.setEditable(false);

            //LoadData();
            clearformtrans();
            ClearDetailTrans();

            JOptionPane.showMessageDialog(null, "Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btBayarKeyPressed

    private void btBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBayarActionPerformed
        try{
            BarangMasuk x = new BarangMasuk();
            x.Search(tNoFaktur.getText());
            x.no_faktur =  tNoFaktur.getText();
            SimpleDateFormat t2 = new SimpleDateFormat("yyyy-MM-dd");
            String t = t2.format(dtTanggal.getDate());
            x.tgl_masuk =  t;
            x.id_dis =  KeyCustomer[cDistributor.getSelectedIndex()];
            x.id_peg =  KeyPegawai[cPegawai.getSelectedIndex()];
            x.total =  Double.parseDouble(tTotal.getValue().toString());

            String no_faktur = tNoFaktur.getText();
            String id_dis = KeyCustomer[cDistributor.getSelectedIndex()];
            String id_peg = KeyPegawai[cPegawai.getSelectedIndex()];
            Double total = Double.parseDouble(tTotal.getValue().toString());
            String sqlinsert = "insert into pos_brgmasuk values ('"+no_faktur+"', '"+t+"', "
            + " '"+id_dis+"', '"+id_peg+"','"+total+"')";
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sqlinsert);
            }catch(SQLException e) {

            }
            f = new __List();
            //x.search;
            f.LoadData();
            x.Refresh();

            tNoFaktur.setEditable(false);
            actionDisable();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        ClearDetailTrans();
        clearformtransdet();
        clearformtrans();
        LoadData();
    }//GEN-LAST:event_btBayarActionPerformed

    private void tJumlahFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tJumlahFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_tJumlahFocusLost

    private void BtnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSaveKeyPressed
        String no_faktur = tNoFaktur.getText();
            String kd_barang = tKdBarang.getText();
            Integer jumlah = Integer.parseInt(tJumlah.getText());
            Double harga_baru = Double.parseDouble(tHargaNet.getValue().toString());
            Double subtotal = jumlah * harga_baru;
            String sqlinsert = "insert into pos_brgmasukdet values ('"+no_faktur+"', '"+kd_barang+"', "
            + " '"+jumlah+"', '"+harga_baru+"','"+subtotal+"')";
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sqlinsert);
            }catch(SQLException e) {

            }
        updatestokbarang();
        LoadData();
        clearformtransdet();
        btBayar.setFocusable(true);
    }//GEN-LAST:event_BtnSaveKeyPressed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        if(tKdBarang.getText().equals("- Pilih Barang -")){
            JOptionPane.showConfirmDialog(null, "Anda harus memilih barang terlebih dahulu !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
            String no_faktur = tNoFaktur.getText();
            String kd_barang = tKdBarang.getText();
            Integer jumlah = Integer.parseInt(tJumlah.getText());
            Double harganet_baru = Double.parseDouble(tHargaNet.getValue().toString());
            Double hargajual_baru = Double.parseDouble(tHargaJual.getValue().toString());
            
            Double subtotal = jumlah * harganet_baru;
            
            String sqlinsert = "insert into pos_brgmasukdet values ('"+no_faktur+"', '"+kd_barang+"', "
            + " '"+jumlah+"', '"+harganet_baru+"', '"+hargajual_baru+"', '"+subtotal+"')";
            try{
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sqlinsert);
            }catch(SQLException e) {

            }
        updatestokbarang();
        LoadData();
        clearformtransdet();
        btBayar.setFocusable(true);
        }
        
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        String kode = tbTransDetail.getValueAt(tbTransDetail.getSelectedRow(), 1).toString();
        if(kode == null){
            JOptionPane.showConfirmDialog(null, "Anda belum memilih data untuk dihapus !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
         int jawab = JOptionPane.showConfirmDialog(this,"Delete ? "+kode,"Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            //updatestokbarang2();
            deletedet();
            //updatestokbarang2();
            ClearDetailTrans();
            clearformtransdet();
            LoadData();
        }   
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void cDistributorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cDistributorItemStateChanged
        
    }//GEN-LAST:event_cDistributorItemStateChanged

    private void cPegawaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cPegawaiItemStateChanged
        
    }//GEN-LAST:event_cPegawaiItemStateChanged

    private void tbTransDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTransDetailMouseClicked
        String qty = tbTransDetail.getValueAt(tbTransDetail.getSelectedRow(), 3).toString();
         tJumlah.setText(qty);
    }//GEN-LAST:event_tbTransDetailMouseClicked

    private void tKdBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKdBarangActionPerformed
        try {
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT harga_jual, jml_stok FROM pos_barang WHERE kd_barang='"+ tKdBarang.getText() +"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                tHargaJual  .setValue(res.getDouble(1));
                
            }
        } catch(Exception ex) {
            // JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tKdBarangActionPerformed

    private void tKdBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tKdBarangMouseClicked
        if(tKdBarang.getText().equals("[ Input Kode Barang ]")){
            tKdBarang.setText("");
            tKdBarang.requestFocus(true);
        }
    }//GEN-LAST:event_tKdBarangMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnClose;
    private javax.swing.JButton BtnDelete;
    public javax.swing.JButton BtnSave;
    public javax.swing.JButton btBaru;
    private javax.swing.JButton btBayar;
    private javax.swing.JComboBox cDistributor;
    private javax.swing.JComboBox cPegawai;
    private org.jdesktop.swingx.JXDatePicker dtTanggal;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel2;
    private javax.swing.JFormattedTextField tHargaJual;
    private javax.swing.JFormattedTextField tHargaNet;
    private javax.swing.JTextField tJumlah;
    private javax.swing.JTextField tKdBarang;
    private javax.swing.JTextField tNoFaktur;
    private javax.swing.JFormattedTextField tTotal;
    private javax.swing.JTable tbTransDetail;
    // End of variables declaration//GEN-END:variables
    String[] KeyProduct;
    private void ListProduct(){
        try{
             _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "" +
                    "   SELECT kd_barang, nm_barang, harga_jual, jml_stok " +
                    "   FROM pos_barang";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            //cbBarang.removeAllItems();
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
    String[] KeyCustomer;
    private void ListCustomer(){
        try{
             _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "" +
                    "   SELECT id_dis,nm_distributor " +
                    "   FROM pos_distributor";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            //cMember.removeAllItems();
            int i = 1;
            while(res.next()){
                cDistributor.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyCustomer = new String[i+1];
            for(Integer x = 1;x < i;x++){
                KeyCustomer[x] = res.getString(1);
                res.next();
            }
        } catch (Exception ex){
        }
    }
    String[] KeyPegawai;
    private void ListPegawai(){
        try{
             _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "" +
                    "   SELECT id_peg,nm_pegawai " +
                    "   FROM pos_pegawai";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            //cMember.removeAllItems();
            int i = 1;
            while(res.next()){
                cPegawai.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyPegawai = new String[i+1];
            for(Integer x = 1;x < i;x++){
                KeyPegawai[x] = res.getString(1);
                res.next();
            }
        } catch (Exception ex){
        }
    }
    
    private void clearformtrans(){
        tNoFaktur.setText("");
        tHargaNet.setText("0.0");;
        tHargaJual.setText("0.0");
        tJumlah.setText("0");
        tTotal.setText("0");
        cDistributor.setSelectedIndex(0);
        tKdBarang.setText("[ Input Kode Barang ]");
        cPegawai.setSelectedIndex(0);
        
    }
    
    private void clearformtransdet(){
        tHargaNet.setText("0.0");;
        tHargaJual.setText("0.0");
        tJumlah.setText("0");
        tKdBarang.setText("[ Input Kode Barang ]");
        
    }
    
    private void set_no_faktur() { 
     try{ 
         _Cnn = getCnn.getConnection();
         Statement stat = _Cnn.createStatement();
         ResultSet rs = stat.executeQuery("select no_faktur from pos_brgmasuk");
        
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
        double harga_net = Double.parseDouble(tHargaNet.getValue().toString());
        double harga_jual = Double.parseDouble(tHargaJual.getValue().toString());
        String sql = "select jml_stok from pos_barang where kd_barang='"+tKdBarang.getText()+"'";
        try{ 
         _Cnn = getCnn.getConnection();
         Statement stat = _Cnn.createStatement();
         ResultSet rs = stat.executeQuery(sql);
         while(rs.next()) {
             jml=Integer.parseInt(rs.getString(1));
         }
         stok = jml + Integer.parseInt(tJumlah.getText());
         String sqlupdate = "update pos_barang set jml_stok='"+stok+"', harga_net='"+harga_net+"',"
                 + "harga_jual='"+harga_jual+"' where kd_barang='"+tKdBarang.getText()+"'";
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
        int jml=0, stok=0;
        String kode1, kode2;
        
        kode1 = tbTransDetail.getValueAt(tbTransDetail.getSelectedRow(), 0).toString();
        kode2 = tbTransDetail.getValueAt(tbTransDetail.getSelectedRow(), 1).toString();
        try
      {
          String sql = "DELETE FROM pos_brgmasukdet WHERE no_faktur='"+ kode1 +"' and kd_barang='"+kode2+"'";
          _Cnn = null;
                    _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sql);
          
          String sqlstok = "select jml_stok from pos_barang where kd_barang='"+kode2+"'";
                ResultSet rs = state.executeQuery(sqlstok);
          while(rs.next()) {
             jml=Integer.parseInt(rs.getString(1));
         }          
         
         
         int qty1 = Integer.parseInt(tJumlah.getText());
         stok = (int) jml - qty1;
         
         String sqlupdate = "update pos_barang set jml_stok='"+stok+"' where kd_barang='"+kode2+"'";
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
        cPegawai.setEnabled(false);
        cDistributor.setEnabled(false);
        tHargaNet.setEnabled(false);
        tHargaJual.setEnabled(false);
        tJumlah.setEnabled(false);
        btBayar.setEnabled(false);
        BtnSave.setEnabled(false);
        BtnDelete.setEnabled(false);
        BtnClose.setEnabled(false);
        btBaru.setEnabled(true);
    }
    
    private void actionSave(){
        dtTanggal.setEnabled(true);
        tKdBarang.setEnabled(true);
        cPegawai.setEnabled(true);
        cDistributor.setEnabled(true);
        tHargaNet.setEnabled(true);
        tHargaJual.setEnabled(true);
        tJumlah.setEnabled(true);
        btBayar.setEnabled(true);
        BtnSave.setEnabled(true);
        BtnDelete.setEnabled(true);
        BtnClose.setEnabled(true);
        btBaru.setEnabled(false);
    }
    
}
