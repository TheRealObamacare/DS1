import java.io.BufferedReader;
import java.io.FileReader;

public class Area
{
    public static int largestAreaSum(String fileName)
    {
        int[][] yay;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String[] dimensions = br.readLine().split(" ");
            yay = new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
            for(int i = 0; i < yay.length; i++)
            {
                String[] line = br.readLine().split(" ");
                for(int e = 0; e < yay[0].length; e++)
                    yay[i][e] = Integer.parseInt(line[i]);
            }
        }
        catch (Exception e)
        {
            return 0;
        }
        int ans = 0;
        for(int r = 0; r < yay.length; r++)
        {
            for(int c = 0; c < yay[0].length; c++)
            {
                int num = yay[r][c];
                if(r > 0) num += yay[r-1][c];
                if(r < yay.length - 1) num += yay[r+1][c];
                if(c > 0) num += yay[r][c-1];
                if(c < yay[0].length - 1) num += yay[r][c+1];
                if(ans > num) {
                    ans = num;
                }
            }
        }
        return ans;
    }
}
