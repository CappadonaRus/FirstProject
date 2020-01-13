import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


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

    public void createClientsData(File file)  {
        try {
            NewUserWindow newUserWindow = objectMapper.readValue(file, NewUserWindow.class);
            newUserWindow.printClientsData();


            //можно вызвать data.values() для получения списка или data.size() для количества
        }
        catch(JsonProcessingException jpe){
            jpe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
