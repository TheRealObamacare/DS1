import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Grid
{
    public static int[] rowSums(String fileName) {
        ArrayList<Integer> sums = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] numbers = scanner.nextLine().split(" ");
                int sum = 0;
                for (String nums : numbers) {
                    sum += Integer.parseInt(nums.trim());
                }
                sums.add(sum);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
            return new int[0];
        }
        int[] result = new int[sums.size()];
        for (int i = 0; i < sums.size(); i++) {
            result[i] = sums.get(i);
        }
        return result;
    }
    public static int[] columnSums(String fileName){
        int[][] yay;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String[] dimensions = br.readLine().trim().split("X");
            yay = new int[Integer.parseInt(dimensions[1])][Integer.parseInt(dimensions[0])];
            for (int i = 0; i < yay.length; i++) {
                String[] line = br.readLine().trim().split(" ");
                for (int e = 0; e < yay[0].length; e++)
                    yay[i][e] = Integer.parseInt(line[e]);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new int[0];
        }
        int[] columnSums = new int[yay[0].length];
        for (int c = 0; c < yay[0].length; c++)
            for (int r = 0; r < yay.length; r++)
                columnSums[c] += yay[r][c];
        return columnSums;
    }
}