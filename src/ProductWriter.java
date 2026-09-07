import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;


public class ProductWriter
{
    public static void main(String[] args)
    {
        ArrayList<Product> product = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        boolean userDone = false;

        Product productRecord;
        String ID = "";
        String fullName = "";
        String description = "";
        double cost = 0;

        do{
            ID = SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            fullName = SafeInput.getNonZeroLenString(in, "Enter the full name");
            description = SafeInput.getNonZeroLenString(in, "Enter the product description");
            cost = SafeInput.getRangedDouble(in, "Enter the product cost", 0.0, 1000000.0);

            productRecord = new Product(ID, fullName, description, cost);

            product.add(productRecord);


            userDone = SafeInput.getYNConfirm(in, "Are you done entering people? ");

        }while(!userDone);

        for(Product pd: product)
        {
            System.out.println(pd);
        }

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(Product pd: product){
                writer.write(pd.toCSV(), 0, pd.toCSV().length());
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