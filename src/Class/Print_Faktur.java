package Class;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class Print_Faktur implements JRDataSource{
    private int index =0;
    private DefaultTableModel _tmData;
    public Print_Faktur(DefaultTableModel tmData)  {
        _tmData = tmData;
    }

    public boolean next() throws JRException {
        index++;
        return (index < _tmData.getRowCount());
    }

    public Object getFieldValue(JRField field) throws JRException{
        Object value = null;
        String fieldName = field.getName();
        if ("no_faktur".equals(fieldName)){ value = _tmData.getValueAt(index,0).toString();}
       
        return value;
    }
}
