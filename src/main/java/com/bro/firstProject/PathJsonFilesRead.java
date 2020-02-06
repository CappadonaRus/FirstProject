package com.bro.firstProject;

import java.io.*;

public class PathJsonFilesRead {

    public File readFileFromLeftTable() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("firstTableJson.json").getFile());
    }

    public File readFileFromRightTable() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("secondTableJson.json").getFile());
    }


}
