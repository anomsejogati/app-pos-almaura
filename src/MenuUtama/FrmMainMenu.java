
package MenuUtama;

import Class.DBO;
import com.infosys.closeandmaxtabbedpane.CloseAndMaxTabbedPane;
import com.infosys.closeandmaxtabbedpane.CloseListener;
import com.infosys.closeandmaxtabbedpane.MaxListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import MenuMember.__List;
import MenuReport.frLapMemberAktif;
import MenuUser.FrSetPassword;
import MenuReport.frLapPenjualan;
import MenuTransPenjualan.frSetDiskon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author  hendra kurniawan
 */
public class FrmMainMenu extends javax.swing.JFrame {
    Connection _Cnn;
    DBO getCnn = new DBO();
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    public FrmMainMenu() {
        initComponents();
        mnTransaksi5.setVisible(false);
        tabbedPane = new CloseAndMaxTabbedPane(true);
        tabbedPane.setBounds(new Rectangle(0,0, Layar.getWidth(),Layar.getHeight()));
        Layar.getContentContainer().add(tabbedPane);
        tabbedPane.addCloseListener(new CloseListener() {
            public void closeOperation(MouseEvent e) {
                tabbedPane.remove(tabbedPane.getOverTabIndex());
            }
        });

        tabbedPane.addMaxListener(new MaxListener() {
            public void maxOperation(MouseEvent e) {
                tabbedPane.detachTab(tabbedPane.getOverTabIndex());
                tabbedPane.firePopupOutsideTabEvent(e);
            }
        });
        //tabbedPane.setSize(dimensi.width-5,dimensi.height-130);
        tabbedPane.setSize(dimensi.width-190,dimensi.height-135);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setIconImage (getToolkit().getImage("img/icon.png"));
    }
    
    Component rf;
    private CloseAndMaxTabbedPane tabbedPane = null;
    private DefaultMutableTreeNode createNodes(DefaultMutableTreeNode parent, String childList) {
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(childList);
        parent.add(child);
        return child;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Layar = new org.jdesktop.swingx.JXTitledPanel();
        jXTitledPanel2 = new org.jdesktop.swingx.JXTitledPanel();
        MnTakspan = new org.jdesktop.swingx.JXTaskPane();
        hpPegawai = new org.jdesktop.swingx.JXHyperlink();
        hpMember = new org.jdesktop.swingx.JXHyperlink();
        hpDistributor = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink10 = new org.jdesktop.swingx.JXHyperlink();
        hpMstKelompok = new org.jdesktop.swingx.JXHyperlink();
        hpBarang = new org.jdesktop.swingx.JXHyperlink();
        hpTransBrgMasuk = new org.jdesktop.swingx.JXHyperlink();
        hpReturBrgMasuk = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink4 = new org.jdesktop.swingx.JXHyperlink();
        hpTransPenjualan = new org.jdesktop.swingx.JXHyperlink();
        hpReturPenjualan = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink6 = new org.jdesktop.swingx.JXHyperlink();
        hpRepStokBarang = new org.jdesktop.swingx.JXHyperlink();
        hpRepPenjualan = new org.jdesktop.swingx.JXHyperlink();
        hpRepAktifMember = new org.jdesktop.swingx.JXHyperlink();
        jXHyperlink8 = new org.jdesktop.swingx.JXHyperlink();
        hpKeluar = new org.jdesktop.swingx.JXHyperlink();
        MnMenuBar = new javax.swing.JMenuBar();
        Menu1 = new javax.swing.JMenu();
        mnSis2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        mnSis4 = new javax.swing.JMenuItem();
        Menu2 = new javax.swing.JMenu();
        mnMaster1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        mnMaster2 = new javax.swing.JMenuItem();
        Menu3 = new javax.swing.JMenu();
        mnPersonal1 = new javax.swing.JMenuItem();
        mnPersonal2 = new javax.swing.JMenuItem();
        mnPersonal3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        Menu4 = new javax.swing.JMenu();
        mnTransaksi1 = new javax.swing.JMenuItem();
        mnTransaksi2 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnTransaksi5 = new javax.swing.JMenuItem();
        mnTransaksi3 = new javax.swing.JMenuItem();
        mnTransaksi4 = new javax.swing.JMenuItem();
        Menu5 = new javax.swing.JMenu();
        mnReport1 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnReport3 = new javax.swing.JMenuItem();
        mnReport4 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnReport8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Penjualan Almaura Butik");

        javax.swing.GroupLayout LayarLayout = new javax.swing.GroupLayout(Layar.getContentContainer());
        Layar.getContentContainer().setLayout(LayarLayout);
        LayarLayout.setHorizontalGroup(
            LayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        LayarLayout.setVerticalGroup(
            LayarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        MnTakspan.setTitle("Menu");
        MnTakspan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        hpPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pegawai.png"))); // NOI18N
        hpPegawai.setText("Data Pegawai");
        hpPegawai.setAlignmentY(2.0F);
        hpPegawai.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpPegawai.setIconTextGap(8);
        hpPegawai.setMargin(new java.awt.Insets(2, 14, 5, 14));
        hpPegawai.setPreferredSize(new java.awt.Dimension(52, 25));
        hpPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpPegawaiActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpPegawai);

        hpMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_employer.png"))); // NOI18N
        hpMember.setText("Data Member");
        hpMember.setAlignmentY(2.0F);
        hpMember.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpMember.setIconTextGap(8);
        hpMember.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpMember.setPreferredSize(new java.awt.Dimension(80, 25));
        hpMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpMemberActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpMember);

        hpDistributor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/distributor.png"))); // NOI18N
        hpDistributor.setText("Data Distributor");
        hpDistributor.setAlignmentY(2.0F);
        hpDistributor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpDistributor.setIconTextGap(8);
        hpDistributor.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpDistributor.setPreferredSize(new java.awt.Dimension(80, 25));
        hpDistributor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpDistributorActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpDistributor);

        jXHyperlink10.setText("-----------------------------------------");
        jXHyperlink10.setEnabled(false);
        MnTakspan.getContentPane().add(jXHyperlink10);

        hpMstKelompok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/barang.png"))); // NOI18N
        hpMstKelompok.setText("Kelompok Barang");
        hpMstKelompok.setAlignmentY(2.0F);
        hpMstKelompok.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpMstKelompok.setIconTextGap(8);
        hpMstKelompok.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpMstKelompok.setPreferredSize(new java.awt.Dimension(67, 25));
        hpMstKelompok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpMstKelompokActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpMstKelompok);

        hpBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/barang.png"))); // NOI18N
        hpBarang.setText("Data Barang");
        hpBarang.setAlignmentY(2.0F);
        hpBarang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpBarang.setIconTextGap(8);
        hpBarang.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpBarang.setPreferredSize(new java.awt.Dimension(67, 25));
        hpBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpBarangActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpBarang);

        hpTransBrgMasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trans-pembelian.png"))); // NOI18N
        hpTransBrgMasuk.setText("Barang Masuk");
        hpTransBrgMasuk.setAlignmentY(2.0F);
        hpTransBrgMasuk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpTransBrgMasuk.setIconTextGap(8);
        hpTransBrgMasuk.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpTransBrgMasuk.setPreferredSize(new java.awt.Dimension(80, 25));
        hpTransBrgMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpTransBrgMasukActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpTransBrgMasuk);

        hpReturBrgMasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/retur-1.png"))); // NOI18N
        hpReturBrgMasuk.setText("Retur Barang Masuk");
        hpReturBrgMasuk.setAlignmentY(2.0F);
        hpReturBrgMasuk.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpReturBrgMasuk.setIconTextGap(8);
        hpReturBrgMasuk.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpReturBrgMasuk.setPreferredSize(new java.awt.Dimension(80, 25));
        hpReturBrgMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpReturBrgMasukActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpReturBrgMasuk);

        jXHyperlink4.setText("-----------------------------------------");
        jXHyperlink4.setEnabled(false);
        MnTakspan.getContentPane().add(jXHyperlink4);

        hpTransPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trans-penjualan.png"))); // NOI18N
        hpTransPenjualan.setText("Transaksi Penjualan");
        hpTransPenjualan.setAlignmentY(2.0F);
        hpTransPenjualan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpTransPenjualan.setIconTextGap(8);
        hpTransPenjualan.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpTransPenjualan.setPreferredSize(new java.awt.Dimension(80, 25));
        hpTransPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpTransPenjualanActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpTransPenjualan);

        hpReturPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/retur-2.png"))); // NOI18N
        hpReturPenjualan.setText("Retur Penjualan");
        hpReturPenjualan.setAlignmentY(2.0F);
        hpReturPenjualan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpReturPenjualan.setIconTextGap(8);
        hpReturPenjualan.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpReturPenjualan.setPreferredSize(new java.awt.Dimension(80, 25));
        hpReturPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpReturPenjualanActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpReturPenjualan);

        jXHyperlink6.setText("-----------------------------------------");
        jXHyperlink6.setEnabled(false);
        MnTakspan.getContentPane().add(jXHyperlink6);

        hpRepStokBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report-2.png"))); // NOI18N
        hpRepStokBarang.setText("Report Stok Barang");
        hpRepStokBarang.setAlignmentY(2.0F);
        hpRepStokBarang.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpRepStokBarang.setIconTextGap(8);
        hpRepStokBarang.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpRepStokBarang.setPreferredSize(new java.awt.Dimension(62, 25));
        hpRepStokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpRepStokBarangActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpRepStokBarang);

        hpRepPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report-2.png"))); // NOI18N
        hpRepPenjualan.setText("Report Penjualan");
        hpRepPenjualan.setAlignmentY(2.0F);
        hpRepPenjualan.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpRepPenjualan.setIconTextGap(8);
        hpRepPenjualan.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpRepPenjualan.setPreferredSize(new java.awt.Dimension(62, 25));
        hpRepPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpRepPenjualanActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpRepPenjualan);

        hpRepAktifMember.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report-2.png"))); // NOI18N
        hpRepAktifMember.setText("Report Member Aktif");
        hpRepAktifMember.setAlignmentY(2.0F);
        hpRepAktifMember.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpRepAktifMember.setIconTextGap(8);
        hpRepAktifMember.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpRepAktifMember.setPreferredSize(new java.awt.Dimension(62, 25));
        hpRepAktifMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpRepAktifMemberActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpRepAktifMember);

        jXHyperlink8.setText("-----------------------------------------");
        jXHyperlink8.setEnabled(false);
        MnTakspan.getContentPane().add(jXHyperlink8);

        hpKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_logout.png"))); // NOI18N
        hpKeluar.setText("Keluar");
        hpKeluar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        hpKeluar.setMargin(new java.awt.Insets(5, 14, 5, 14));
        hpKeluar.setPreferredSize(new java.awt.Dimension(62, 25));
        hpKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hpKeluarActionPerformed(evt);
            }
        });
        MnTakspan.getContentPane().add(hpKeluar);

        javax.swing.GroupLayout jXTitledPanel2Layout = new javax.swing.GroupLayout(jXTitledPanel2.getContentContainer());
        jXTitledPanel2.getContentContainer().setLayout(jXTitledPanel2Layout);
        jXTitledPanel2Layout.setHorizontalGroup(
            jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MnTakspan, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jXTitledPanel2Layout.setVerticalGroup(
            jXTitledPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXTitledPanel2Layout.createSequentialGroup()
                .addComponent(MnTakspan, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_25.png"))); // NOI18N
        Menu1.setText("Sistem");

        mnSis2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mnSis2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/key.png"))); // NOI18N
        mnSis2.setText("Ganti Password");
        mnSis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSis2ActionPerformed(evt);
            }
        });
        Menu1.add(mnSis2);
        Menu1.add(jSeparator1);

        mnSis4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnSis4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_logout.png"))); // NOI18N
        mnSis4.setText("Keluar");
        mnSis4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSis4ActionPerformed(evt);
            }
        });
        Menu1.add(mnSis4);

        MnMenuBar.add(Menu1);

        Menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_54.png"))); // NOI18N
        Menu2.setText("Data Master");

        mnMaster1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/barang.png"))); // NOI18N
        mnMaster1.setText("Master Kelompok Barang");
        mnMaster1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMaster1ActionPerformed(evt);
            }
        });
        Menu2.add(mnMaster1);
        Menu2.add(jSeparator2);

        mnMaster2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/barang.png"))); // NOI18N
        mnMaster2.setText("Data Barang");
        mnMaster2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnMaster2ActionPerformed(evt);
            }
        });
        Menu2.add(mnMaster2);

        MnMenuBar.add(Menu2);

        Menu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tutor_login_icon.png"))); // NOI18N
        Menu3.setText("Data Personal");

        mnPersonal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pegawai.png"))); // NOI18N
        mnPersonal1.setText("Data Pegawai");
        mnPersonal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPersonal1ActionPerformed(evt);
            }
        });
        Menu3.add(mnPersonal1);

        mnPersonal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_employer.png"))); // NOI18N
        mnPersonal2.setText("Data Member");
        mnPersonal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPersonal2ActionPerformed(evt);
            }
        });
        Menu3.add(mnPersonal2);

        mnPersonal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/distributor.png"))); // NOI18N
        mnPersonal3.setText("Data Distributor");
        mnPersonal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPersonal3ActionPerformed(evt);
            }
        });
        Menu3.add(mnPersonal3);
        Menu3.add(jSeparator3);

        MnMenuBar.add(Menu3);

        Menu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_60.png"))); // NOI18N
        Menu4.setText("Transaksi");

        mnTransaksi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trans-pembelian.png"))); // NOI18N
        mnTransaksi1.setText("Transaksi Barang Masuk");
        mnTransaksi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransaksi1ActionPerformed(evt);
            }
        });
        Menu4.add(mnTransaksi1);

        mnTransaksi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/retur-1.png"))); // NOI18N
        mnTransaksi2.setText("Retur Barang Masuk");
        mnTransaksi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransaksi2ActionPerformed(evt);
            }
        });
        Menu4.add(mnTransaksi2);
        Menu4.add(jSeparator4);

        mnTransaksi5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lamp.png"))); // NOI18N
        mnTransaksi5.setText("Set Discon");
        mnTransaksi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransaksi5ActionPerformed(evt);
            }
        });
        Menu4.add(mnTransaksi5);

        mnTransaksi3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trans-penjualan.png"))); // NOI18N
        mnTransaksi3.setText("Transaksi Penjualan");
        mnTransaksi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransaksi3ActionPerformed(evt);
            }
        });
        Menu4.add(mnTransaksi3);

        mnTransaksi4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/retur-2.png"))); // NOI18N
        mnTransaksi4.setText("Retur Penjualan");
        mnTransaksi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransaksi4ActionPerformed(evt);
            }
        });
        Menu4.add(mnTransaksi4);

        MnMenuBar.add(Menu4);

        Menu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/onebit_59.png"))); // NOI18N
        Menu5.setText("Report");

        mnReport1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_report.png"))); // NOI18N
        mnReport1.setText("Report Stok Barang");
        mnReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReport1ActionPerformed(evt);
            }
        });
        Menu5.add(mnReport1);
        Menu5.add(jSeparator5);

        mnReport3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_report.png"))); // NOI18N
        mnReport3.setText("Report Data Pegawai");
        mnReport3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReport3ActionPerformed(evt);
            }
        });
        Menu5.add(mnReport3);

        mnReport4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_report.png"))); // NOI18N
        mnReport4.setText("Report Data Member");
        mnReport4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReport4ActionPerformed(evt);
            }
        });
        Menu5.add(mnReport4);
        Menu5.add(jSeparator6);

        mnReport8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/small_report.png"))); // NOI18N
        mnReport8.setText("Report Transaksi Penjualan");
        mnReport8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReport8ActionPerformed(evt);
            }
        });
        Menu5.add(mnReport8);

        MnMenuBar.add(Menu5);

        setJMenuBar(MnMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXTitledPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Layar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Layar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXTitledPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    MenuUser.FrSetPassword f;
    MenuReport.frLapPenjualan f1;
    private void mnSis4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSis4ActionPerformed
        int jawab = JOptionPane.showConfirmDialog(this,"Exit Applications ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            dispose();
            this.setVisible(false);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            System.exit(0);
        }
    }//GEN-LAST:event_mnSis4ActionPerformed

    private void mnTransaksi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransaksi1ActionPerformed
        linkbrgmasuk();
    }//GEN-LAST:event_mnTransaksi1ActionPerformed

    private void mnReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReport1ActionPerformed
        //String kode = tbTransPenjualan.getValueAt(tbTransPenjualan.getSelectedRow(), 0).toString();
         String pth = System.getProperty("user.dir") + "/MenuReport/rpBarang.jrxml";
        try{
            Map<String, Object> parameters = new HashMap<String, Object>();
            _Cnn = null;
                    _Cnn = getCnn.getConnection();
            //parameters.put("no_faktur", "1");
            
            JasperReport jrpt = JasperCompileManager.compileReport(pth);
            JasperPrint jprint = JasperFillManager.fillReport(jrpt, parameters, _Cnn);
            
            JasperViewer.viewReport(jprint, false);
            
        }catch(Exception ex){
            //JOptionPane.showConfirmDialog(null, "Tidak ada faktur", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_mnReport1ActionPerformed
    private void linkUser(){
                try{
            rf = new MenuUser.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab(" .: Data User :. ", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkSetPassword(){
                try{
            f = new FrSetPassword();;
            f.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    private void linkPegawai(){
                try{
            rf = new MenuPegawai.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab(" .: Data Pegawai :. ", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkMember(){
        try{
            rf = new __List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab(" .: Member :. ", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkDistributor(){
        try{
            rf = new MenuDistributor.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab(".: Distributor :.", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkmstkelompok(){
        try{
            rf = new MenuGrpBarang.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab("..::.. MASTER KELOMPOK BARANG ..::..", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    private void linkproduk(){
        try{
            rf = new MenuBarang.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab("..::.. DATA BARANG ..::..", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkbrgmasuk(){
                try{
            rf = new MenuTransBrgMasuk.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab(" .: Transaksi Barang Masuk :. ", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkreturbrgmasuk(){
                try{
            rf = new MenuReturBrgMasuk.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab(" .: Retur Barang Masuk :. ", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkpenjualan(){
                try{
            rf = new MenuTransPenjualan.listPenjualan().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab(" .: Transaksi Penjualan :. ", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkreturpenjualan(){
                try{
            rf = new MenuReturPenjualan.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab(" .: Retur Penjualan :. ", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkreport(){
        try{
            rf = new MenuReport.__List().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab("..::.. REPORT ..::..", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    private void linkreportpenjualan(){
        try{
            rf = new MenuReport.frLapPenjualan().getContentPane();
            tabbedPane.removeAll();
            tabbedPane.addTab("..::.. REPORT ..::..", rf);
            tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
            tabbedPane.updateUI();
        } catch(Exception ex){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName() );
            } catch(Exception ex2) {
                    JOptionPane.showInternalMessageDialog(this, ex2);
            }
        }
    }
    
    
    
    
    private void mnMaster1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMaster1ActionPerformed
        linkmstkelompok();
    }//GEN-LAST:event_mnMaster1ActionPerformed

    private void mnMaster2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnMaster2ActionPerformed
        linkproduk();
    }//GEN-LAST:event_mnMaster2ActionPerformed

    private void mnPersonal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPersonal1ActionPerformed
        linkPegawai();
    }//GEN-LAST:event_mnPersonal1ActionPerformed

    private void mnPersonal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPersonal2ActionPerformed
        linkMember();
    }//GEN-LAST:event_mnPersonal2ActionPerformed

    private void mnPersonal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPersonal3ActionPerformed
        linkDistributor();
    }//GEN-LAST:event_mnPersonal3ActionPerformed

    private void mnTransaksi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransaksi2ActionPerformed
        linkreturbrgmasuk();
    }//GEN-LAST:event_mnTransaksi2ActionPerformed

    private void mnTransaksi3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransaksi3ActionPerformed
        linkpenjualan();
    }//GEN-LAST:event_mnTransaksi3ActionPerformed

    private void mnTransaksi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransaksi4ActionPerformed
        linkreturpenjualan();
    }//GEN-LAST:event_mnTransaksi4ActionPerformed

    private void mnReport3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReport3ActionPerformed
        String pth="MenuReport/rpPegawai.jrxml";
        try{
            Map<String, Object> parameters = new HashMap<String, Object>();
            _Cnn = null;
                    _Cnn = getCnn.getConnection();
            //parameters.put("no_faktur", "1");
            
            JasperReport jrpt = JasperCompileManager.compileReport(pth);
            JasperPrint jprint = JasperFillManager.fillReport(jrpt, parameters, _Cnn);
            
            JasperViewer.viewReport(jprint, false);
            
        }catch(Exception ex){
            //JOptionPane.showConfirmDialog(null, "Tidak ada faktur", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_mnReport3ActionPerformed

    private void mnReport4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReport4ActionPerformed
        String pth = System.getProperty("user.dir") + "/MenuReport/rpMember.jrxml";
        try{
            Map<String, Object> parameters = new HashMap<String, Object>();
            _Cnn = null;
                    _Cnn = getCnn.getConnection();
            //parameters.put("no_faktur", "1");
            
            JasperReport jrpt = JasperCompileManager.compileReport(pth);
            JasperPrint jprint = JasperFillManager.fillReport(jrpt, parameters, _Cnn);
            
            JasperViewer.viewReport(jprint, false);
            
        }catch(Exception ex){
            //JOptionPane.showConfirmDialog(null, "Tidak ada faktur", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_mnReport4ActionPerformed

    private void mnReport8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReport8ActionPerformed
        try{
            f1 = new frLapPenjualan();
            f1.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_mnReport8ActionPerformed

    private void mnSis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSis2ActionPerformed
        linkSetPassword();
    }//GEN-LAST:event_mnSis2ActionPerformed

    private void hpKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpKeluarActionPerformed
        int jawab = JOptionPane.showConfirmDialog(this,"Exit Applications ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION){
            dispose();
            this.setVisible(false);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            System.exit(0);
        }
    }//GEN-LAST:event_hpKeluarActionPerformed

    private void hpRepPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpRepPenjualanActionPerformed
        try{
            f1 = new frLapPenjualan();
            f1.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_hpRepPenjualanActionPerformed

    private void hpRepStokBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpRepStokBarangActionPerformed
         //String kode = tbTransPenjualan.getValueAt(tbTransPenjualan.getSelectedRow(), 0).toString();
         String pth = System.getProperty("user.dir") + "/MenuReport/rpBarang.jrxml";
        try{
            Map<String, Object> parameters = new HashMap<String, Object>();
            _Cnn = null;
                    _Cnn = getCnn.getConnection();
            //parameters.put("no_faktur", "1");
            
            JasperReport jrpt = JasperCompileManager.compileReport(pth);
            JasperPrint jprint = JasperFillManager.fillReport(jrpt, parameters, _Cnn);
            
            JasperViewer.viewReport(jprint, false);
            
        }catch(Exception ex){
            //JOptionPane.showConfirmDialog(null, "Tidak ada faktur", "Informasi", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_hpRepStokBarangActionPerformed

    private void hpReturPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpReturPenjualanActionPerformed
        linkreturpenjualan();
    }//GEN-LAST:event_hpReturPenjualanActionPerformed

    private void hpTransPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpTransPenjualanActionPerformed
        linkpenjualan();
    }//GEN-LAST:event_hpTransPenjualanActionPerformed

    private void hpReturBrgMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpReturBrgMasukActionPerformed
        linkreturbrgmasuk();
    }//GEN-LAST:event_hpReturBrgMasukActionPerformed

    private void hpTransBrgMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpTransBrgMasukActionPerformed
        linkbrgmasuk();
    }//GEN-LAST:event_hpTransBrgMasukActionPerformed

    private void hpBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpBarangActionPerformed
        linkproduk();
    }//GEN-LAST:event_hpBarangActionPerformed

    private void hpMstKelompokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpMstKelompokActionPerformed
        linkmstkelompok();
    }//GEN-LAST:event_hpMstKelompokActionPerformed

    private void hpDistributorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpDistributorActionPerformed
        linkDistributor();
    }//GEN-LAST:event_hpDistributorActionPerformed

    private void hpMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpMemberActionPerformed
        linkMember();
    }//GEN-LAST:event_hpMemberActionPerformed

    private void hpPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpPegawaiActionPerformed
        linkPegawai();
    }//GEN-LAST:event_hpPegawaiActionPerformed

    private void mnTransaksi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransaksi5ActionPerformed
        MenuTransPenjualan.frSetDiskon form = new frSetDiskon();
        form.setVisible(true);
        
    }//GEN-LAST:event_mnTransaksi5ActionPerformed

    private void hpRepAktifMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hpRepAktifMemberActionPerformed
       frLapMemberAktif form = new frLapMemberAktif();
       form.setVisible(true);
    }//GEN-LAST:event_hpRepAktifMemberActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTitledPanel Layar;
    public javax.swing.JMenu Menu1;
    public javax.swing.JMenu Menu2;
    public javax.swing.JMenu Menu3;
    public javax.swing.JMenu Menu4;
    public javax.swing.JMenu Menu5;
    public javax.swing.JMenuBar MnMenuBar;
    private org.jdesktop.swingx.JXTaskPane MnTakspan;
    public org.jdesktop.swingx.JXHyperlink hpBarang;
    public org.jdesktop.swingx.JXHyperlink hpDistributor;
    public org.jdesktop.swingx.JXHyperlink hpKeluar;
    public org.jdesktop.swingx.JXHyperlink hpMember;
    public org.jdesktop.swingx.JXHyperlink hpMstKelompok;
    public org.jdesktop.swingx.JXHyperlink hpPegawai;
    public org.jdesktop.swingx.JXHyperlink hpRepAktifMember;
    public org.jdesktop.swingx.JXHyperlink hpRepPenjualan;
    public org.jdesktop.swingx.JXHyperlink hpRepStokBarang;
    public org.jdesktop.swingx.JXHyperlink hpReturBrgMasuk;
    public org.jdesktop.swingx.JXHyperlink hpReturPenjualan;
    public org.jdesktop.swingx.JXHyperlink hpTransBrgMasuk;
    public org.jdesktop.swingx.JXHyperlink hpTransPenjualan;
    public javax.swing.JSeparator jSeparator1;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JSeparator jSeparator3;
    public javax.swing.JPopupMenu.Separator jSeparator4;
    public javax.swing.JPopupMenu.Separator jSeparator5;
    public javax.swing.JPopupMenu.Separator jSeparator6;
    public org.jdesktop.swingx.JXHyperlink jXHyperlink10;
    public org.jdesktop.swingx.JXHyperlink jXHyperlink4;
    public org.jdesktop.swingx.JXHyperlink jXHyperlink6;
    public org.jdesktop.swingx.JXHyperlink jXHyperlink8;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel2;
    public javax.swing.JMenuItem mnMaster1;
    public javax.swing.JMenuItem mnMaster2;
    public javax.swing.JMenuItem mnPersonal1;
    public javax.swing.JMenuItem mnPersonal2;
    public javax.swing.JMenuItem mnPersonal3;
    public javax.swing.JMenuItem mnReport1;
    public javax.swing.JMenuItem mnReport3;
    public javax.swing.JMenuItem mnReport4;
    public javax.swing.JMenuItem mnReport8;
    public javax.swing.JMenuItem mnSis2;
    public javax.swing.JMenuItem mnSis4;
    public javax.swing.JMenuItem mnTransaksi1;
    public javax.swing.JMenuItem mnTransaksi2;
    public javax.swing.JMenuItem mnTransaksi3;
    public javax.swing.JMenuItem mnTransaksi4;
    public javax.swing.JMenuItem mnTransaksi5;
    // End of variables declaration//GEN-END:variables
    public void loginAdmin(){
        //mnSis1.setEnabled(true);
        mnSis2.setEnabled(true);
        mnSis4.setEnabled(true);
        mnMaster1.setEnabled(true);
        mnMaster2.setEnabled(true);
        mnPersonal1.setEnabled(true);
        mnPersonal2.setEnabled(true);
        mnPersonal3.setEnabled(true);
        mnTransaksi1.setEnabled(true);
        mnTransaksi2.setEnabled(true);
        mnTransaksi3.setEnabled(true);
        mnTransaksi4.setEnabled(true);
        mnReport1.setEnabled(true);
        mnReport3.setEnabled(true);
        mnReport4.setEnabled(true);
        mnReport8.setEnabled(true);
        mnReport8.setEnabled(true);
        
        hpPegawai.setEnabled(true);
        hpMember.setEnabled(true);
        hpDistributor.setEnabled(true);
        hpMstKelompok.setEnabled(true);
        hpBarang.setEnabled(true);
        hpTransBrgMasuk.setEnabled(true);
        hpReturBrgMasuk.setEnabled(true);
        hpTransPenjualan.setEnabled(true);
        hpReturPenjualan.setEnabled(true);
        hpRepStokBarang.setEnabled(true);
        hpRepPenjualan.setEnabled(true);
    }
    
    public void loginUser(){
        //mnSis1.setEnabled(false);
        mnSis2.setEnabled(true);
        mnSis4.setEnabled(true);
        mnMaster1.setEnabled(true);
        mnMaster2.setEnabled(true);
        mnPersonal1.setEnabled(true);
        mnPersonal2.setEnabled(true);
        mnPersonal3.setEnabled(true);
        mnTransaksi1.setEnabled(true);
        mnTransaksi2.setEnabled(true);
        mnTransaksi3.setEnabled(true);
        mnTransaksi4.setEnabled(true);
        mnReport1.setEnabled(true);
        mnReport3.setEnabled(true);
        mnReport4.setEnabled(true);
        mnReport8.setEnabled(true);
        mnReport8.setEnabled(true);
        
        hpPegawai.setEnabled(true);
        hpMember.setEnabled(true);
        hpDistributor.setEnabled(true);
        hpMstKelompok.setEnabled(true);
        hpBarang.setEnabled(true);
        hpTransBrgMasuk.setEnabled(true);
        hpReturBrgMasuk.setEnabled(true);
        hpTransPenjualan.setEnabled(true);
        hpReturPenjualan.setEnabled(true);
        hpRepStokBarang.setEnabled(false);
        hpRepPenjualan.setEnabled(false);
    }
    public static String PathReport=System.getProperty("user.dir") + "/MenuReport/";
}
