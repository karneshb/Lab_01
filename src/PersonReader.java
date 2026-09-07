import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        String formatHeader = "%-8s %-15s %-15s %-10s %-6s%n";
        String formatRows = "%-8s %-15s %-15s %-10s %-6s%n";
        Person currentPerson;

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                /* int line = 0; */
                System.out.printf(formatHeader, "ID", "First Name", "Last Name", "Title", "Birth Year");
                System.out.println("-------------------------------------------------------------------");

                while(reader.ready())
                {
                    rec = reader.readLine();

                    String [] fields = rec.split(", ");
                    currentPerson = new Person(fields[0], fields[1], fields[2], fields[3], fields[4]);
                    System.out.printf(formatRows, currentPerson.getIDnum(), currentPerson.getFirstName(), currentPerson.getLastName(), currentPerson.getTitle(), currentPerson.getBirthYear());


                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
