package com.JsonParserProject.firstProject.Panels;

import com.JsonParserProject.firstProject.Core.DecodingBase64ForCenterJPanel;
import com.JsonParserProject.firstProject.Core.JsonToMapForAll;
import com.JsonParserProject.firstProject.Panels.PoJo.PoJoForCentralTable;
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


public class CenterJPanel extends JPanel implements JPanelCreatable {
    static private ArrayList<String> clientsNamesForTable = new ArrayList<>();
    static private JsonToMapForAll ClientsPoJoForLower;
    final static JLabel jLabel = new JLabel( "photo", JLabel.CENTER);
    final JPanel upperPanel = new JPanel(new BorderLayout(5, 5));
    private static String centralPanelValue;

    public String getCentralPanelValue() {
        return centralPanelValue;
    }

    public void setCentralPanelValue(String centralPanelValue) {
        CenterJPanel.centralPanelValue = centralPanelValue;

    }

    public void insertClientsNameForTable(JsonToMapForAll obj, Map map) {
        ClientsPoJoForLower = obj;

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            clientsNamesForTable.add(pair.getKey());
        }
    }

    public void setImage(BufferedImage img) {

        Image tmp = img.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        img = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = img.createGraphics();

        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        ImageIcon icon = new ImageIcon(img);
        jLabel.setText(null);
        jLabel.setIcon(icon);

    }


    public JPanel createUpperPane() {
        upperPanel.setName("LowJPanel");
        upperPanel.add(createUpperComboPanel(), BorderLayout.NORTH);
        upperPanel.add(JLabelProp(), BorderLayout.CENTER);
        return upperPanel;
    }

    @Override
    public JPanel createUpperComboPanel() {
        JPanel panel = new JPanel();
        panel.setName("LowTableComboPanel");
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setPreferredSize(new Dimension(150, 50));
        panel.add(createDroppingButtonsPanel());
        return panel;
    }

    public JLabel JLabelProp() {
        jLabel.setName("LowPanelJLabel");
        jLabel.setMinimumSize(new Dimension(200, 200));
        jLabel.setPreferredSize(new Dimension(200, 200));
        return jLabel;
    }


    @Override
    public JPanel createDroppingButtonsPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setName("LowDroppingPanel");
        jpanel.add(createComboTable());
        jpanel.add(createAddNewButton());
        return jpanel;
    }

    public JComboBox createComboTable() {

        JComboBox comboButton = new JComboBox(clientsNamesForTable.toArray());
        comboButton.setName("LowPanelComboBox");
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
        setCentralPanelValue(value);
        DecodingBase64ForCenterJPanel decodingBase64ForCenterJPanel = new DecodingBase64ForCenterJPanel();
        ObjectMapper objectMapper = new ObjectMapper();

        Iterator<Map.Entry<String, Object>> iterator = ClientsPoJoForLower.getClientsMap().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            if (pair.getKey().contains(value)) {
                try {
                    PoJoForCentralTable poJoForCentralTable = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), PoJoForCentralTable.class);
                    setImage(decodingBase64ForCenterJPanel.decoding(poJoForCentralTable.getModality()));

                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
