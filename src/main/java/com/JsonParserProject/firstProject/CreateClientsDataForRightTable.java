package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class CreateClientsDataForRightTable implements Runnable {

    public void createClientsDataForRight() {
        ObjectMapper objectMapper = new ObjectMapper();
        PathJsonFilesRead pathJsonFilesRead = new PathJsonFilesRead();
        RightTableJackSonParse rightTableJackSonParse = new RightTableJackSonParse();

        try {
            CreateFirstMapFromJson createFirstMapFromJson2 = objectMapper.readValue(pathJsonFilesRead.readFileFromRightTable(), CreateFirstMapFromJson.class);
            rightTableJackSonParse.insertDetailsForRightTable(createFirstMapFromJson2, createFirstMapFromJson2.getClientsMap());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void run() {
        createClientsDataForRight();
    }
}
