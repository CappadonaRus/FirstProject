import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplitPaneCreate extends ActionsWindow {



    public static JSplitPane createSplitPane(){
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
            public void tableChanged(TableModelEvent e) {
                System.out.println(e.toString());
               // ChangingTable changingTable = new ChangingTable();
                //changingTable.setValueAt(infoTable, 1, nameColumns.length);
                SaveToJson saveToJson = new SaveToJson();
                saveToJson.giveDetails(infoTable, 1, nameColumns.length);

            }
        });

        JPanel lowPanel = new JPanel(new GridBagLayout());
        final JButton buttonStart = new JButton("Start");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SaveToJson saveToJson = new SaveToJson();

            }
        });
        lowPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        lowPanel.add(buttonStart, BorderLayout.PAGE_END);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tableScroll, new JScrollPane(lowPanel));
        return splitPane;
    }
}
