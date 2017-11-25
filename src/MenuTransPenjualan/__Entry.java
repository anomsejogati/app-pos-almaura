package MenuTransPenjualan;

import Class.DBO;
import Class.Member;
import Class.Penjualan;
import Class.Penjualan_Detail;
import MenuTransPenjualan.listPenjualan;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
public class __Entry extends javax.swing.JFrame {
    Connection _Cnn;
    DBO getCnn = new DBO();
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    private DefaultTableModel _TblTransPenjualan_Detail;
    String _PID; // untuk primarykey
    String _Status; // save atau delete
    String _User; // pengguna
    
    public __Entry(String User,String pid,String status) {
        initComponents();
        //ListCustomer();
        //ListProduct();
        actionDisable();
        _PID = pid;
        if(status.equals("edit")){
            BtnSave.setText("Update");
        }
        _Status = status;
        _User = User;
        
        //Search();
        this.setLocation(dimensi.width/2 - this.getWidth()/2,dimensi.height/2 - this.getHeight()/2);
        String[] kolom = {"No. Faktur","Kode Barang","Nama Barang","Harga","Qty","Disc. Item","Sub Total"};
        _TblTransPenjualan_Detail = new DefaultTableModel(null,kolom){
        Class[] types = new Class [] {
           java.lang.String.class,
           java.lang.String.class,
           java.lang.String.class,
           java.lang.Double.class,
           java.lang.Integer.class,
           java.lang.Double.class,
           java.lang.Double.class
        };
        public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
        }
        };
        tbTransDetail.setModel(_TblTransPenjualan_Detail);
        LoadData();
        tbTransDetail.getColumnModel().getColumn(0).setPreferredWidth(75);
        tbTransDetail.getColumnModel().getColumn(1).setPreferredWidth(75);
        tbTransDetail.getColumnModel().getColumn(2).setPreferredWidth(200);
        tbTransDetail.getColumnModel().getColumn(3).setPreferredWidth(75);
        tbTransDetail.getColumnModel().getColumn(4).setPreferredWidth(50);
        tbTransDetail.getColumnModel().getColumn(5).setPreferredWidth(50);
        tbTransDetail.getColumnModel().getColumn(6).setPreferredWidth(100);
    }
    public void HapusTabel(){
        int row = _TblTransPenjualan_Detail.getRowCount();
        for (int i = 0;i < row;i++){
                _TblTransPenjualan_Detail.removeRow(0);
        }
    }
    private void LoadData(){
        try{
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            HapusTabel();
            String sql = "select a.no_faktur, a.kd_barang, b.nm_barang, b.harga_jual, a.qty, a.disc_item,a.subtotal from pos_penjualandet a, pos_barang b "
                    + "where a.kd_barang=b.kd_barang and a.no_faktur='"+tNoFaktur.getText()+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_faktur = res.getString(1);
                String kd_barang = res.getString(2);
                String nm_barang = res.getString(3);
                Double harga_jual = res.getDouble(4);
                Integer qty = res.getInt(5);
                Double disc_item = res.getDouble(6);
                Double subtotal = res.getDouble(7);
                Object[] data = {no_faktur,kd_barang,nm_barang,harga_jual,qty,disc_item,subtotal};
                _TblTransPenjualan_Detail.addRow(data);
            } 
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            sql = "select sum(subtotal) from pos_penjualandet a, pos_barang b where a.kd_barang=b.kd_barang "
                    + "and a.no_faktur='"+tNoFaktur.getText()+"'";
            stat = _Cnn.createStatement();
            res = stat.executeQuery(sql);
            while(res.next()){
                tTotal.setValue(res.getDouble(1));
                tTotal1.setValue(res.getDouble(1));
            }
            double disc;
            double total;
            double totakhir;
            //String member = cMember.getSelectedItem().toString();
            disc = Double.parseDouble(tDiskon.getValue().toString());
            total = Double.parseDouble(tTotal.getValue().toString());
            if (total>=100000){
                
                disc = 10;
                tDiskon.setValue(10);
                tDiskon1.setValue(10);
                totakhir = total - total*disc/100;
                tTotalAkhir.setValue(totakhir);
                tTotAkhir1.setValue(totakhir);
            }else if(total < 100000 && rbNonMember.isSelected()){
                disc = 0;
                tDiskon.setValue(0);
                tDiskon1.setValue(0);
                totakhir = total - total*disc/100;
                tTotalAkhir.setValue(totakhir);
                tTotAkhir1.setValue(totakhir);
            }else if(total < 100000 && rbMember.isSelected()){
                disc = 0;
                tDiskon.setValue(0);
                tDiskon1.setValue(0);
                totakhir = total - total*disc/100;
                tTotalAkhir.setValue(totakhir);
                tTotAkhir1.setValue(totakhir);
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
            String sql = "select a.no_faktur, a.kd_barang, b.nm_barang, b.harga_jual, a.qty, a.subtotal from pos_penjualandet a, pos_barang b "
                    + "where a.kd_barang=b.kd_barang and a.no_faktur='"+tNoFaktur.getText()+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                String no_faktur = res.getString(1);
                String kd_barang = res.getString(2);
                String nm_barang = res.getString(3);
                Double harga_jual = res.getDouble(4);
                Integer qty = res.getInt(5);
                Double subtotal = res.getDouble(6);
                Object[] data = {no_faktur,kd_barang,nm_barang,harga_jual,qty,subtotal};
                _TblTransPenjualan_Detail.addRow(data);
            } 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error : " + ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel2 = new javax.swing.JLabel();
        tNoFaktur = new javax.swing.JTextField();
        dtTanggal = new org.jdesktop.swingx.JXDatePicker();
        rbMember = new javax.swing.JRadioButton();
        rbNonMember = new javax.swing.JRadioButton();
        tNoMember = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        tTotal = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        tDiskon = new javax.swing.JFormattedTextField();
        tTotalAkhir = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jXTitledPanel2 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTransDetail = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tHargaJual = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tSubtotal = new javax.swing.JFormattedTextField();
        BtnDelete = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        txtQty = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tStok = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tBayar = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        tKembali = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        btBayar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tTotal1 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        tDiskon1 = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        tTotAkhir1 = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        tKeterangan = new javax.swing.JTextField();
        tDiskonItem = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tKdBarang = new javax.swing.JTextField();
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
        jXTitledPanel1.setTitle(" + Manipulasi Transaksi");
        jXTitledPanel1.setTitleFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("Faktur");

        tNoFaktur.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        dtTanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        buttonGroup1.add(rbMember);
        rbMember.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbMember.setText("Member");
        rbMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMemberActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNonMember);
        rbNonMember.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbNonMember.setText("Non Member");
        rbNonMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNonMemberActionPerformed(evt);
            }
        });

        tNoMember.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tNoMember.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tNoMember.setText("[ Input No. Member ]");
        tNoMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tNoMemberMouseClicked(evt);
            }
        });
        tNoMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNoMemberActionPerformed(evt);
            }
        });
        tNoMember.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tNoMemberKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jXTitledPanel1Layout = new javax.swing.GroupLayout(jXTitledPanel1.getContentContainer());
        jXTitledPanel1.getContentContainer().setLayout(jXTitledPanel1Layout);
        jXTitledPanel1Layout.setHorizontalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbMember, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNonMember, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tNoMember, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jXTitledPanel1Layout.setVerticalGroup(
            jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbMember, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbNonMember, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNoMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Monospaced", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 102, 0));
        jLabel17.setText("Total : Rp. ");

        tTotal.setBorder(null);
        tTotal.setForeground(new java.awt.Color(255, 102, 0));
        tTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tTotal.setText("0.0");
        tTotal.setDisabledTextColor(new java.awt.Color(255, 102, 0));
        tTotal.setEnabled(false);
        tTotal.setFont(new java.awt.Font("Monospaced", 1, 48)); // NOI18N
        tTotal.setValue(0.0);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diskon", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 0, 13), new java.awt.Color(255, 153, 0))); // NOI18N

        tDiskon.setBorder(null);
        tDiskon.setForeground(new java.awt.Color(255, 153, 0));
        tDiskon.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tDiskon.setText("0.0");
        tDiskon.setDisabledTextColor(new java.awt.Color(255, 153, 0));
        tDiskon.setEnabled(false);
        tDiskon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tDiskon.setValue(0.0);

        tTotalAkhir.setBorder(null);
        tTotalAkhir.setForeground(new java.awt.Color(255, 153, 0));
        tTotalAkhir.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tTotalAkhir.setText("0.0");
        tTotalAkhir.setDisabledTextColor(new java.awt.Color(255, 153, 0));
        tTotalAkhir.setEnabled(false);
        tTotalAkhir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tTotalAkhir.setSelectionColor(new java.awt.Color(255, 255, 255));
        tTotalAkhir.setValue(0.0);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("%");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Rp. ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(tDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(tTotalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(tTotalAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jXTitledPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jXTitledPanel2.setTitle("------- >Detail Transaksi");
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
        tbTransDetail.setRowHeight(22);
        jScrollPane1.setViewportView(tbTransDetail);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("Barang");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setText("Harga - Stok");

        tHargaJual.setBackground(new java.awt.Color(255, 204, 102));
        tHargaJual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tHargaJual.setForeground(new java.awt.Color(255, 255, 255));
        tHargaJual.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tHargaJual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tHargaJual.setCaretColor(new java.awt.Color(255, 255, 255));
        tHargaJual.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tHargaJual.setEnabled(false);
        tHargaJual.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tHargaJual.setValue(0.0);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setText("Qty");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel8.setText("Sub Total");

        tSubtotal.setBackground(new java.awt.Color(255, 204, 102));
        tSubtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tSubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tSubtotal.setText("0.0");
        tSubtotal.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tSubtotal.setEnabled(false);
        tSubtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tSubtotal.setValue(0.0);

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

        txtQty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtQty.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQty.setText("0");
        txtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtyFocusLost(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("-");

        tStok.setBackground(new java.awt.Color(255, 204, 102));
        tStok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tStok.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tStok.setText("0");
        tStok.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        tStok.setEnabled(false);
        tStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tStokActionPerformed(evt);
            }
        });
        tStok.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tStokFocusLost(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Input Pembayaran"));

        tBayar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tBayar.setText("0.0");
        tBayar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tBayar.setValue(0.0);
        tBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBayarActionPerformed(evt);
            }
        });
        tBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tBayarKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Bayar");

        tKembali.setBackground(new java.awt.Color(240, 240, 240));
        tKembali.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tKembali.setText("0.0");
        tKembali.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tKembali.setEnabled(false);
        tKembali.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tKembali.setValue(0.0);

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Kembali");

        btBayar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Wallet -+ Money.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btBayar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total.");

        tTotal1.setBackground(new java.awt.Color(240, 240, 240));
        tTotal1.setBorder(null);
        tTotal1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tTotal1.setText("0.0");
        tTotal1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tTotal1.setEnabled(false);
        tTotal1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tTotal1.setValue(0.0);

        jLabel12.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Diskon");

        tDiskon1.setBackground(new java.awt.Color(240, 240, 240));
        tDiskon1.setBorder(null);
        tDiskon1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tDiskon1.setText("0.0");
        tDiskon1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tDiskon1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tDiskon1.setValue(0.0);
        tDiskon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDiskon1ActionPerformed(evt);
            }
        });
        tDiskon1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tDiskon1FocusLost(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Tot. Akhir");

        tTotAkhir1.setBackground(new java.awt.Color(240, 240, 240));
        tTotAkhir1.setBorder(null);
        tTotAkhir1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tTotAkhir1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tTotAkhir1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tTotAkhir1.setEnabled(false);
        tTotAkhir1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tTotAkhir1.setValue(0.0);

        jLabel16.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("%");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        tKeterangan.setText("[ Keterangan : Discount Penjualan ]");

        tDiskonItem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tDiskonItem.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tDiskonItem.setText("0.0");
        tDiskonItem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tDiskonItem.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        tDiskonItem.setValue(0.0);
        tDiskonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDiskonItemActionPerformed(evt);
            }
        });
        tDiskonItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tDiskonItemFocusLost(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Disc. Item");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("%");

        tKdBarang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tKdBarang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tKdBarang.setText("[ Input Kode Barang ]");
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
                .addContainerGap()
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tDiskon1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tTotAkhir1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 66, Short.MAX_VALUE))
                                    .addComponent(tKeterangan)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tHargaJual, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .addComponent(tKdBarang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tDiskonItem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                                .addComponent(tSubtotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel2Layout.createSequentialGroup()
                    .addContainerGap(664, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(155, 155, 155)))
        );
        jXTitledPanel2Layout.setVerticalGroup(
            jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel6)
                                .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18)
                                .addComponent(tKdBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tDiskonItem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(tHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel15)
                                .addComponent(tStok, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tDiskon1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tTotAkhir1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXTitledPanel2Layout.createSequentialGroup()
                    .addContainerGap(292, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(71, 71, 71)))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btBaru, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXTitledPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXTitledPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    listPenjualan f;
    
    private void Search(){
        try {
            Penjualan x = new Penjualan();
            x.Search(_PID);
            if(x._Akses.equals("-")){
                tNoFaktur.setText(x.no_faktur);
                _Cnn = null;
                _Cnn = getCnn.getConnection();
                 String sql = "SELECT nm_member FROM pos_member WHERE no_member='"+ x.no_member +"'";
                Statement stat = _Cnn.createStatement();
                ResultSet res = stat.executeQuery(sql);
                while(res.next()){
                    //cMember.setSelectedItem(res.getString(1).toString());
                }
                tNoFaktur.setEditable(false);
            }
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        if(tKdBarang.getText().equals("")){
            JOptionPane.showConfirmDialog(null, "Anda belum memilih barang", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
            int sqty;
        double sharga,discitem;
        int ssubtotal;
        int stok;
        sqty = Integer.parseInt(txtQty.getText());
        stok = Integer.parseInt(tStok.getText());
        sharga = Double.parseDouble(tHargaJual.getValue().toString());
        discitem = Double.parseDouble(tDiskonItem.getValue().toString());
        ssubtotal =  (int) (sqty*(sharga-(sharga * discitem/100)));
        //tSubtotal.setValue(String.valueOf(ssubtotal));
        
        
        if (sqty > stok){
            JOptionPane.showMessageDialog(null,"Maaf, stok tidak memenuhi");
            txtQty.setText("0");
            
            
        }else if (sqty <= stok){
            tSubtotal.setValue(ssubtotal);
            try{
            Penjualan_Detail xs = new Penjualan_Detail();
            String produk = tKdBarang.getText();
            xs.Search(tNoFaktur.getText(),produk);
            xs.no_faktur =  tNoFaktur.getText();
            xs.kd_barang =  produk;
            xs.qty =  Integer.parseInt(txtQty.getText());
            xs.disc_item =  Double.parseDouble(tDiskonItem.getValue().toString());
            xs.subtotal =  Double.parseDouble(tSubtotal.getValue().toString());
            xs.SaveData();
            
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
        updatestokbarang();
            LoadData();
            clearformtransdet();
            tBayar.setFocusable(true);
        }
            
        }
        
}//GEN-LAST:event_BtnSaveActionPerformed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        if(!tTotal.getText().equals("0")){
            JOptionPane.showConfirmDialog(null, "Mohon selesaikan proses transaksi terlebih dahulu !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
        f = new listPenjualan();
        f.LoadData();
        dispose();
        }
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        String kode = tbTransDetail.getValueAt(tbTransDetail.getSelectedRow(), 1).toString();
        int jawab = JOptionPane.showConfirmDialog(this,"Delete ? "+kode,"Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            //updatestokbarang2();
            deletedet();
            //updatestokbarang2();
            ClearDetailTrans();
            LoadData();
        }
    }//GEN-LAST:event_BtnDeleteActionPerformed

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

    private void txtQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusLost
        // TODO add your handling code here:
        int sqty;
        double sharga;
        int ssubtotal;
        int stok;
        sqty = Integer.parseInt(txtQty.getText());
        stok = Integer.parseInt(tStok.getText());
        sharga = Double.parseDouble(tHargaJual.getValue().toString());
        ssubtotal =  (int) ( sqty * sharga);
        //tSubtotal.setValue(String.valueOf(ssubtotal));
        
        
        if (sqty > stok){
            JOptionPane.showMessageDialog(null,"Maaf, stok tidak memenuhi");
            txtQty.setText("0");
            
            
        }else if (sqty <= stok){
            tSubtotal.setValue(ssubtotal);
        }
        
        
        
    }//GEN-LAST:event_txtQtyFocusLost

    private void tBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBayarActionPerformed
        // TODO add your handling code here:
        double bayar;
        double totakhir;
        double kembali;
        totakhir = Double.parseDouble(tTotalAkhir.getValue().toString());
        bayar = Double.parseDouble(tBayar.getValue().toString());
        kembali =  (double) ( bayar - totakhir);
        //tSubtotal.setValue(String.valueOf(ssubtotal));
        tKembali.setValue(kembali);
        btBayar.setFocusable(true);
    }//GEN-LAST:event_tBayarActionPerformed

    private void tStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tStokActionPerformed

    private void tStokFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tStokFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tStokFocusLost

    private void btBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBayarActionPerformed
        Double bayar = (Double) tBayar.getValue();
        Double tot_akhir = (Double) tTotAkhir1.getValue();
        
        if(bayar<tot_akhir){
            JOptionPane.showConfirmDialog(null, "Anda salah menginputkan nominal bayar !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
            aksi_bayar();
        }
    }//GEN-LAST:event_btBayarActionPerformed

    private void FormClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FormClosed
        // TODO add your handling code here:
        f = new listPenjualan();
        f.LoadData();
    }//GEN-LAST:event_FormClosed

    private void BtnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSaveKeyPressed
         if(tKdBarang.getText().equals("")){
            JOptionPane.showConfirmDialog(null, "Anda belum memilih barang", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }else{
            int sqty;
        double sharga;
        int ssubtotal;
        int stok;
        sqty = Integer.parseInt(txtQty.getText());
        stok = Integer.parseInt(tStok.getText());
        sharga = Double.parseDouble(tHargaJual.getValue().toString());
        ssubtotal =  (int) ( sqty * sharga);
        //tSubtotal.setValue(String.valueOf(ssubtotal));
        
        
        if (sqty > stok){
            JOptionPane.showMessageDialog(null,"Maaf, stok tidak memenuhi");
            txtQty.setText("0");
            
            
        }else if (sqty <= stok){
            tSubtotal.setValue(ssubtotal);
            try{
            Penjualan_Detail xs = new Penjualan_Detail();
            String produk = tKdBarang.getText();
            xs.Search(tNoFaktur.getText(),produk);
            xs.no_faktur =  tNoFaktur.getText();
            xs.kd_barang =  produk;
            xs.qty =  Integer.parseInt(txtQty.getText());
            xs.subtotal =  Double.parseDouble(tSubtotal.getValue().toString());
            xs.SaveData();
            
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
        updatestokbarang();
            LoadData();
            clearformtransdet();
            tBayar.setFocusable(true);
        }
            
        }
    }//GEN-LAST:event_BtnSaveKeyPressed

    private void btBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btBayarKeyPressed
                try{
            Penjualan x = new Penjualan();
            x.Search(tNoFaktur.getText());
            x.no_faktur =  tNoFaktur.getText();
            SimpleDateFormat t2 = new SimpleDateFormat("yyyy-MM-dd");
            String t = t2.format(dtTanggal.getDate());
            x.tgl_penjualan =  t;
            String member;
            if(rbMember.isSelected()){
                member = tNoMember.getText();
            }else{
                member = "1";
            }
            x.no_member =  member;
            x.total =  Double.parseDouble(tTotal.getValue().toString());
            x.disc =  Double.parseDouble(tDiskon.getValue().toString());
            x.jml_bayar =  Double.parseDouble(tBayar.getValue().toString());
            x.jml_kembali =  Double.parseDouble(tKembali.getValue().toString());
            //x.id_user =  _User;
            String no_faktur = tNoFaktur.getText();
            String no_member = member;
            Double total = Double.parseDouble(tTotal.getValue().toString());
            Double diskon = Double.parseDouble(tDiskon.getValue().toString());
            Double jml_bayar =  Double.parseDouble(tBayar.getValue().toString());
            Double jml_kembali =  Double.parseDouble(tKembali.getValue().toString());
                String sqlinsert = "insert into pos_penjualan values ('"+no_faktur+"', '"+t+"', "
                        + " '"+no_member+"', '"+total+"',"
                        + " '"+diskon+"', '"+jml_bayar+"',"
                        + " '"+jml_kembali+"')";
                try{ 
                    _Cnn = null;
                    _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sqlinsert);
                }catch(SQLException e) { 

                } 
                f = new listPenjualan();
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

    private void tBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBayarKeyPressed
        double bayar;
        double totakhir;
        double kembali;
        totakhir = Double.parseDouble(tTotalAkhir.getValue().toString());
        bayar = Double.parseDouble(tBayar.getValue().toString());
        kembali =  (double) ( bayar - totakhir);
        //tSubtotal.setValue(String.valueOf(ssubtotal));
        tKembali.setValue(kembali);
        btBayar.setFocusable(true);
    }//GEN-LAST:event_tBayarKeyPressed

    private void FormClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FormClosing
        f = new listPenjualan();
        f.LoadData();
        dispose();
    }//GEN-LAST:event_FormClosing

    private void tDiskon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDiskon1ActionPerformed
        double sdisc;
        double stotal, stotakhir;
        
        sdisc = Double.parseDouble(tDiskon1.getValue().toString());
        stotal = Double.parseDouble(tTotal.getValue().toString());
        stotakhir = (double) (stotal - (stotal * sdisc / 100));
        
        tDiskon.setValue(sdisc);
        tTotalAkhir.setValue(stotakhir);
        tTotAkhir1.setValue(stotakhir);
        //tBayar.setFocusable(true);
    }//GEN-LAST:event_tDiskon1ActionPerformed

    private void tDiskon1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDiskon1FocusLost
        
    }//GEN-LAST:event_tDiskon1FocusLost

    private void tDiskonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDiskonItemActionPerformed
        double subtotal,discitem,harga, hargadisc;
        int qty;
        
        harga = Double.parseDouble(tHargaJual.getValue().toString());
        qty = Integer.parseInt(txtQty.getText());
        discitem = Double.parseDouble(tDiskonItem.getValue().toString());
        
        hargadisc = harga-(harga*discitem/100);
        subtotal = hargadisc*qty;
        tSubtotal.setValue(subtotal);
    }//GEN-LAST:event_tDiskonItemActionPerformed

    private void tDiskonItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tDiskonItemFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tDiskonItemFocusLost

    private void tKdBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tKdBarangActionPerformed
        try {
            
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT harga_jual, jml_stok FROM pos_barang WHERE kd_barang='"+ tKdBarang.getText() +"'";
            //String sql = "SELECT harga_jual, jml_stok FROM pos_barang WHERE nm_barang='"+ cbBarang.getModel()+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                tHargaJual  .setValue(res.getDouble(1));
                tStok.setText(res.getString(2));
            }
        } catch(Exception ex) {
           // JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_tKdBarangActionPerformed

    private void rbMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMemberActionPerformed
        tNoMember.setEnabled(true);
        tKeterangan.setText("Member");
    }//GEN-LAST:event_rbMemberActionPerformed

    private void rbNonMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNonMemberActionPerformed
        tNoMember.setEnabled(false);
        tKeterangan.setText("No Member");
    }//GEN-LAST:event_rbNonMemberActionPerformed

    private void tNoMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNoMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNoMemberActionPerformed

    private void tNoMemberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNoMemberKeyReleased
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String kode = tNoMember.getText();
        try {
            _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "SELECT * FROM pos_member WHERE no_member='"+kode+"'";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            if(res.first()){
                
                
                tKdBarang.setText("");
                this.tKdBarang.requestFocus();
                
            }else{
                JOptionPane.showConfirmDialog(null, "Member belum terdaftar, mungkin Anda salah menginputkan No. ID !", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(Exception ex) {
           JOptionPane.showMessageDialog(null, ex);
        }  
        }
    }//GEN-LAST:event_tNoMemberKeyReleased

    private void tNoMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tNoMemberMouseClicked
        if(tNoMember.getText().equals("[ Input No. Member ]")){
            tNoMember.setText("");
            tNoMember.requestFocus(true);
        }
            
    }//GEN-LAST:event_tNoMemberMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnClose;
    private javax.swing.JButton BtnDelete;
    public javax.swing.JButton BtnSave;
    public javax.swing.JButton btBaru;
    private javax.swing.JButton btBayar;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker dtTanggal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel2;
    private javax.swing.JRadioButton rbMember;
    private javax.swing.JRadioButton rbNonMember;
    private javax.swing.JFormattedTextField tBayar;
    private javax.swing.JFormattedTextField tDiskon;
    private javax.swing.JFormattedTextField tDiskon1;
    private javax.swing.JFormattedTextField tDiskonItem;
    private javax.swing.JFormattedTextField tHargaJual;
    private javax.swing.JTextField tKdBarang;
    private javax.swing.JFormattedTextField tKembali;
    private javax.swing.JTextField tKeterangan;
    private javax.swing.JTextField tNoFaktur;
    private javax.swing.JTextField tNoMember;
    private javax.swing.JTextField tStok;
    private javax.swing.JFormattedTextField tSubtotal;
    private javax.swing.JFormattedTextField tTotAkhir1;
    private javax.swing.JFormattedTextField tTotal;
    private javax.swing.JFormattedTextField tTotal1;
    private javax.swing.JFormattedTextField tTotalAkhir;
    private javax.swing.JTable tbTransDetail;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables
   /* String[] KeyProduct;
    private void ListProduct(){
        try{
             _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "" +
                    "   SELECT a.kd_barang, a.nm_barang, a.harga_jual, a.jml_stok " +
                    "   FROM pos_barang a, pos_grpbarang b where a.kd_group=b.kd_group order by b.kelompok asc";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            //cbBarang.removeAllItems();
            int i = 1;
            while(res.next()){
                cbBarang.addItem(res.getString(2));
                i++;
            }
            res.first();
            KeyProduct = new String[i+1];
            for(Integer x = 1;x < i;x++){
                KeyProduct[x] = res.getString(1);
                res.next();
            }
            //res.first();
            //tHargaJual.setValue(res.getDouble(3));
            //tStok.setText(res.getString(4));
        } catch (Exception ex){
        }
    }
    */
    String[] KeyCustomer;
    private void ListCustomer(){
        try{
             _Cnn = null;
            _Cnn = getCnn.getConnection();
            String sql = "" +
                    "   SELECT no_member,nm_member " +
                    "   FROM pos_member order by no_member, nm_member asc";
            Statement stat = _Cnn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            //cMember.removeAllItems();
            int i = 1;
            while(res.next()){
                //cMember.addItem(res.getString(2));
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

    DecimalFormat dfo = new DecimalFormat("#,##0");
    int harga;
    int qty;
    int hasil;
    
    private void clearformtrans(){
        tNoFaktur.setText("");
        tHargaJual.setText("0");
        txtQty.setText("0");
        tDiskonItem.setText("0");
        tStok.setText("0");
        tSubtotal.setText("0");
        tTotal.setText("0");
        tTotal1.setText("0");
        tTotalAkhir.setText("0");
        tTotAkhir1.setText("0");
        tDiskon.setText("0");
        tDiskon1.setText("0");
        tBayar.setText("0");
        tKembali.setText("0");
        //cMember.setSelectedIndex(0);
        tNoMember.setText("[ Input No. Member ]");
        buttonGroup1.clearSelection();
        tKdBarang.setText("[ Input Kode Barang ]");
        tKeterangan.setText("[ Keterangan : Discount Penjualan ]");
        
    }
    
    private void clearformtransdet(){
        tHargaJual.setText("0");
        txtQty.setText("0");
        tDiskonItem.setText("0");
        tStok.setText("0");
        tSubtotal.setText("0");
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
    
    private void updatestok(){
        int sqty;
        int sstok;
        int sstokbaru;
        
        sqty = Integer.parseInt(txtQty.getText());
        sstok = Integer.parseInt(tStok.getText());
        sstokbaru =  (int) ( sstok - sqty);
        
        try{ 
         _Cnn = getCnn.getConnection();
         Statement stat = _Cnn.createStatement();
         ResultSet rs = stat.executeQuery("update pos_barang set jml_stok="+sstokbaru+" where kd_barang='"+tKdBarang.getText()+"'");
         rs.close();  
        }catch(SQLException e) { 
 
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
         stok = jml - Integer.parseInt(txtQty.getText());
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
        int jml=0, stok=0;
        String kode1, kode2;
        String qty;
        kode1 = tbTransDetail.getValueAt(tbTransDetail.getSelectedRow(), 0).toString();
        kode2 = tbTransDetail.getValueAt(tbTransDetail.getSelectedRow(), 1).toString();
        try
      {
          String sql = "DELETE FROM pos_penjualandet WHERE no_faktur='"+ kode1 +"' and kd_barang='"+kode2+"'";
          _Cnn = null;
                    _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sql);
          
          String sqlstok = "select jml_stok from pos_barang where kd_barang='"+kode2+"'";
                ResultSet rs = state.executeQuery(sqlstok);
          while(rs.next()) {
             jml=Integer.parseInt(rs.getString(1));
         }          
         qty = tbTransDetail.getValueAt(tbTransDetail.getSelectedRow(), 4).toString();
         txtQty.setText(qty);
         
         int qty1 = Integer.parseInt(txtQty.getText());
         stok = (int) jml + qty1;
         
         String sqlupdate = "update pos_barang set jml_stok='"+stok+"' where kd_barang='"+kode2+"'";
         state.executeUpdate(sqlupdate);
          
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "ERROR : " +ex);
      }
    }
    
    private void cetakFaktur1(){
         String kode = tNoFaktur.getText();
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
    
    private void actionDisable(){
        tNoMember.setEnabled(false);
        rbMember.setEnabled(false);
        rbNonMember.setEnabled(false);
        dtTanggal.setEnabled(false);
        tKdBarang.setEnabled(false);
        tHargaJual.setEnabled(false);
        txtQty.setEnabled(false);
        tDiskonItem.setEnabled(false);
        tDiskon1.setEnabled(false);
        btBayar.setEnabled(false);
        BtnSave.setEnabled(false);
        BtnDelete.setEnabled(false);
        BtnClose.setEnabled(false);
        btBaru.setEnabled(true);
    }
    
    private void actionSave(){
        rbMember.setEnabled(true);
        rbNonMember.setEnabled(true);
        dtTanggal.setEnabled(true);
        tKdBarang.setEnabled(true);
        tHargaJual.setEnabled(true);
        txtQty.setEnabled(true);
        tDiskonItem.setEnabled(true);
        tDiskon1.setEnabled(true);
        btBayar.setEnabled(true);
        BtnSave.setEnabled(true);
        BtnDelete.setEnabled(true);
        BtnClose.setEnabled(true);
        btBaru.setEnabled(false);
    }
    
    private void aksi_bayar(){
                // TODO add your handling code here:
        double bayar;
        double totakhir;
        double kembali;
        totakhir = Double.parseDouble(tTotalAkhir.getValue().toString());
        bayar = Double.parseDouble(tBayar.getValue().toString());
        kembali =  (double) ( bayar - totakhir);
        //tSubtotal.setValue(String.valueOf(ssubtotal));
        tKembali.setValue(kembali);
        btBayar.setFocusable(true);
        try{
            Penjualan x = new Penjualan();
            x.Search(tNoFaktur.getText());
            x.no_faktur =  tNoFaktur.getText();
            SimpleDateFormat t2 = new SimpleDateFormat("yyyy-MM-dd");
            String t = t2.format(dtTanggal.getDate());
            x.tgl_penjualan =  t;
            String member;
            if(rbMember.isSelected()){
                member = tNoMember.getText();
            }else{
                member = "1";
            }
            x.no_member =  member;
            x.total =  Double.parseDouble(tTotal.getValue().toString());
            x.disc =  Double.parseDouble(tDiskon.getValue().toString());
            x.jml_bayar =  Double.parseDouble(tBayar.getValue().toString());
            x.jml_kembali =  Double.parseDouble(tKembali.getValue().toString());
            
            //x.id_user =  _User;
            String no_faktur = tNoFaktur.getText();
            String no_member = member;
            Double total = Double.parseDouble(tTotal.getValue().toString());
            Double diskon = Double.parseDouble(tDiskon.getValue().toString());
            Double jml_bayar =  Double.parseDouble(tBayar.getValue().toString());
            Double jml_kembali =  Double.parseDouble(tKembali.getValue().toString());
            String keterangan = tKeterangan.getText();
                String sqlinsert = "insert into pos_penjualan values ('"+no_faktur+"', '"+t+"', "
                        + " '"+no_member+"', '"+total+"',"
                        + " '"+diskon+"', '"+jml_bayar+"',"
                        + " '"+jml_kembali+"','"+keterangan+"')";
                try{ 
                    _Cnn = null;
                    _Cnn = getCnn.getConnection();
                Statement state = _Cnn.createStatement();
                state.executeUpdate(sqlinsert);
                JOptionPane.showMessageDialog(null, "Proses transaksi berhasil disimpan");
                }catch(SQLException e) { 

                } 
                tNoFaktur.setEditable(false);
                actionDisable();
            //LoadData();
            
        } catch(Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
        }
         String kode = tNoFaktur.getText();
                int jawab = JOptionPane.showConfirmDialog(this,"Cetak Faktur pada transaksi ini ? No. Faktur : "+kode,"Konfirmasi",JOptionPane.YES_NO_OPTION);
            if (jawab == JOptionPane.YES_OPTION){
                cetakFaktur1();
            }else if (jawab == JOptionPane.NO_OPTION){
                clearformtrans();
                ClearDetailTrans();
                LoadData();
                
            }
    }
    
}