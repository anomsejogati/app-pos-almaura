package Class;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
public class FrmViewReport extends javax.swing.JFrame {
    public Connection _kon;
    private String _FileName;
    private HashMap _Parameter;
    private JRDataSource _dataSource;
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    public FrmViewReport(String fileName, HashMap parameter, Connection kon) {
        initComponents();
        this.setSize(dimensi.width,dimensi.height);
        _kon = kon;
        _FileName = fileName;
        _Parameter = parameter;
        try{
            //JasperReport jasperReport = JasperCompileManager.compileReport(_FileName);
            JasperPrint print = JasperFillManager.fillReport(_FileName,_Parameter,_kon);
            JRViewer viewer = new JRViewer(print);
            //Container c = getContentPane();
            //c.add(viewer);
            viewer.setBounds(new Rectangle(dimensi.width,dimensi.height-280));

            this.getContentPane().add(viewer);
        }catch(JRException jre){
           JOptionPane.showMessageDialog(this,"Error : " + jre);
        }
    }
    public FrmViewReport(JRDataSource dataSource,String fileName,HashMap parameter) {
        initComponents();
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        _FileName = fileName;
        _Parameter = parameter;
        _dataSource = dataSource;
        try{
            //JasperReport jasperReport = JasperCompileManager.compileReport(_FileName);
            JasperPrint print = JasperFillManager.fillReport(_FileName,_Parameter,_dataSource);
            JRViewer viewer = new JRViewer(print);
            //Container c = getContentPane();
            //c.add(viewer);
            viewer.setBounds(new Rectangle(10,10,dimensi.width-30,dimensi.height-30));
            this.getContentPane().add(viewer);
        }catch(JRException jre){
           JOptionPane.showMessageDialog(this,"Error : " + jre);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 674, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 465, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
