import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

// Новый класс для альтернативной попытки распарсить джисон через 2 мапы

/*
public class TestParseInnerJson {
    public LinkedHashMap<String, Object> innerDocumentFields = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getClientsMap() {
        return innerDocumentFields;
    }

    @JsonAnySetter
    public void setClientsMap(String name, Object value) {
        innerDocumentFields.put(name, value);
    }

    public Map<String, Object> clientsNames() {
        return innerDocumentFields;
    }

    public void printClientsData() {
        Iterator<Map.Entry<String, Object>> iterator = innerDocumentFields.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            String key = pair.getKey();
            Object value = pair.getValue();
            //System.out.println(key + " : " + value);

        }
    }
}

 */
