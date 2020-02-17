package com.JsonParserProject.firstProject;

import javax.swing.*;
import java.awt.*;

public class CreateBothTables extends JFrame {

    public CreateBothTables(){
        setName("MainFrame");
        createFrame();
    }


    public void createFrame() {
        LeftJPanel leftJPanel = new LeftJPanel();
        RightJPanel rightJPanel = new RightJPanel();
        CenterJPanel centerJPanel = new CenterJPanel();

        getContentPane().add(rightJPanel.createUpperPane(), BorderLayout.EAST);
        getContentPane().add(leftJPanel.createUpperPane(), BorderLayout.WEST);
        getContentPane().add(centerJPanel.createUpperPane(), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setLocationByPlatform(true);
        setMinimumSize(getSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

}
