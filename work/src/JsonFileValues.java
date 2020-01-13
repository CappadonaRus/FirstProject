

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
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
    public CustomerDocument document = new CustomerDocument();

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getSessionType() {
        return sessionType;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public CustomerDocument getDocument() {
        return document;
    }

    public void setDocument(CustomerDocument document) {
        this.document = document;
    }

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

public class CustomerDocument {
    public String type;
    public String series;
    public String number;
    public String seriesNumber;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(String seriesNumber) {
        this.seriesNumber = seriesNumber;
    }
}


    public void getValues() {
        System.out.println(firstName);
        System.out.println(lastName);

    }

    public static void convertClientsDetails(Map map) {

        ObjectMapper objectMapper = new ObjectMapper();
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
           Object value = pair.getValue();
           //Reader reader = new StringReader((String) value);
            try {
                JsonFileValues jsonFileValues = objectMapper.readValue(value.toString(), JsonFileValues.class);
                jsonFileValues.getValues();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}

