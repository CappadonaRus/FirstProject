package com.JsonParserProject.firstProject.Panels;

import javax.swing.*;
import java.awt.*;

public class CreateBothTables extends JFrame {

    public CreateBothTables() {
        setName("MainFrame");
        createFrame();
    }


    public void createFrame() {
        LeftJPanel leftJPanel = new LeftJPanel();
        RightJPanel rightJPanel = new RightJPanel();

        getContentPane().add(rightJPanel.createUpperPane(), BorderLayout.EAST);
        getContentPane().add(leftJPanel.createUpperPane(), BorderLayout.WEST);
        pack();
        setLocationRelativeTo(null);
        setLocationByPlatform(true);
        setMinimumSize(getSize());
        setPreferredSize(new Dimension(1400, 700));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

}
