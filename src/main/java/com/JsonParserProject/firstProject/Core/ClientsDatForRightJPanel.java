package com.JsonParserProject.firstProject.Core;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ClientsDatForRightJPanel implements Runnable {

    public void createClientsDataForRight() {
        ObjectMapper objectMapper = new ObjectMapper();
        ResourcesPathReadAllFiles resourcesPathReadAllFiles = new ResourcesPathReadAllFiles();
        RightTableJackSonParse rightTableJackSonParse = new RightTableJackSonParse();

        try {
            JsonToMapForAll jsonToMapForAll2 = objectMapper.readValue(resourcesPathReadAllFiles.readFileFromRightTable(), JsonToMapForAll.class);
            rightTableJackSonParse.insertDetailsForRightTable(jsonToMapForAll2, jsonToMapForAll2.getClientsMap());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public void run() {
        createClientsDataForRight();
    }
}
