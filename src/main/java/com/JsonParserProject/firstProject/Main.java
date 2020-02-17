package com.JsonParserProject.firstProject;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        LeftJPanelJackSonReadFile leftJPanelJackSonReadFIle = new LeftJPanelJackSonReadFile();
        Thread childThread = new Thread(leftJPanelJackSonReadFIle);
        childThread.start();

        ClientsDatForRightJPanel clientsDatForRightJPanel = new ClientsDatForRightJPanel();
        Thread secondChildThread2 = new Thread(clientsDatForRightJPanel);
        secondChildThread2.start();
        secondChildThread2.join();

        ClientsDataForCenterJPanel clientsDataForCenterJPanel = new ClientsDataForCenterJPanel();
        Thread fourthChildThread = new Thread(clientsDataForCenterJPanel);
        fourthChildThread.start();
        fourthChildThread.join();

        new CreateBothTables();


    }

}
