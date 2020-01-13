

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;


public class JsonFileValues {

    public String fio;
    public String lastName;
    public String firstName;
    public String middleName;
    public String birthDate;
    public String card;
    public String sessionType;
    public String document;
    public String type;
    public String series;
    public String number;
    public String seriesNumber;

/*
    public JsonFileValues(@JsonProperty("fio") String fio, @JsonProperty("lastName") String lastName,
                          @JsonProperty("firstName") String firstName, @JsonProperty("middleName") String middleName,
                          @JsonProperty("birthDate") String bitrhDate, @JsonProperty("card") String card,
                          @JsonProperty("sessionType") String sessionType, @JsonProperty("document") String document,
                          @JsonProperty("type") String type, @JsonProperty("series") String series,
                          @JsonProperty("number") String number, @JsonProperty("seriesNumber") String seriesNumber) {
        this.fio = fio;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = bitrhDate;
        this.card = card;
        this.sessionType = sessionType;
        this.document = document;
        this.type = type;
        this.series = series;
        this.number = number;
        this.seriesNumber = seriesNumber;
        getValues();
    }

 */


    public void getValues() {
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(number);

    }

    public static void convertClientsDetails(Map map) {

        //  String values ="{\"fio\" : \"ivan ivanov ivanovich\", \"lastName\" : \"ivanov\", \"middleName\" : \"yurievich\", " +
        //         "\"birthDate\" : \"1950-01-01\", \"card\" : \"4274380077455568\", \"sessionType\" : \"0\", \"document\" : \"null\", " +
        //         "\"type\" : \"21\" , \"series\" : \"34 25\", \"number\" : \"245824\", \"seriesNumber\" : \"3452245824\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
           Object value = pair.getValue();
           //Reader reader = new StringReader((String) value);
            try {
                JsonFileValues jsonFileValues = objectMapper.readValue((String) value, JsonFileValues.class);
                jsonFileValues.getValues();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

