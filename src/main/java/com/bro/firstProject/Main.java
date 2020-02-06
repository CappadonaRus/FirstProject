package com.bro.firstProject;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        JackSonReadFIle jackSonReadFIle = new JackSonReadFIle();
        jackSonReadFIle.createClientsDataForRight();
        jackSonReadFIle.createClientsDataForLeft();
        CreateBothTables createBothTables = new CreateBothTables();
        createBothTables.createFrame();

    }

}
