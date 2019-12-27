import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToJson extends ActionsWindow {
    private String[][] infoInTable;
    private int getRowCount;
    private int getColumnCount;
    private String fileName;

    public void giveDetails(String[][] table, int row, int col) {
        this.infoInTable = table;
        this.getRowCount = row;
        this.getColumnCount = col;
        runningSave();
    }

    public void runningSave() {


    }
}


