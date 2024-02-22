import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame();
        Player player1 = new Player('X');
        Player player2 = new Player('O');

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            game.displayBoard();
            Player currentPlayer = (game.currentPlayer == 'X') ? player1 : player2;
            System.out.print("Player " + currentPlayer.getSymbol() + ", enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Player " + currentPlayer.getSymbol() + ", enter column (0-2): ");
            int col = scanner.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input! Row and column must be between 0 and 2.");
                continue;
            }

            if (game.takeTurn(row, col)) {
                if (game.checkWin()) {
                    game.displayBoard();
                    System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.displayBoard();
                    System.out.println("It's a tie! The board is full.");
                    break;
                }
            }
        }
        scanner.close();
        System.out.println("Thanks for playing!");
    }
}