import java.util.*;
import java.io.*;

public class TicTacNo
{
    public static void main(String[] args)
    {
        do
        {

        }while(isWinner() || isCat());
    }
    public static boolean isWinner(String fileName, char x)
    {
        char[][] board = new char[3][3];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        for (int i = 0; i < board.length; i++) {
            String[] line = br.readLine().trim().split(" ");
            for (int e = 0; e < board[0].length; e++)
                board[i][e] = line[e].charAt(e);
        }
        if((board[0][0] == x && board[0][1] == x && board[0][2] == x)|| (board[1][0] == x && board[1][1] == x && board[1][2] == x)|| (board[2][0] == x && board[2][1] == x && board[2][2] == x)|| (board[0][0] == x && board[1][0] == x && board[2][0] == x)|| (board[0][1] == x && board[1][1] == x && board[2][1] == x)|| (board[0][2] == x && board[1][2] == x && board[2][2] == x)|| (board[0][0] == x && board[1][1] == x && board[2][2] == x)|| (board[0][2] == x && board[1][1] == x && board[2][0] == x))
            return true;
        return false;
    }
    public static boolean isCat(String fileName)
    {
        char[][] board = new char[3][3];
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        for (int i = 0; i < board.length; i++) {
            String[] line = br.readLine().trim().split(" ");
            for (int e = 0; e < board[0].length; e++)
                board[i][e] = line[e].charAt(e);
        }
        for(int r = 0; r < board.length; r++)
        {
            for(int c = 0; c < board[0].length; c++)
            {
                if(board [r][c] == 'y')
                {
                    return false;
                }
            }
        }
        if(isWinner(board, 'X') == false && isWinner(board, 'O') == false)
        {
            return true;
        }
        return false;
    }
}
