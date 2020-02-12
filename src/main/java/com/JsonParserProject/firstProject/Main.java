package com.JsonParserProject.firstProject;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        JackSonReadToRightFile jackSonReadToRightFIle = new JackSonReadToRightFile();
        Thread childThread = new Thread(jackSonReadToRightFIle);
        childThread.start();

        CreateClientsDataForRightTable createClientsDataForRightTable = new CreateClientsDataForRightTable();
        Thread secondChildThread2 = new Thread(createClientsDataForRightTable);
        secondChildThread2.start();
        secondChildThread2.join();

        CreateClientsDataForLow createClientsDataForLow = new CreateClientsDataForLow();
        Thread fourthChildThread = new Thread(createClientsDataForLow);
        fourthChildThread.start();
        fourthChildThread.join();

        CreateBothTables createBothTables = new CreateBothTables();
        createBothTables.createFrame();




    }

}
