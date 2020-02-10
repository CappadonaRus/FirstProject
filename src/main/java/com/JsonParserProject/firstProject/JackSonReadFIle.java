package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JackSonReadFIle {
    ObjectMapper objectMapper = new ObjectMapper();
    PathJsonFilesRead pathJsonFilesRead = new PathJsonFilesRead();

    public void createClientsDataForLeft() {
        JPanelForLeftTable jpanelForLeftTable = new JPanelForLeftTable();
        try {
            CreateFirstMapFromJson createFirstMapFromJson = objectMapper.readValue(pathJsonFilesRead.readFileFromLeftTable(), CreateFirstMapFromJson.class);
            jpanelForLeftTable.insertClientsNameForTable(createFirstMapFromJson, createFirstMapFromJson.getClientsMap());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}


