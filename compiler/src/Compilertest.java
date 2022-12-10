import java.util.*;
import java.io.*;

public class Compilertest {

    public String convertFile(File file) throws Exception {
        // Declaring a string to store contents of the file and later return to the
        // caller method.
        String content = "";

        // The object is created to scan the file.
        Scanner fileScanner = new Scanner(file);

        // Reading the file until fileScanner can scan something from the file.
        while (fileScanner.hasNext()) {
            // Appending the next line from the file into the string (content) .
            content = content + " " + fileScanner.nextLine();
        }
        // Closing the scanner object
        fileScanner.close();
        // returning the string
        return content;
    }
}