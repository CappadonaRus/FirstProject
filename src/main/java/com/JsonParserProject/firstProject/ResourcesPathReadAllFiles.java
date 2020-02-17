package com.JsonParserProject.firstProject;

import java.io.*;

public class ResourcesPathReadAllFiles {

    public File readFileFromLeftTable() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("firstTableJson.json").getFile());
    }

    public File readFileFromRightTable() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("secondTableJson.json").getFile());
    }

    public File readFileFromLowerTable() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("thirdTableJson.json").getFile());
    }
}
