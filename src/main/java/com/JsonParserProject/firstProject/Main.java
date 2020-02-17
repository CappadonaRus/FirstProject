package com.JsonParserProject.firstProject;


import com.JsonParserProject.firstProject.Core.ClientsDatForRightJPanel;
import com.JsonParserProject.firstProject.Core.ClientsDataForCenterJPanel;
import com.JsonParserProject.firstProject.Core.LeftJPanelJackSonReadFile;
import com.JsonParserProject.firstProject.Panels.CreateBothTables;

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
