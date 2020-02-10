package com.JsonParserProject.firstProject;

import javax.swing.*;
import java.awt.*;

public interface JPanelCreatable {

    default JPanel createUpperPane() {
        LeftTable leftTable = new LeftTable();

        JPanel upperPanel = new JPanel(new BorderLayout(5, 5));
        upperPanel.add(createUpperComboPanel(), BorderLayout.NORTH);
        upperPanel.add(leftTable.createSplitPane(leftTable.createJTable()), BorderLayout.CENTER);

        return upperPanel;
    }

    default JPanel createUpperComboPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(createDroppingButtonsPanel());

        return panel;
    }

    JPanel createDroppingButtonsPanel();


    default JButton createAddNewButton() {
        final JButton button2 = new JButton("Add new Button");
        return button2;
    }
}
