package com.JsonParserProject.firstProject.Panels;

import com.JsonParserProject.firstProject.Core.JsonToMapForAll;
import com.JsonParserProject.firstProject.Panels.PoJo.PoJoFromRightTable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RightJPanel extends JTable implements JPanelCreatable, ActionListener {
    static ArrayList<String> clientsNamesForTable = new ArrayList<>();
    static JsonToMapForAll rightParsedClientsObj;
    static Map<String, Object> mapForClientsData = new HashMap<>();
    private static String rightPanelValue;
    private static String buttonChooseValue;

    public String getButtonChooseValue() {
        return buttonChooseValue;
    }

    public void setButtonChooseValue(String buttonChooseValue) {
        RightJPanel.buttonChooseValue = buttonChooseValue;
    }

    public String getRightPanelValue() {
        return rightPanelValue;
    }

    public void setRightPanelValue(String rightPanelValue) {
        RightJPanel.rightPanelValue = rightPanelValue;
    }

    @Override
    public JPanel createUpperPane() {
        RightTable rightTable = new RightTable();
        JPanel RightUpperPanel = new JPanel(new BorderLayout(5, 5));
        rightTable.setName("RightPanel");
        RightUpperPanel.add(CreateUpperComboPanel(), BorderLayout.NORTH);
        RightUpperPanel.add(rightTable.createSplitPane(rightTable.createJTable()), BorderLayout.CENTER);
        RightUpperPanel.add(createButtonsGroup(), BorderLayout.EAST);
        return RightUpperPanel;
    }

    @Override
    public JPanel createUpperComboPanel() {
        JPanel panel = new JPanel();
        panel.setName("RightTableComboPanel");
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(createDroppingButtonsPanel());

        return panel;
    }

    public JPanel CreateUpperComboPanel() {
        JPanel panel = new JPanel();
        panel.setName("RightComboPanel");
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(createDroppingButtonsPanel());
        return panel;
    }

    @Override
    public JPanel createDroppingButtonsPanel() {
        JPanel droppingPanel = new JPanel();
        droppingPanel.setName("RightDroppingPanel");
        droppingPanel.setBorder(new TitledBorder("Border"));
        droppingPanel.add(createComboTableForRight());
        droppingPanel.add(createAddNewButton());
        return droppingPanel;
    }

    public void insertClientsNameForTable(JsonToMapForAll obj, Map map) {
        rightParsedClientsObj = obj;
        mapForClientsData = Collections.synchronizedMap(obj.getClientsMap());
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            clientsNamesForTable.add(pair.getKey());
        }
    }

    public void convertMapToData(String value) {
        setRightPanelValue(value);
        RightTable rightTable = new RightTable();
        ObjectMapper objectMapper = new ObjectMapper();
        Iterator<Map.Entry<String, Object>> iterator = rightParsedClientsObj.getClientsMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            if (pair.getKey().contains(value)) {
                try {
                    PoJoFromRightTable poJoFromRightTable1 = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), PoJoFromRightTable.class);
                    rightTable.createClientsData(poJoFromRightTable1);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public JPanel createButtonsGroup() {
        ButtonGroup buttonsGroupPanel = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("first button", false);
        buttonsGroupPanel.add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton("Second button", false);
        buttonsGroupPanel.add(radioButton2);
        JRadioButton radioButton3 = new JRadioButton("Third button", false);
        buttonsGroupPanel.add(radioButton3);

        ActionListener buttonsActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                setButtonChooseValue(abstractButton.getText());
            }
        };
        radioButton1.addActionListener(buttonsActionListener);
        radioButton2.addActionListener(buttonsActionListener);
        radioButton3.addActionListener(buttonsActionListener);


        JPanel buttonsGroup = new JPanel(new GridLayout(1, 3));
        buttonsGroup.add(radioButton1);
        buttonsGroup.add(radioButton2);
        buttonsGroup.add(radioButton3);
        buttonsGroup.setLayout(new BoxLayout(buttonsGroup, BoxLayout.Y_AXIS));


        return buttonsGroup;
    }

    public JComboBox createComboTableForRight() {

        JComboBox comboButton = new JComboBox(clientsNamesForTable.toArray());
        comboButton.setName("RightPanelComboBox");
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
