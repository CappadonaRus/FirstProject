package com.JsonParserProject.firstProject.Panels;

import com.JsonParserProject.firstProject.Panels.PoJo.PoJoFromRightTable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RightTable extends JTable implements SplitPaneCreatable {
    private static ArrayList<Object> clientsDataColumnsLeft = new ArrayList<Object>();
    private static JTable table;


    public JTable createJTable() {
        CustomTableModel customTableModel = new CustomTableModel("fields");
        table = new JTable(customTableModel);
        table.setSize(new Dimension(200, 200));
        table.setName("RightTable");

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


    public void createClientsData(PoJoFromRightTable poJoFromRightTable) {


        ArrayList<String> clientsData = new ArrayList<>();
        clientsData.add(poJoFromRightTable.getSelfkey());
        clientsData.add(poJoFromRightTable.getConfirmKey());
        clientsData.add(poJoFromRightTable.getLogin());
        clientsData.add(poJoFromRightTable.getPassword());
        clientsData.add(poJoFromRightTable.getFullName());
        clientsData.add(poJoFromRightTable.getBranch());
        clientsData.add(poJoFromRightTable.getLastName());
        clientsData.add(poJoFromRightTable.getFirstName());
        clientsData.add(poJoFromRightTable.getMiddleName());
        CustomTableModel customTableModel = new CustomTableModel("fields");
        customTableModel.updateTable(clientsData);
        table.setModel(customTableModel);
    }
}
