package com.JsonParserProject.firstProject;

import javax.swing.*;

public class InsertedFinalDetailsFromAll extends JPanel {
    private Object leftTableObject;
    private Object rightTableObject;
    private Object lowPanelObject;

    public Object getLeftTableObject() {
        return leftTableObject;
    }

    public Object getRightTableObject() {
        return rightTableObject;
    }

    public Object getLowPanelObject() {
        return lowPanelObject;
    }

    public void saveAllObjects(Object obj1, Object obj2, Object obj3) {
        this.leftTableObject = obj1;
        this.rightTableObject = obj2;
        this.lowPanelObject = obj3;
        testObjects(obj2);
    }

    public void testObjects(Object obj){
        PoJoFromLeftTable poJoFromLeftTable = ((PoJoFromLeftTable) obj);
        System.out.println(poJoFromLeftTable.getLastName());

    }
}
