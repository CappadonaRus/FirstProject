package com.JsonParserProject.firstProject;


public class Main {
    public static void main(String[] args) {

        JackSonReadFIle jackSonReadFIle = new JackSonReadFIle();
        jackSonReadFIle.createClientsDataForRight();
        jackSonReadFIle.createClientsDataForLeft();
        CreateBothTables createBothTables = new CreateBothTables();
        createBothTables.createFrame();

    }

}
