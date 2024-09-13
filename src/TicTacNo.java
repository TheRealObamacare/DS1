import java.util.*;
import java.io.*;

public class TicTacNo
{
    public static void main(String[] args)
    {
        File yay = new File("TicTacNo.txt");
        Scanner kb = new Scanner(yay);
        PrintWriter bruh = new PrintWriter(File);
        char[][] board = getArray(yay);
        int row = 0;
        int col = 0;
        int turnCount = 0;
        boolean GG = false;
        boolean save = false;
        do
        {
            if(turnCount == 0)
            {
                System.out.printf(" %c | %c | %c \n-----------\n %c | %c | %c \n-----------\n %c | %c | %c \n\n",board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
            }
            else
            {
                System.out.printf("\n %c | %c | %c \n-----------\n %c | %c | %c \n-----------\n %c | %c | %c \n\n",board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
            }
            if(turnCount%2 == 0)
            {
                do
                {
                    System.out.println("Entering 3 for row or column will save the game\nX enter the column for your move (0-2):");
                    col = kb.nextInt();
                    System.out.println("X enter the row for your move(0-2):");
                    row = kb.nextInt();
                    if(isValid(board, row, col) == false || )
                    {
                        System.out.println("\nInvalid move, enter a new move.\n");
                    }
                    else
                        turnCount++;
                }while(isValid(board, row, col) == false);
                board[row][col] = 'X';
            }
            else
            {
                do
                {
                    col = (int)(Math.random()*2);
                    row = (int)(Math.random()*2);
                    if(isValid(board, row, col) == false);
                    else
                        turnCount++;
                }while(isValid(board, row, col) == false);
                board[row][col] = 'O';
            }
            if(isWinner(board, 'X') == true)
                GG = true;
            else if(isCat(board) == true)
                GG = true;
            else if(isWinner(board, 'O') == true)
                GG = true;
            else
                GG = false;
        }while(GG == false);
        System.out.printf("\n %c | %c | %c \n-----------\n %c | %c | %c \n-----------\n %c | %c | %c \n",board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
        if(isWinner(board, 'X') == true)
            System.out.println("\nX WINS!");
        else if(isCat(board) == false)
            System.out.println("\nO WINS!");
        else if(isCat(board) == true)
            System.out.println("\nCats game.");
        else
    }
    public static void writeFile(String fileName, char[][] board)
    {
        String[] f = new String[board.length];
        PrintWriter yay = new PrintWriter(fileName);
        for(int i = 0; i < board.length; i++)
        {
            f = board[i][0] +
        }
    }
    public static char[][] getArray(File yay)
    {

    }
    public static boolean isWinner(char[][] board, char x)
    {
        if((board[0][0] == x && board[0][1] == x && board[0][2] == x)|| (board[1][0] == x && board[1][1] == x && board[1][2] == x)|| (board[2][0] == x && board[2][1] == x && board[2][2] == x)|| (board[0][0] == x && board[1][0] == x && board[2][0] == x)|| (board[0][1] == x && board[1][1] == x && board[2][1] == x)|| (board[0][2] == x && board[1][2] == x && board[2][2] == x)|| (board[0][0] == x && board[1][1] == x && board[2][2] == x)|| (board[0][2] == x && board[1][1] == x && board[2][0] == x))
            return true;
        return false;
    }
    public static boolean isCat(char[][] board)
    {
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
    public static boolean isValid(char[][] board,int row, int col)
    {
        if((row > 2 || row < 0)||(col > 2 || col < 0))
            return false;
        if(board[row][col] == ' ')
            return true;
        return false;
    }
}