package Class;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class Print_Report implements JRDataSource{
    private int index = -1;
    private DefaultTableModel _tmData;
    public Print_Report(DefaultTableModel tmData)  {
        _tmData = tmData;
    }

    public boolean next() throws JRException {
        index++;
        return (index < _tmData.getRowCount());
    }

    public Object getFieldValue(JRField field) throws JRException{
        Object value = null;
        String fieldName = field.getName();
        if ("no".equals(fieldName)){ value = _tmData.getValueAt(index,0).toString();}
        if ("barang".equals(fieldName)){ value = _tmData.getValueAt(index,1).toString();}
        if ("tanggal".equals(fieldName)){ value = _tmData.getValueAt(index,2).toString();}
        if ("customer".equals(fieldName)){ value = _tmData.getValueAt(index,3).toString();}
        if ("subtotal".equals(fieldName)){ value = Double.parseDouble(_tmData.getValueAt(index,4).toString());}
        return value;
    }
}
