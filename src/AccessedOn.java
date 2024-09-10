import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
public class AccessedOn
{
    public class Main {
        public static void main(String[] args) {
            FileWriter =
            LocalDateTime myDateObj = LocalDateTime.now();
            System.out.println("Before Formatting: " + myDateObj);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            System.out.println("After Formatting: " + formattedDate);
        }
    }
}
