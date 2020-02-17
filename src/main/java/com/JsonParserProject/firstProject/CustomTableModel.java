package com.JsonParserProject.firstProject;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CustomTableModel extends AbstractTableModel {
    private ArrayList<Object> columnNames = new ArrayList<Object>();
    private ArrayList<String> rowsData = new ArrayList<String>();



    public CustomTableModel(String colName) {
        columnNames.add(colName);
    }

    public int getRowCount() {
        return rowsData.size();
    }

    public int getColumnCount() {
        return columnNames.size();
    }

    public Object getValueAt(int row, int col) {
        return rowsData.get(row);
    }

    public String getColumnName(int col) {
        return columnNames.get(col).toString();
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void setValueAt(Object obj, int row, int col) {
        rowsData.set(row, obj.toString());
    }

    public void columnDelete(int a) {
        columnNames.remove(++a);
    }

    public void updateTable(ArrayList<String> arrayList) {
        rowsData.clear();
        rowsData.addAll(arrayList);
    }

}

