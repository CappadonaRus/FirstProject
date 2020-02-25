package com.JsonParserProject.firstProject.Panels;


import com.JsonParserProject.firstProject.Core.JsonToMapForAll;
import com.JsonParserProject.firstProject.Panels.PoJo.PoJoFromLeftTable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class LeftJPanel extends JTable implements JPanelCreatable {
    static ArrayList<String> clientsNamesForTable = new ArrayList<String>();
    static JsonToMapForAll parsedClientsObj;
    private static String leftPanelValue;

    public String getLeftPanelValue() {
        return leftPanelValue;
    }

    public void setLeftPanelValue(String leftPanelValue) {
        LeftJPanel.leftPanelValue = leftPanelValue;
    }

    @Override
    public JPanel createUpperPane() {
        CenterJPanel centerJPanel = new CenterJPanel();
        LeftTable leftTable = new LeftTable();
        JPanel upperPanel = new JPanel(new BorderLayout(4, 4));
        leftTable.setName("LeftJPanel");
        upperPanel.setPreferredSize(new Dimension(600, 600));
        upperPanel.add(createUpperComboPanel(), BorderLayout.NORTH);
        upperPanel.add(leftTable.createSplitPane(leftTable.createJTable()), BorderLayout.EAST);
        upperPanel.add(centerJPanel.createUpperPane(), BorderLayout.SOUTH);


        return upperPanel;
    }

    @Override
    public JPanel createUpperComboPanel() {
        JPanel panel = new JPanel();
        panel.setName("LeftTableUpperPanel");
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setPreferredSize(new Dimension(150, 50));
        panel.add(createDroppingButtonsPanel());


        return panel;
    }

    public JPanel createDroppingButtonsPanel() {
        JPanel droppingPanel = new JPanel();
        droppingPanel.setName("LeftDroppingPanel");
        droppingPanel.add(createComboTableForLeft());

        return droppingPanel;
    }

    public JComboBox createComboTableForLeft() {

        JComboBox comboButton = new JComboBox(clientsNamesForTable.toArray());
        comboButton.setName("LeftPanelComboBox");
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
        setLeftPanelValue(value);
        LeftTable leftTable = new LeftTable();
        ObjectMapper objectMapper = new ObjectMapper();
        Iterator<Map.Entry<String, Object>> iterator = parsedClientsObj.getClientsMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            if (pair.getKey().contains(value)) {
                try {
                    PoJoFromLeftTable poJoFromLeftTable = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), PoJoFromLeftTable.class);
                    leftTable.createClientsData(poJoFromLeftTable);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void insertClientsNameForTable(JsonToMapForAll obj, Map map) {
        parsedClientsObj = obj;

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            clientsNamesForTable.add(pair.getKey());
        }
    }
}

