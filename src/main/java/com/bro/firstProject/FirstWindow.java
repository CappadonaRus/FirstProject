/*
package com.bro.firstProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


// выпилен за ненадобностью


public class FirstWindow extends JFrame {

    private static File file;


    public FirstWindow() {
        setName("For Braza");
        createWindow();
    }

    public void createWindow() {

        final JPanel panel = new JPanel();

        panel.add(createButton());
        panel.add(createFramesButton());
        panel.add(createSomeActionButton());

        setSize(400, 150);
        setLocationRelativeTo(null);

        getContentPane().add(panel);
        setPreferredSize(new Dimension(500, 500));
            setMinimumSize(panel.getSize());
    }

    public JButton createButton() {
        JButton button1 = new JButton("«Button 1″");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final JFileChooser fileOpener = new JFileChooser();
                int openFile = fileOpener.showDialog(null, "Открыть файл");
                if (openFile == JFileChooser.APPROVE_OPTION) {
                    file = fileOpener.getSelectedFile();
                }
               // JackSonReadFIle jackSonReadFIle = new JackSonReadFIle();
               // jackSonReadFIle.createClientsData(file);

            }
        });
        return button1;
    }

    public JButton createFramesButton() {
        JButton button2 = new JButton("«Button 2″");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        return button2;
    }

    public JButton createSomeActionButton() {
        JButton button3 = new JButton("«Button 3″");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        return button3;
    }
}

 */
