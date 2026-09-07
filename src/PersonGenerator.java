import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;



public class PersonGenerator
{
    public static void main(String[] args)
    {
        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        boolean userDone = false;

        Person personRecord;
        String ID = "000000";
        String firstName = "";
        String lastName = "";
        String title = "";
        int birthYear = 0;


        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            birthYear = SafeInput.getRangedInt(in, "Enter the birth year", 1940, 2010);

            personRecord = new Person(ID, firstName, lastName, title, String.valueOf(birthYear));

            people.add(personRecord);

            userDone = SafeInput.getYNConfirm(in, "Are you done entering people? ");

        }while(!userDone);

        for(Person p: people)
        {
            System.out.println(p);
        }

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(Person p: people){
                writer.write(p.toCSV(), 0, p.toCSV().length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }
}

