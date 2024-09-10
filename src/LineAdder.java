import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class LineAdder {
    public static int[] sumLines(String fileName) {
        ArrayList<Integer> sums = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numbers = line.split(",");
                int sum = 0;
                for (String nums : numbers) {
                    sum += Integer.parseInt(nums.trim());
                }
                sums.add(sum);
            }
            scanner.close();
        } catch (Exception e) {
            return new int[0];
        }
        int[] result = new int[sums.size()];
        for (int i = 0; i < sums.size(); i++) {
            result[i] = sums.get(i);
        }
        return result;
    }
}