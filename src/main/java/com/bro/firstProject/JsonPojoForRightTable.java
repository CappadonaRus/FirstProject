package com.bro.firstProject;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class JsonPojoForRightTable {
    String selfkey;
    String confirmKey;
    String login;
    String password;
    String fullName;
    String branch;
    String lastName;
    String firstName;
    String middleName;

    public String getSelfkey() {
        return selfkey;
    }

    public void setSelfkey(String selfkey) {
        this.selfkey = selfkey;
    }

    public String getConfirmKey() {
        return confirmKey;
    }

    public void setConfirmKey(String confirmKey) {
        this.confirmKey = confirmKey;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    public void convertClientsDetails(String value, Map map) {
        RightTableTemp rightTableTemp = new RightTableTemp();
        ObjectMapper objectMapper = new ObjectMapper();
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            if (pair.getKey().contains(value)) {
                try {
                    JsonPojoForRightTable jsonPojoForRightTable1 = objectMapper.readValue(objectMapper.writeValueAsString(pair.getValue()), JsonPojoForRightTable.class);
                    rightTableTemp.createClientsData(jsonPojoForRightTable1);

                    //SplitPaneCreate.createColumnsNames();


                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
