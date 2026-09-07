import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        String formatHeader = "%-8s %-20s %-25s %-10s%n";
        String formatRows = "%-8s %-20s %-25s %-10s%n";
        Product currentProduct;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                System.out.printf(formatHeader, "ID", "Full Name", "Description", "Cost");
                System.out.println("-------------------------------------------------------------------");

                while(reader.ready()) {
                    rec = reader.readLine();
                    String [] fields = rec.split(", ");
                    currentProduct = new Product(fields[0], fields[1], fields[2], Double.parseDouble(fields[3]));
                    System.out.printf(formatRows, currentProduct.getID(), currentProduct.getFullName(), currentProduct.getDescription(), currentProduct.getCost());
                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
