package com.JsonParserProject.firstProject;

import javax.swing.*;
import java.awt.*;

public class CreateBothTables extends JFrame implements Runnable {
    public void createFrame() {
        JPanelForLeftTable jPanelForLeftTable = new JPanelForLeftTable();
        JPanelFromRightTable jPanelFromRightTable = new JPanelFromRightTable();
        JFrame mainFrame = new JFrame("Set Name");


        mainFrame.getContentPane().add(jPanelFromRightTable.createUpperPane(), BorderLayout.EAST);
        mainFrame.getContentPane().add(jPanelForLeftTable.createUpperPane(), BorderLayout.WEST);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLocationByPlatform(true);
        mainFrame.setMinimumSize(mainFrame.getSize());
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainFrame.setVisible(true);
    }

    @Override
    public void run() {
        createFrame();
    }
}
