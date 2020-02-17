package com.JsonParserProject.firstProject;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.*;

public class JsonToMapForAll {
    private LinkedHashMap<String, Object> clientsData = new LinkedHashMap<>();

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




