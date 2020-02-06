package com.bro.firstProject;

import javax.swing.*;
import java.awt.*;

public class CreateBothTables extends JFrame {
    public void createFrame() {
        JPanelForLeftTable jPanelForLeftTable = new JPanelForLeftTable();
        JPanelFromRightTable jPanelFromRightTable = new JPanelFromRightTable();
        JFrame mainFrame = new JFrame("For my Braza");


        mainFrame.getContentPane().add(jPanelFromRightTable.createPanelFromRightSide(), BorderLayout.EAST);
        mainFrame.getContentPane().add(jPanelForLeftTable.createUpperPaneToLeftSide(), BorderLayout.WEST);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLocationByPlatform(true);
        mainFrame.setMinimumSize(mainFrame.getSize());
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        mainFrame.setVisible(true);
    }
}
