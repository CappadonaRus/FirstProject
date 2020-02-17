package com.JsonParserProject.firstProject.Core;

import com.JsonParserProject.firstProject.Panels.LeftJPanel;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class LeftJPanelJackSonReadFile implements Runnable {


    public void createClientsDataForLeft() {
        ObjectMapper objectMapper = new ObjectMapper();
        ResourcesPathReadAllFiles resourcesPathReadAllFiles = new ResourcesPathReadAllFiles();
        LeftJPanel jpanelForLeftJPanel = new LeftJPanel();
        try {
            JsonToMapForAll jsonToMapForAll = objectMapper.readValue(resourcesPathReadAllFiles.readFileFromLeftTable(), JsonToMapForAll.class);
            jpanelForLeftJPanel.insertClientsNameForTable(jsonToMapForAll, jsonToMapForAll.getClientsMap());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void run() {
        createClientsDataForLeft();
    }
}


