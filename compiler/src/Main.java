import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner myFile = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = myFile.nextLine();
        myFile.close();

        Compiler compiler = new Compiler(filename);
    }
}