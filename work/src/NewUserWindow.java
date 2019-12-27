public class NewUserWindow {
    private String name;
    private int age;
    private int salary;

    public NewUserWindow(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return name;
    }

    public String getAge() {
        return String.valueOf(age);

    }

    public String getSalary() {
        return String.valueOf(salary);
    }

}
