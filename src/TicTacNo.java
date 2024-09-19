import java.util.*;
import java.io.*;

public class TicTacNo {
    public static void main(String[] args) throws IOException {
        File yay = new File("TicTacNo.txt");
        char[][] board = getArray("TicTacNo.txt");
        Scanner kb = new Scanner(System.in);
        int row, col;
        int turnCount = countTurns(board);
        boolean GG = false;
        boolean isGameSaved = false;

        do {
            printBoard(board);

            if (turnCount % 2 == 0) {
                while (true) {
                    System.out.println("Enter 3 for column to save the game\nX enter the column for your move (0-2):");
                    col = kb.nextInt();

                    if (col == 3) {
                        saveGame("TicTacNo.txt", board);
                        System.out.println("\nGame has been saved.");
                        GG = true;
                        isGameSaved = true;
                        break;
                    }

                    System.out.println("X enter the row for your move (0-2):");
                    row = kb.nextInt();

                    if (isValid(board, row, col)) {
                        board[row][col] = 'X';
                        turnCount++;
                        break;
                    } else {
                        System.out.println("\nInvalid move, try again.");
                    }
                }

                if (isGameSaved) break;
            } else {
                while (true) {
                    col = (int)(Math.random() * 3);
                    row = (int)(Math.random() * 3);

                    if (isValid(board, row, col)) {
                        board[row][col] = 'O';
                        turnCount++;
                        break;
                    }
                }
            }

            saveGame("TicTacNo.txt", board);
            if (isWinner(board, 'X')) {
                System.out.println("\nX WINS!");
                GG = true;
                yay.delete();
            } else if (isWinner(board, 'O')) {
                System.out.println("\nO WINS.");
                GG = true;
                yay.delete();
            } else if (isCat(board)) {
                System.out.println("\nCat's game.");
                GG = true;
                yay.delete();
            }
        } while (!GG);

        printBoard(board);
    }
    public static void printBoard(char[][] board) {
        System.out.printf("\n %c | %c | %c \n-----------\n %c | %c | %c \n-----------\n %c | %c | %c \n\n", 
            board[0][0], board[0][1], board[0][2], 
            board[1][0], board[1][1], board[1][2], 
            board[2][0], board[2][1], board[2][2]);
    }
    public static void saveGame(String fileName, char[][] board) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    writer.print(board[i][j] == ' ' ? '-' : board[i][j]);
                }
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error saving the game: " + e.getMessage());
        }
    }
    public static char[][] getArray(String fileName) throws IOException {
        File file = new File(fileName);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        // Return an empty board if the file doesn't exist or is empty
        if (!file.exists() || file.length() != 9) {  // Ensure the file is exactly 9 characters long
            System.out.println("Invalid save file format, starting a new game.");
            return board;
        }

        try (Scanner kb = new Scanner(file)) {
            String savedBoard = kb.hasNext() ? kb.next() : "";
            if (savedBoard.length() == 9) {
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[0].length; j++) {
                        char ch = savedBoard.charAt(i * 3 + j);
                        board[i][j] = ch == '-' ? ' ' : ch;
                    }
                }
            } else {
                System.out.println("Error: Invalid save file format, starting a new game.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found, starting a new game.");
        } catch (IOException e) {
            System.out.println("Error reading the save file: " + e.getMessage());
        }

        return board;
    }
    public static boolean isWinner(char[][] board, char x) {
        return (board[0][0] == x && board[0][1] == x && board[0][2] == x) ||
               (board[1][0] == x && board[1][1] == x && board[1][2] == x) ||
               (board[2][0] == x && board[2][1] == x && board[2][2] == x) ||
               (board[0][0] == x && board[1][0] == x && board[2][0] == x) ||
               (board[0][1] == x && board[1][1] == x && board[2][1] == x) ||
               (board[0][2] == x && board[1][2] == x && board[2][2] == x) ||
               (board[0][0] == x && board[1][1] == x && board[2][2] == x) ||
               (board[0][2] == x && board[1][1] == x && board[2][0] == x);
    }
    public static boolean isCat(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == ' ') {
                    return false;
                }
            }
        }
        return !isWinner(board, 'X') && !isWinner(board, 'O');
    }
    public static boolean isValid(char[][] board, int row, int col) {
        return !(row > 2 || row < 0 || col > 2 || col < 0) && board[row][col] == ' ';
    }
    public static int countTurns(char[][] board) {
        int turnCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != ' ') {
                    turnCount++;
                }
            }
        }
        return turnCount;
    }
}
//yay