package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RightJPanel extends JTable implements JPanelCreatable {
    static ArrayList<String> clientsNamesForTable = new ArrayList<>();
    static JsonToMapForAll rightParsedClientsObj;
    static Map<String, Object> mapForClientsData = new HashMap<>();

    @Override
    public JPanel createUpperPane() {
        RightTable rightTable = new RightTable();
        JPanel RightUpperPanel = new JPanel(new BorderLayout(5, 5));
        setName("RightPanel");
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
        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBorder(new TitledBorder("Radio Buttons"));
        buttonsPanel.setName("RightPanelRadioButtons");
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("first button", false);
        buttonGroup.add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton("Second button", false);
        buttonGroup.add(radioButton2);
        JRadioButton radioButton3 = new JRadioButton("Third button", false);
        buttonGroup.add(radioButton3);

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
}
