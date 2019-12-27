import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ChangingTable extends AbstractTableModel {



    String[][] updateTable = new String[getRowCount()][getColumnCount()];


  // Получение элемента
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[][] row = new String[rowIndex][columnIndex];

        return row[rowIndex][columnIndex];
    }

    // Добавление элемента
    public void setValueAt(String[][] value ,int rowIndex, int columnIndex) {
        String[][] row = new String[getRowCount()][getColumnCount()];
        row = value;
        fireTableCellUpdated(rowIndex, columnIndex);

    }

    // Изменение элемента
    public void updateValue(String newValue, int rowIndex, int columnIndex) {
        String[][] row = new String[rowIndex][columnIndex];
        row[rowIndex][columnIndex] = newValue;
    }

    // количество строк
    public int getRowCount() {
        return 1;
    }

    // количество столбцов
    public int getColumnCount() {
        return ParsingJson.count;
    }


}

