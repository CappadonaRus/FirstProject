package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ClientsDataForCenterJPanel implements Runnable {

    public void createClientsDataForLow() {
      CenterJPanel centerJPanel = new CenterJPanel();
        ObjectMapper objectMapper = new ObjectMapper();
        ResourcesPathReadAllFiles resourcesPathReadAllFiles = new ResourcesPathReadAllFiles();

        try {
            JsonToMapForAll createClientsNamesForLow = objectMapper.readValue(resourcesPathReadAllFiles.readFileFromLowerTable(), JsonToMapForAll.class);
            centerJPanel.insertClientsNameForTable(createClientsNamesForLow, createClientsNamesForLow.getClientsMap());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void run() {
        createClientsDataForLow();
    }
}
