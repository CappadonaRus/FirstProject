import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;


public class ChangeAndSaveToJson {

    String[][] data = new String[getRowCount()][getColumnCount()];
    HashMap<String, String> map = new HashMap<>();

    public void convertToMapAndSaveToJson() {
        //
        // Map<String, String> states = Arrays.stream(data).collect(Collectors.toMap(e -> e[0], e -> e[1]));
        for (int i = 0; i < data.length; i++){
            map.put(data[0][0], data[0][i]);
        }
        writeJson(map);
    }

    // write to output file
    public void writeJson(Map obj) {
        JSONObject object = new JSONObject(obj);

        try {
            Writer fileWriter;
            fileWriter = new FileWriter(ParsingJson.getFile());
            fileWriter.write(object.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getRowCount() {
        return 1;
    }

    public int getColumnCount() {
        return ParsingJson.count;
    }

    public void setValueAT(String[][] value, Object obj, int row, int col) {
        data = value;
        value[row][col] = String.valueOf(obj);
    }

}

