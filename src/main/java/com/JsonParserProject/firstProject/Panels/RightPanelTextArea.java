package com.JsonParserProject.firstProject.Panels;

import com.JsonParserProject.firstProject.Core.InsertedFinalDetailsFromAll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightPanelTextArea extends JFrame {
    static JTextArea textArea = new JTextArea();
    JPanel textPanel = new JPanel();

    public JPanel createTextPanel() {

        textArea.setRows(8);
        textArea.setColumns(1);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textPanel.setMaximumSize(new Dimension(100, 50));
        textPanel.add(textArea);
        textPanel.add(createLowPanel());
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        return textPanel;
    }

    public JPanel createLowPanel() {
        JPanel lowPanel = new JPanel();
        JButton buttonStart = new JButton("Run");
        buttonStart.setPreferredSize(new Dimension(200, 35));
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RightJPanel rightJPanel = new RightJPanel();
                LeftJPanel leftJPanel = new LeftJPanel();
                CenterJPanel centerJPanel = new CenterJPanel();
                InsertedFinalDetailsFromAll insertedFinalDetailsFromAll = new InsertedFinalDetailsFromAll();
                    insertedFinalDetailsFromAll.saveAllObjects(leftJPanel.getLeftPanelValue(), rightJPanel.getRightPanelValue(),
                            centerJPanel.getCentralPanelValue(), rightJPanel.getButtonChooseValue());



            }
        });
        lowPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 3, 3));
        lowPanel.add(buttonStart, BorderLayout.SOUTH);
        return lowPanel;
    }

    public void setTextArea(String value) {
        textArea.append(value + "\n");
    }

}
