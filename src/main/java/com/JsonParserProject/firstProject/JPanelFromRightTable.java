package com.JsonParserProject.firstProject;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class JPanelFromRightTable extends JTable {
    static ArrayList<String> clientsNamesForTable = new ArrayList<>();
    static CreateFirstMapFromJson RightParsedClientsObj;
    static Map<String, Object> mapForClientsData = new HashMap<>();

    public JPanel createPanelFromRightSide() {
        RightTableTemp rightTableTemp = new RightTableTemp();
        JPanel RightUpperPanel = new JPanel(new BorderLayout(5, 5));
        RightUpperPanel.add(RightCreateUpperComboPanel(), BorderLayout.NORTH);
        RightUpperPanel.add(rightTableTemp.createSplitPane(rightTableTemp.createJTable()), BorderLayout.CENTER);
        RightUpperPanel.add(createButtonsGroup(), BorderLayout.EAST);
        return RightUpperPanel;
    }

    public JPanel RightCreateUpperComboPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(createDroppingButtonsPanelForRight());
        return panel;
    }


    public JPanel createDroppingButtonsPanelForRight() {
        JPanel droppingPanel = new JPanel();
        droppingPanel.setBorder(new TitledBorder("Border"));
        droppingPanel.add(createComboTableForRight());
        droppingPanel.add(createAddNewButton());
        return droppingPanel;
    }

    public JButton createAddNewButton() {
        final JButton button2 = new JButton("Add new Button");
        button2.setAlignmentX(RIGHT_ALIGNMENT);
        return button2;
    }

    public void insertClientsNameForRightTable(CreateFirstMapFromJson obj, Map map) {
        RightParsedClientsObj = obj;
        mapForClientsData = Collections.synchronizedMap(obj.getClientsMap());
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            clientsNamesForTable.add(pair.getKey());
        }


    }

    public void convertMapToData(String value) {
        JsonPojoForRightTable jsonPojoForRightTable = new JsonPojoForRightTable();
        jsonPojoForRightTable.convertClientsDetails(value, RightParsedClientsObj.getClientsMap());
    }

    public JPanel createButtonsGroup() {
        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBorder(new TitledBorder("Radio Buttons"));
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton radioButton1 = new JRadioButton("first button", false);
        buttonGroup.add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton("Second button", false);
        buttonGroup.add(radioButton2);
        JRadioButton radioButton3 = new JRadioButton("Third button", false);
        buttonGroup.add(radioButton3);

        final JPanel buttonsGroup = new JPanel(new GridLayout(1, 3));
        buttonsGroup.add(radioButton1);
        buttonsGroup.add(radioButton2);
        buttonsGroup.add(radioButton3);
        buttonsGroup.setLayout(new BoxLayout(buttonsGroup, BoxLayout.Y_AXIS));

        return buttonsGroup;
    }

    public JComboBox createComboTableForRight() {

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
}
