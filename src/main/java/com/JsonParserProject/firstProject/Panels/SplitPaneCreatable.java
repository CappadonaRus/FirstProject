package com.JsonParserProject.firstProject.Panels;

import com.JsonParserProject.firstProject.Core.InsertedFinalDetailsFromAll;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public interface SplitPaneCreatable {

    ArrayList<Object> createColumnsNames();

    default JScrollPane createSplitPane(JTable table) {

        JScrollPane tableScroll = new JScrollPane(table);

        JList rowHeader = new JList(listModelCreate());
        rowHeader.setFixedCellWidth(100);
        rowHeader.setFixedCellHeight(table.getRowHeight());
        rowHeader.setCellRenderer(new RowHeaderForAllTables(table));

        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setPreferredSize(new Dimension(0, 0));
        tableScroll.setRowHeaderView(rowHeader);
        tableScroll.setPreferredSize(new Dimension(600, 250));
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tme) {

            }
        });

        return tableScroll;
    }


    default ListModel listModelCreate() {

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

           /*
    default JPanel createLowPanel() {
        JPanel lowPanel = new JPanel();
        JButton buttonStart = new JButton("Run");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RightJPanel rightJPanel = new RightJPanel();
                LeftJPanel leftJPanel = new LeftJPanel();
                CenterJPanel centerJPanel = new CenterJPanel();
                InsertedFinalDetailsFromAll insertedFinalDetailsFromAll = new InsertedFinalDetailsFromAll();
                insertedFinalDetailsFromAll.saveAllObjects(leftJPanel.getLeftPanelValue(), rightJPanel.getRightPanelValue(),
                                                            centerJPanel.getCentralPanelValue(),rightJPanel.getButtonChooseValue() );

            }
        });
        lowPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        lowPanel.add(buttonStart, BorderLayout.AFTER_LAST_LINE);
        return lowPanel;
    }

 */
