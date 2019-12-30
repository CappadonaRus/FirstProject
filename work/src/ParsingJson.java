import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class ParsingJson {


    public static int count;
    private static String firstName;
    private static String LastName;
    private static Long id;
    private static Long age;
    private static Long salary;
    private static File file;

    public static File getFile() {
        return file;
    }

    public void parsingFIle(File file) {
        this.file = file;
        readingFile(file);
    }

    public static String getFirstName() {

        return firstName;
    }

    public static String getLastName() {

        return LastName;
    }

    public static Long getId() {

        return id;
    }

    public static Long getAge() {

        return age;
    }


    public static Long getSalary() {
        return salary;
    }

    public static void readingFile(File file) {

        try {
            FileReader fileReader = new FileReader(file);

            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(fileReader);
            firstName = (String) obj.get("firstName");
            count++;
            LastName = (String) obj.get("lastName");
            count++;
            age = (Long) obj.get("age");
            count++;
            salary = (Long) obj.get("salary");
            count++;
            id = (Long) obj.get("id");
            count++;
            fileReader.close();


        } catch (IOException | ParseException e) {
            e.printStackTrace();

        }


    }
}
