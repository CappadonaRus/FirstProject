package com.JsonParserProject.firstProject;

import javax.swing.*;
import java.util.ArrayList;

public class LeftTable extends JTable implements SplitPaneCreatable {
    private static ArrayList<Object> clientsDataColumns = new ArrayList<>();
    private static JTable table;
    static Object giveObject;

    public JTable createJTable() {
        CustomTableModel customTableModel = new CustomTableModel("fields");
        table = new JTable(customTableModel);
        return table;
    }

    @Override
    public ArrayList<Object> createColumnsNames() {

        clientsDataColumns.add("fio");
        clientsDataColumns.add("lastName");
        clientsDataColumns.add("firstName");
        clientsDataColumns.add("middleName");
        clientsDataColumns.add("birthDate");
        clientsDataColumns.add("card");
        clientsDataColumns.add("sessionType");
        clientsDataColumns.add("type");
        clientsDataColumns.add("series");
        clientsDataColumns.add("number");
        clientsDataColumns.add("seriesNumber");

        return clientsDataColumns;
    }


    public void createClientsData(PoJoFromLeftTable poJoFromLeftTable) {
        giveObject = poJoFromLeftTable;

        ArrayList<String> clientsData = new ArrayList<>();
        clientsData.add(poJoFromLeftTable.getFio());
        clientsData.add(poJoFromLeftTable.getLastName());
        clientsData.add(poJoFromLeftTable.getFirstName());
        clientsData.add(poJoFromLeftTable.getMiddleName());
        clientsData.add(poJoFromLeftTable.getBirthDate());
        clientsData.add(poJoFromLeftTable.getCard());
        clientsData.add(poJoFromLeftTable.getSessionType());
        clientsData.add(poJoFromLeftTable.document.getType());
        clientsData.add(poJoFromLeftTable.document.getSeries());
        clientsData.add(poJoFromLeftTable.document.getNumber());
        clientsData.add(poJoFromLeftTable.document.getSeriesNumber());
        CustomTableModel customTableModel = new CustomTableModel("fields");
        customTableModel.updateTable(clientsData);
        table.setModel(customTableModel);
    }
}
