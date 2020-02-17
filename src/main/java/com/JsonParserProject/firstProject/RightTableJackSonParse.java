package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import java.util.Map;


public class RightTableJackSonParse {
    private JsonToMapForAll jsonToMapForAll;

    public void setJsonToMapForAll(JsonToMapForAll jsonToMapForAll) {
        this.jsonToMapForAll = jsonToMapForAll;
    }

    public void insertDetailsForRightTable(JsonToMapForAll obj, Object obj2) {
        setJsonToMapForAll(obj);
        convertClientsDetails("operators", jsonToMapForAll.getClientsMap());
    }

    public void convertClientsDetails(String value, Map map) {
        RightJPanel rightJPanel = new RightJPanel();
        ObjectMapper objectMapper = new ObjectMapper();
        Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> pair = iterator.next();
            if (((String) pair.getKey()).contains(value)) {
                try {
                    JsonToMapForAll jsonToMapForAll2 = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), JsonToMapForAll.class);
                    rightJPanel.insertClientsNameForTable(jsonToMapForAll2, jsonToMapForAll2.getClientsMap());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


