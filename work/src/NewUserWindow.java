import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NewUserWindow {
    public Map<String, Object> clientsData = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getClientsMap() {
        return clientsData;
    }

    @JsonAnySetter
    public void setClientsMap(String name, Object value) {
        clientsData.put(name, value);
    }


    public void printClientsData() {
        Iterator<Map.Entry<String, Object>> iterator = clientsData.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            String key = pair.getKey();
            Object value = pair.getValue().toString();
            System.out.println(key + " : " + value);

        }
        JsonFileValues.convertClientsDetails(clientsData);
    }
}


