package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class RightTableJackSonParse {
    CreateFirstMapFromJson createFirstMapFromJson;

    Map<Object, Object> dataRightTable = new LinkedHashMap<>();

    public void insertDetailsForRightTable(CreateFirstMapFromJson obj, Object obj2) {
        createFirstMapFromJson = obj;
        dataRightTable = Collections.synchronizedMap((Map) obj2);
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


