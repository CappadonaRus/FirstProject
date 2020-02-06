package com.bro.firstProject;

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

    public void createClientsDataForRight() {

        PathJsonFilesRead pathJsonFilesRead = new PathJsonFilesRead();
        RightTableJackSonFirstParse rightTableJackSonFirstParse = new RightTableJackSonFirstParse();

        try {
            CreateFirstMapFromJson createFirstMapFromJson2 = objectMapper.readValue(pathJsonFilesRead.readFileFromRightTable(), CreateFirstMapFromJson.class);
            rightTableJackSonFirstParse.insertDetailsForRightTable(createFirstMapFromJson2, createFirstMapFromJson2.getClientsMap());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
