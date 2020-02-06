package com.bro.firstProject;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class JPanelForLeftTable extends JTable {
    static ArrayList<String> clientsNamesForTable = new ArrayList<String>();
    static CreateFirstMapFromJson parsedClientsObj;


    public JPanel createUpperPaneToLeftSide() {
        LeftTableTemp leftTableTemp = new LeftTableTemp();

        JPanel upperPanel = new JPanel(new BorderLayout(5, 5));
        upperPanel.add(createUpperComboPanel(), BorderLayout.NORTH);
        upperPanel.add(leftTableTemp.createSplitPane(leftTableTemp.createJTable()), BorderLayout.CENTER);

        return upperPanel;
    }

    public JPanel createUpperComboPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(createDroppingButtonsPanel());

        return panel;
    }

    public JPanel createDroppingButtonsPanel() {
        JPanel droppingPanel = new JPanel();

        droppingPanel.setBorder(new TitledBorder("Border"));
        droppingPanel.add(createComboTableForLeft());
        droppingPanel.add(createAddNewButton());

        return droppingPanel;
    }


    public JComboBox createComboTableForLeft() {

        JComboBox comboButton = new JComboBox(clientsNamesForTable.toArray());
        comboButton.setEditable(false);
        comboButton.setAlignmentX(LEFT_ALIGNMENT);
        comboButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JComboBox comboBox = (JComboBox) ae.getSource();
                Object selected = comboBox.getSelectedItem();
                convertMapToData(selected.toString());
            }
        });
        return comboButton;
    }

    public JButton createAddNewButton() {
        final JButton button2 = new JButton("Add new Button");
        button2.setAlignmentX(RIGHT_ALIGNMENT);
        return button2;
    }

    public void convertMapToData(String value) {
        JsonFileToPojoValues jsonFileToPojoValues = new JsonFileToPojoValues();
        jsonFileToPojoValues.convertClientsDetails(value, parsedClientsObj.getClientsMap());
    }

    public void insertClientsNameForTable(CreateFirstMapFromJson obj, Map map) {
        parsedClientsObj = obj;

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            clientsNamesForTable.add(pair.getKey());
        }


    }

}

