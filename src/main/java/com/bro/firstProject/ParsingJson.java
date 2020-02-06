

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;



/*
public class ParsingJson {

    ArrayList<String> array = new ArrayList<>();

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

    public void getValuesAt(){
        System.out.println(middleName);
        System.out.println(type);
        System.out.println(number);
    }


    public void insertMapDetails(Map<String, Object> map) {
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> pair = iterator.next();
            Object value = String.valueOf(pair.getValue());
            try {

                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse((String) value);
                fio = (String) obj.get("fio");
                lastName = (String) obj.get("lastName");
                firstName = (String) obj.get("firstName");
                middleName = (String) obj.get("middleName");
                birthDate = (String) obj.get("birthDate");
                card = (String) obj.get("card");
                sessionType = (String) obj.get("sessionType");
                document = (String) obj.get("document");
                type = (String) obj.get("type");
                series = (String) obj.get("series");
                number = (String) obj.get("number");
                seriesNumber = (String) obj.get("seriesNumber");

            } catch (ParseException e) {
                e.printStackTrace();

            }


        }
    }
}

 */
