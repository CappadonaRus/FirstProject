import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JackSonReadFIle {
    ObjectMapper objectMapper = new ObjectMapper();
//  String testStr = "{\"firstName\":\"ivan\",\"lastName\": \"Ivanov\", \"age\": \"30\",\"salary\": \"100000\"}";
/*
    public void readAndWriteFile(Object obj){
        try {
            JsonFileValues jsonFileValues =  objectMapper.readValue(obj, JsonFileValues.class );
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException en) {
            en.printStackTrace();
        }

    }
*/

    public JsonFileValues createClientsData(File file) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            JSONObject jsonObject = new JSONObject(content);

            return objectMapper.readValue(jsonObject.get("Иванов").toString(),JsonFileValues.class);

        } catch (IOException jpe) {
            jpe.printStackTrace();
            return null;
        }
    }
}
