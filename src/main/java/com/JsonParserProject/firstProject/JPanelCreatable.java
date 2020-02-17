package com.JsonParserProject.firstProject;

import javax.swing.*;
import java.awt.*;

public interface JPanelCreatable {

     JPanel createUpperPane();

     JPanel createUpperComboPanel();

    JPanel createDroppingButtonsPanel();

    default JButton createAddNewButton() {
        return new JButton("Add new Button");
    }
}
