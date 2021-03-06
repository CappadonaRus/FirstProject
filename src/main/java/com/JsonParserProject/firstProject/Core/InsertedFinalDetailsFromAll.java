package com.JsonParserProject.firstProject.Core;

import com.JsonParserProject.firstProject.Panels.RightPanelTextArea;

public class InsertedFinalDetailsFromAll {

 private String dropValueFromLeftPanel;
 private String dropValueFromRightPanel;
 private String dropValueFromCentralPanel;
 private String valueFromRadioButton;

    public String getDropValueFromLeftPanel() {
        return dropValueFromLeftPanel;
    }

    public void setDropValueFromLeftPanel(String dropValueFromLeftPanel) {
        this.dropValueFromLeftPanel = dropValueFromLeftPanel;
    }

    public String getDropValueFromRightPanel() {
        return dropValueFromRightPanel;
    }

    public void setDropValueFromRightPanel(String dropValueFromRightPanel) {
        this.dropValueFromRightPanel = dropValueFromRightPanel;
    }

    public String getDropValueFromCentralPanel() {
        return dropValueFromCentralPanel;
    }

    public void setDropValueFromCentralPanel(String dropValueFromCentralPanel) {
        this.dropValueFromCentralPanel = dropValueFromCentralPanel;
    }

    public String getValueFromRadioButton() {
        return valueFromRadioButton;
    }

    public void setValueFromRadioButton(String valueFromRadioButton) {
        this.valueFromRadioButton = valueFromRadioButton;
    }

    public void saveAllObjects(String leftPanelValue, String rightPanelValue, String centralPanelValue, String buttonChooseValue) {
        RightPanelTextArea rightPanelTextArea = new RightPanelTextArea();

        setDropValueFromLeftPanel(leftPanelValue);
        setDropValueFromRightPanel(rightPanelValue);
        setDropValueFromCentralPanel(centralPanelValue);
        setValueFromRadioButton(buttonChooseValue);
        String detailsForTextArea = leftPanelValue + " " + rightPanelValue + " " + centralPanelValue + " " + buttonChooseValue;
       rightPanelTextArea.setTextArea(detailsForTextArea);

    }

}
