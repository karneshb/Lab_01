import java.util.Scanner;

public class ObjInputTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SafeInputObj input = new SafeInputObj();

        String firstName = input.getNonZeroLenString("Enter your first name");
        int rangedInt = input.getRangedInt("Enter a number between 1 and 100 ", 1, 100);
        int favNum = input.getInt("Enter your favorite number ");
        double rangedDouble = input.getRangedDouble("Enter a number between 1.0 and 100.0 ", 1.0, 100.0);
        double costOfItem = input.getDouble("Enter the cost of an item");
        boolean yesNo = input.getYNConfirm("Do you want to continue?");
        String regExString = input.getRegExString("Enter a string that matches the pattern", "[a-zA-Z]+");

        System.out.println(firstName + " " + rangedInt + " " + favNum + " " + rangedDouble + " " + costOfItem + " " + yesNo + " " + regExString);

    }
}
