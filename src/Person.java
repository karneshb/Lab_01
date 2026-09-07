import java.util.Calendar;

public class Person {
    private String IDnum;
    private String firstName;
    private String lastName;
    private String title;
    private String birthYear;

    public Person(String IDnum, String firstName, String lastName, String title, String birthYear) {
        this.IDnum = IDnum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.birthYear = birthYear;
    }

    public String getIDnum() {
        return IDnum;
    }
    public void setIDnum(String IDnum) {
        this.IDnum = IDnum;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }


    public String fullName(){
        return firstName + " " + lastName;
    }
    public String formalName(){
        return title + " " + firstName + " " + lastName;
    }
    public String getAge(){
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int age = currentYear - Integer.parseInt(birthYear);
        return String.valueOf(age);
    }
    public String getAge(int Year){
        int age = Year - Integer.parseInt(birthYear);
        return String.valueOf(age);
    }


    @Override
    public String toString() {
        return "Person{" +
                "IDnum='" + IDnum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", birthYear='" + birthYear + '\'' +
                '}';
    }

    public String toCSV(){
        return IDnum + ", " + firstName + ", " + lastName + ", " + title + ", " + birthYear;
    }

    public String toJSON(){
        return "{ \"IDnum\": \"" + IDnum + "\", \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"title\": \"" + title + "\", \"birthYear\": \"" + birthYear + "\" }";
    }

    public String toXML(){
        return "<Person><IDnum>" + IDnum + "</IDnum><firstName>" + firstName + "</firstName><lastName>" + lastName + "</lastName><title>" + title + "</title><birthYear>" + birthYear + "</birthYear></Person>";
    }
}
