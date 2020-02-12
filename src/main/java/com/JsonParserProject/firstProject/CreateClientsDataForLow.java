package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CreateClientsDataForLow implements Runnable {

    public void createClientsDataForLow() {
      JPanelForLowerTable jPanelForLowerTable = new JPanelForLowerTable();
        ObjectMapper objectMapper = new ObjectMapper();
        PathJsonFilesRead pathJsonFilesRead = new PathJsonFilesRead();

        try {
            CreateFirstMapFromJson createClientsNamesForLow = objectMapper.readValue(pathJsonFilesRead.readFileFromLowerTable(), CreateFirstMapFromJson.class);
            jPanelForLowerTable.insertClientsNameForTable(createClientsNamesForLow, createClientsNamesForLow.getClientsMap());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void run() {
        createClientsDataForLow();
    }
}
