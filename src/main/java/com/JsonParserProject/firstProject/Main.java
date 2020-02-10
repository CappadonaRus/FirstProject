package com.JsonParserProject.firstProject;


public class Main {
    public static void main(String[] args) {

        JackSonReadFIle jackSonReadFIle = new JackSonReadFIle();
        jackSonReadFIle.createClientsDataForLeft();

        CreateClientsDataForRightTable createClientsDataForRightTable = new CreateClientsDataForRightTable();
        Thread childThread = new Thread(createClientsDataForRightTable);
        childThread.start();

        CreateBothTables createBothTables = new CreateBothTables();
        Thread childThread2 = new Thread(createBothTables);
        childThread2.start();



    }

}
