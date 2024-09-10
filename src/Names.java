import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Names
{
    public static int vowelNames(String fileName) {
        int sum = 0;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.toLowerCase().charAt(0) == 'a' || line.toLowerCase().charAt(0) == 'e' || line.toLowerCase().charAt(0) == 'i' || line.toLowerCase().charAt(0) == 'o' || line.toLowerCase().charAt(0) == 'u')
                sum++;
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            return sum;
        }
        return sum;
    }
}
