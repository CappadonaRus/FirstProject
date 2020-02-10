package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JackSonReadFIle implements Runnable {


    public void createClientsDataForLeft() {
        ObjectMapper objectMapper = new ObjectMapper();
        PathJsonFilesRead pathJsonFilesRead = new PathJsonFilesRead();
        JPanelForLeftTable jpanelForLeftTable = new JPanelForLeftTable();
        try {
            CreateFirstMapFromJson createFirstMapFromJson = objectMapper.readValue(pathJsonFilesRead.readFileFromLeftTable(), CreateFirstMapFromJson.class);
            jpanelForLeftTable.insertClientsNameForTable(createFirstMapFromJson, createFirstMapFromJson.getClientsMap());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void run() {
        createClientsDataForLeft();
    }
}


