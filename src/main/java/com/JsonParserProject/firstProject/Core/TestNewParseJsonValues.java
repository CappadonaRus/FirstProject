import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


// Новый класс для альтернативной попытки распарсить джисон через 2 мапы



/*
public class TestNewParseJsonValues {
    public LinkedHashMap<String, Object> clientsColumnAndFields = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getClientsMap() {
        return clientsColumnAndFields;
    }

    @JsonAnySetter
    public void setClientsMap(String name, Object value) {
        clientsColumnAndFields.put(name, value);
    }

    public Map<String, Object> clientsNames() {
        return clientsColumnAndFields;
    }

    public void printClientsData() {

        JsonFileValues jsonFileValues = new JsonFileValues();
        ArrayList<String> clientsName = new ArrayList<>();
        Iterator<Map.Entry<String, Object>> iterator = clientsColumnAndFields.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            String key = pair.getKey();
            Object value = pair.getValue();
            clientsName.add(pair.getKey());
            // System.out.println(key + " : " + value);

        }


    }
}

 */
