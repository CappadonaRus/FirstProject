package com.JsonParserProject.firstProject;

import javax.swing.*;
import java.util.ArrayList;

public class RightTable extends JTable implements SplitPaneCreatable {
    static ArrayList<Object> clientsDataColumnsLeft = new ArrayList<Object>();
    static JTable table;

    public JTable createJTable() {
        CustomTableModel customTableModel = new CustomTableModel("fields");
        table = new JTable(customTableModel);
        return table;
    }

    @Override
    public ArrayList<Object> createColumnsNames() {

        clientsDataColumnsLeft.add("selfkey");
        clientsDataColumnsLeft.add("confirmKey");
        clientsDataColumnsLeft.add("login");
        clientsDataColumnsLeft.add("password");
        clientsDataColumnsLeft.add("fullName");
        clientsDataColumnsLeft.add("branch");
        clientsDataColumnsLeft.add("lastName");
        clientsDataColumnsLeft.add("firstName");
        clientsDataColumnsLeft.add("middleName");

        return clientsDataColumnsLeft;

    }


    public void createClientsData(JsonPojoForRightTable jsonPojoForRightTable) {
        ArrayList<String> clientsData = new ArrayList<>();
        clientsData.add(jsonPojoForRightTable.getSelfkey());
        clientsData.add(jsonPojoForRightTable.getConfirmKey());
        clientsData.add(jsonPojoForRightTable.getLogin());
        clientsData.add(jsonPojoForRightTable.getPassword());
        clientsData.add(jsonPojoForRightTable.getFullName());
        clientsData.add(jsonPojoForRightTable.getBranch());
        clientsData.add(jsonPojoForRightTable.getLastName());
        clientsData.add(jsonPojoForRightTable.getFirstName());
        clientsData.add(jsonPojoForRightTable.getMiddleName());
        CustomTableModel customTableModel = new CustomTableModel("fields");
        customTableModel.updateTable(clientsData);
        table.setModel(customTableModel);
    }
}
