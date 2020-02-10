package com.JsonParserProject.firstProject;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        JackSonReadFIle jackSonReadFIle = new JackSonReadFIle();
        Thread childThread = new Thread(jackSonReadFIle);
        childThread.start();

        CreateClientsDataForRightTable createClientsDataForRightTable = new CreateClientsDataForRightTable();
        Thread secondChildThread2 = new Thread(createClientsDataForRightTable);
        secondChildThread2.start();
        secondChildThread2.join();

        CreateBothTables createBothTables = new CreateBothTables();
        createBothTables.createFrame();



    }

}
