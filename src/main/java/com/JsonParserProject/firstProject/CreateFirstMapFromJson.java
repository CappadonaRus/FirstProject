package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.*;

public class CreateFirstMapFromJson {
    public LinkedHashMap<String, Object> clientsData = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getClientsMap() {
        return clientsData;
    }

    @JsonAnySetter
    public void setClientsMap(String name, Object value) {
        clientsData.put(name, value);
    }

    public Map<String, Object> clientsNames() {
        return clientsData;
    }

}


//колхозный вариант представления как распарсена мапа метода convertParsedMap
        /*
        ArrayList<String> clientsName = new ArrayList<>();
        Iterator<Map.Entry<String, Object>> iterator = clientsData.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            String key = pair.getKey();
            Object value = pair.getValue();
            clientsName.add(pair.getKey());
            // System.out.println(key + " : " + value);
            }
            /представление как распарсена мапа метода convertParsedMap
         */



