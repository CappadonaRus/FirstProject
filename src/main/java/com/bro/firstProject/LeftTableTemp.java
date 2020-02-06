package com.bro.firstProject;

import javax.swing.*;
import java.util.ArrayList;

public class LeftTableTemp extends JTable implements SplitPaneCreate {

    static JTable table;

    public JTable createJTable() {
        CustomTableModel customTableModel = new CustomTableModel("fields");
        table = new JTable(customTableModel);
        return table;
    }


    static ArrayList<Object> clientsDataColumns = new ArrayList<>();

    @Override
    public ArrayList<Object> createColumnsNames() {

        clientsDataColumns.add("fio");
        clientsDataColumns.add("lastName");
        clientsDataColumns.add("firstName");
        clientsDataColumns.add("middleName");
        clientsDataColumns.add("birthDate");
        clientsDataColumns.add("card");
        clientsDataColumns.add("sessionType");
        //clientsDataColumns.add("document");
        clientsDataColumns.add("type");
        clientsDataColumns.add("series");
        clientsDataColumns.add("number");
        clientsDataColumns.add("seriesNumber");

        return clientsDataColumns;
    }


    public void createClientsData(JsonFileToPojoValues jsonFileToPojoValues) {
        ArrayList<String> clientsData = new ArrayList<>();
        clientsData.add(jsonFileToPojoValues.getFio());
        clientsData.add(jsonFileToPojoValues.getLastName());
        clientsData.add(jsonFileToPojoValues.getFirstName());
        clientsData.add(jsonFileToPojoValues.getMiddleName());
        clientsData.add(jsonFileToPojoValues.getBirthDate());
        clientsData.add(jsonFileToPojoValues.getCard());
        clientsData.add(jsonFileToPojoValues.getSessionType());
        clientsData.add(jsonFileToPojoValues.document.getType());
        clientsData.add(jsonFileToPojoValues.document.getSeries());
        clientsData.add(jsonFileToPojoValues.document.getNumber());
        clientsData.add(jsonFileToPojoValues.document.getSeriesNumber());
        CustomTableModel customTableModel = new CustomTableModel("fields");
        customTableModel.updateTable(clientsData);
        table.setModel(customTableModel);
    }
}
