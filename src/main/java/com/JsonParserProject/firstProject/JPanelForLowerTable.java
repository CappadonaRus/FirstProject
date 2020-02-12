package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class JPanelForLowerTable extends JPanel implements JPanelCreatable {
    static private ArrayList<String> clientsNamesForTable = new ArrayList<>();
    static private CreateFirstMapFromJson ClientsPoJoForLower;
    private static BufferedImage image;
    static JLabel jLabel = new JLabel("some photo");
    static JPanel upperPanel = new JPanel(new BorderLayout(5, 5));

    public void insertClientsNameForTable(CreateFirstMapFromJson obj, Map map) {
        ClientsPoJoForLower = obj;

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            clientsNamesForTable.add(pair.getKey());
        }
    }

    public void setImage(BufferedImage img) {
        image = img;

        Image tmp = img.getScaledInstance(jLabel.getWidth(), jLabel.getHeight(), Image.SCALE_SMOOTH);
        img = new BufferedImage(jLabel.getWidth(), jLabel.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        ImageIcon icon = new ImageIcon(img);
        jLabel.setIcon(icon);

    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }


    public JPanel createUpperPane() {
        upperPanel.add(createUpperComboPanel(), BorderLayout.NORTH);
        upperPanel.add(jLabel, BorderLayout.CENTER);
        return upperPanel;
    }


    @Override
    public JPanel createDroppingButtonsPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setBorder(new TitledBorder("Border"));
        jpanel.add(createComboTable());
        jpanel.add(createAddNewButton());
        return jpanel;
    }

    public JComboBox createComboTable() {

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

    public void convertMapToData(String value) {
        DecodingBase64 decodingBase64 = new DecodingBase64();
        ObjectMapper objectMapper = new ObjectMapper();

        Iterator<Map.Entry<String, Object>> iterator = ClientsPoJoForLower.getClientsMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            if (pair.getKey().contains(value)) {
                try {
                    PojoLowerTable pojoLowerTable = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), PojoLowerTable.class);
                    setImage(decodingBase64.decoding(pojoLowerTable.getModality()));

                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
