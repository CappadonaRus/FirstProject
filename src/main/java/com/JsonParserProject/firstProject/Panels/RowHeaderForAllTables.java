package com.JsonParserProject.firstProject.Panels;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class RowHeaderForAllTables extends JLabel implements ListCellRenderer {
    public RowHeaderForAllTables(JTable table) {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
