package com.JsonParserProject.firstProject;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public interface SplitPaneCreate {


    default ListModel init() {

        return new AbstractListModel() {
           Object headers[] = createColumnsNames().toArray();

           public int getSize() {
               return headers.length;
           }

           public Object getElementAt(int index) {
               return headers[index];
           }
       };
    }

     ArrayList<Object> createColumnsNames();


    default JSplitPane createSplitPane(JTable table) {
        JScrollPane tableScroll = new JScrollPane(table);

        JList rowHeader = new JList(init());
        rowHeader.setFixedCellWidth(100);
        rowHeader.setFixedCellHeight(table.getRowHeight());
        rowHeader.setCellRenderer(new RowHeaderRenderer(table));

        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setPreferredSize(new Dimension(0, 0));
        tableScroll.setRowHeaderView(rowHeader);
        tableScroll.setPreferredSize(new Dimension(600, 250));
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {

            }
        });

        JPanel lowPanel = new JPanel();
        final JButton buttonStart = new JButton("Start");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            }
        });
        lowPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        lowPanel.add(buttonStart, BorderLayout.PAGE_END);
        return new JSplitPane(JSplitPane.VERTICAL_SPLIT, tableScroll, new JScrollPane(lowPanel));
    }

}

           /*    // перехват значения измененного столбца в таблице
                System.out.println(tme.getFirstRow() + " " + tme.getColumn() + " " + (table.getValueAt(tme.getFirstRow(), tme.getColumn())));
                if (tme.getType() == TableModelEvent.UPDATE) {
                    Object changedValue = table.getValueAt(tme.getFirstRow(), tme.getColumn());
                    int row = tme.getFirstRow();
                    int col = tme.getColumn();
                    DefaultTableModel tableForSave = (DefaultTableModel) tme.getSource();
                    String columnName = tableForSave.getColumnName(col);
                    Object data = tableForSave.getValueAt(row, col);
                }
            }

             */

