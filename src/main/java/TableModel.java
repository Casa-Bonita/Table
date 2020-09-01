import javax.swing.event.TableModelListener;
import java.util.List;

public class TableModel implements javax.swing.table.TableModel {
    public List<Staff> lisfStaff;

    public TableModel(List<Staff> lisfStaff) {
        this.lisfStaff = lisfStaff;
    }

    @Override
    public int getRowCount() {
        return lisfStaff.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0: return "ID";
            case 1: return "Name";
            case 2: return "Surname";
            case 3: return "Position";
            case 4: return "PhoneNumber";
            case 5: return "Age";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Staff staff = lisfStaff.get(rowIndex);
        switch (columnIndex){
            case 0: staff.getId();
            case 1: staff.getName();
            case 2: staff.getSurname();
            case 3: staff.getPosition();
            case 4: staff.getPhoneNumber();
            case 5: staff.getAge();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
