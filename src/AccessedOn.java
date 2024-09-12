import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class AccessedOn {
        public static void main(String[] args) throws IOException {
            File yay = new File("AccessedOn.txt");
            if (!yay.exists())
                yay.createNewFile();
            FileWriter bruh = new FileWriter(yay, true);
            PrintWriter yes = new PrintWriter(bruh);
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd HH:mm:ss yyyy");
            String formattedDate = myDateObj.format(myFormatObj);
            yes.println(formattedDate.substring(0, formattedDate.length()-4) + "CDT " + formattedDate.substring(formattedDate.length()-4));
            bruh.close();
            yes.close();
        }
}
