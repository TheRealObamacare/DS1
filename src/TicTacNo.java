import java.util.*;
import java.io.*;

public class TicTacNo
{
    public static void main(String[] args) throws IOException {
        File yay = new File("TicTacNo.txt");
        FileWriter b = new FileWriter(yay);
        Scanner kb = new Scanner(yay);
        PrintWriter bruh = new PrintWriter(yay);
        char[][] board = getArray("TicTacNo.txt");
        int row = 0;
        int col = 0;
        int turnCount = 0;
        boolean GG = false;
        do
        {
            if(turnCount == 0)
                System.out.printf(" %c | %c | %c \n-----------\n %c | %c | %c \n-----------\n %c | %c | %c \n\n",board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
            else
                System.out.printf("\n %c | %c | %c \n-----------\n %c | %c | %c \n-----------\n %c | %c | %c \n\n",board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]);
            if(turnCount%2 == 0)
            {
                do
                {
                    System.out.println("Entering 3 for row or column will save the game\nX enter the column for your move (0-2):");
                    col = kb.nextInt();
                    if(col == 3)
                    {
                        writeFile("TicTacNo.txt", board);
                        System.out.println("\nGame has been saved.");
                    }
                    System.out.println("X enter the row for your move(0-2):");
                    row = kb.nextInt();
                    if(isValid(board, row, col) == false)
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
            writeFile("TicTacNo.txt", board);
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
            System.out.println("\nYou tied.");
        bruh.close();
    }
    public static void writeFile(String fileName, char[][] board) throws FileNotFoundException {
        PrintWriter yay = new PrintWriter(fileName);
        yay.print(board[0][0] + board[0][1] + board[0][2] + board[1][0] + board[1][1] + board[1][2] + board[2][0] + board[2][1] + board[2][2]);
    }
    public static char[][] getArray(String fileName) throws IOException {
        File no = new File(fileName);
        Scanner kb = new Scanner(no);
        String yay = kb.next();
        if(!no.exists())
            return new char[3][3];
        char[][] bruh = new char[3][3];
        for(int i = 0; i < bruh.length; i++)
        {
            for(int e = 0; e< bruh[0].length; e++)
            {
                bruh[i][e] = yay.charAt(i*3+e);
            }
        }
        kb.close();
        return bruh;
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