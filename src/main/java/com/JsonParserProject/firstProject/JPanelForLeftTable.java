package com.JsonParserProject.firstProject;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class JPanelForLeftTable extends JTable implements JPanelCreatable {
    static ArrayList<String> clientsNamesForTable = new ArrayList<String>();
    static CreateFirstMapFromJson parsedClientsObj;

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


    public void convertMapToData(String value) {
        LeftTable leftTable = new LeftTable();
        ObjectMapper objectMapper = new ObjectMapper();
        Iterator<Map.Entry<String, Object>> iterator = parsedClientsObj.getClientsMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            if (pair.getKey().contains(value)) {
                try {
                    JsonFileToPojoValues jsonFileToPojoValues = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), JsonFileToPojoValues.class);
                    leftTable.createClientsData(jsonFileToPojoValues);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
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

