import java.util.Scanner;

public class tictactoeNonAI {
    private static int player = 1;
    private static int[][] matrix = new int[3][3];

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        while (true) {
            printBoard();

            System.out.println("Player " + player + ", enter row (0-2) and column (0-2) separated by space:");
            Scanner scanner = new Scanner(System.in);

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Check if the move is valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && matrix[row][col] == 0) {
                // Make the move
                matrix[row][col] = player;

                // Check for a winner
                int winner = checkWinner();

                if (winner != 0) {
                    printBoard();
                    System.out.println("Player " + winner + " wins!");
                    break;
                }

                // Check for a draw
                if (checkFull() && winner == 0) {
                    printBoard();
                    System.out.println("Game Draw!");
                    break;
                }

                        // Switch the player
                        // Switch the player
                        if (player == 1) {
                            player = 2;
                        } else {
                            player = 1;
                        }  
                          
                } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Print the current state of the board
    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {

                char symbol;

                switch (matrix[i][j]) {
                    case 1:
                        symbol = 'X';
                        break;
                    case 2:
                        symbol = 'O';
                        break;
                    default:
                        symbol = ' ';
                }

                System.out.print(symbol + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check if the board is full
    public static boolean checkFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Check for a winner
    public static int checkWinner() {
        // Winning row line
        for (int i = 0; i < 3; i++) {
            if (matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2] && matrix[i][0] != 0) {
                return matrix[i][0];
            }
        }

        // Winning column line
        for (int i = 0; i < 3; i++) {
            if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i] && matrix[0][i] != 0) {
                return matrix[0][i];
            }
        }

        // Winning major diagonal line
        if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2] && matrix[0][0] != 0) {
            return matrix[0][0];
        }

        // Winning minor diagonal line
        if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0] && matrix[0][2] != 0) {
            return matrix[0][2];
        }

        return 0;
    }
}
