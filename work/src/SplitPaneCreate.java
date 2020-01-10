import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SplitPaneCreate extends ActionsWindow {

    private int rowNumber;
    private int col;


    public static JSplitPane createSplitPane() {
        NewUserWindow newUserWindow = new NewUserWindow();

        String[] nameColumns = {"id", "firstName", "lastName", "age", "salary"};
        //String[] a = new String[0];
        // String[] names = System.getProperties().stringPropertyNames().toArray(a);
        ParsingJson parsed = new ParsingJson();
        String[][] infoTable = new String[1][nameColumns.length];

        for (int i = 0; i < infoTable.length; i++) {
            infoTable[i][0] = String.valueOf(parsed.getId());
            infoTable[i][1] = parsed.getFirstName();
            infoTable[i][2] = parsed.getLastName();
            infoTable[i][3] = String.valueOf(parsed.getAge());
            infoTable[i][4] = String.valueOf(parsed.getSalary());
        }


        DefaultTableModel InfoTableModel = new DefaultTableModel(infoTable, nameColumns);
        JTable table = new JTable(InfoTableModel);
        try {
            table.setAutoCreateRowSorter(true);
        } catch (Exception continueWithNoSort) {
        }
        JScrollPane tableScroll = new JScrollPane(table);
        Dimension tablePreferred = tableScroll.getPreferredSize();
        tableScroll.setPreferredSize(new Dimension(tablePreferred.width, tablePreferred.height));

        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {
                System.out.println(tme.getFirstRow() + " " + tme.getColumn() + " " + (table.getValueAt(tme.getFirstRow(), tme.getColumn())));
                if (tme.getType() == TableModelEvent.UPDATE) {
                    Object changedValue = table.getValueAt(tme.getFirstRow(), tme.getColumn());
                    int row = tme.getFirstRow();
                    int col = tme.getColumn();
                    DefaultTableModel tableForSave = (DefaultTableModel) tme.getSource();
                    String columnName = tableForSave.getColumnName(col);
                    Object data = tableForSave.getValueAt(row, col);
                    ChangeAndSaveToJson changeAndSaveToJson = new ChangeAndSaveToJson();
                    changeAndSaveToJson.setValueAT(infoTable, changedValue, row, col);


                    //ChangeAndSaveToJson changeAndSaveToJson = new ChangeAndSaveToJson();
                    //changeAndSaveToJson.getValueAt(tme.getFirstRow(),tme.getColumn());

                }


            }
        });

        JPanel lowPanel = new JPanel(new GridBagLayout());
        final JButton buttonStart = new JButton("Start");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChangeAndSaveToJson changeAndSaveToJson = new ChangeAndSaveToJson();
                changeAndSaveToJson.convertToMapAndSaveToJson();

            }
        });
        lowPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        lowPanel.add(buttonStart, BorderLayout.PAGE_END);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tableScroll, new JScrollPane(lowPanel));
        return splitPane;
    }

    public String[][] createAndPutTable(Map map) {
        // String[][] detailsForTable = new String[][];
        return null;
    }

    public String[] setColumnsInTable(Map<String, Object> map) {
        String[] columnsPane = new String[map.size()];
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        for(int i = 0; i < map.size(); i++) {
            while (iterator.hasNext()) {
                Map.Entry<String, Object> pair = iterator.next();
                String key = pair.getKey();
                System.out.println(key);
                columnsPane[i] = key;
            }
        }

        return columnsPane;
    }
}

