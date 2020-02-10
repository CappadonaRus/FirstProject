package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import java.util.Map;


public class RightTableJackSonParse {
    private CreateFirstMapFromJson createFirstMapFromJson;

    public void setCreateFirstMapFromJson(CreateFirstMapFromJson createFirstMapFromJson) {
        this.createFirstMapFromJson = createFirstMapFromJson;
    }

    public void insertDetailsForRightTable(CreateFirstMapFromJson obj, Object obj2) {
        setCreateFirstMapFromJson(obj);
        convertClientsDetails("operators", createFirstMapFromJson.getClientsMap());
    }

    public void convertClientsDetails(String value, Map map) {
        JPanelFromRightTable jPanelFromRightTable = new JPanelFromRightTable();
        ObjectMapper objectMapper = new ObjectMapper();
        Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> pair = iterator.next();
            if (((String) pair.getKey()).contains(value)) {
                try {
                    CreateFirstMapFromJson createFirstMapFromJson2 = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), CreateFirstMapFromJson.class);
                    jPanelFromRightTable.insertClientsNameForRightTable(createFirstMapFromJson2, createFirstMapFromJson2.getClientsMap());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


