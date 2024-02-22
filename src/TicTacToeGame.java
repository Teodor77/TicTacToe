import java.util.ArrayList;

public class TicTacToeGame {
    public ArrayList<ArrayList<Character>> board;
    public char currentPlayer;

    public TicTacToeGame() {
        board = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                row.add(' ');
            }
            board.add(row);
        }
        currentPlayer = 'X';
    }

    private void initializeBoard() {
        for (ArrayList<Character> row : board) {
            for (int j = 0; j < 3; j++) {
                row.add(' ');
            }
        }
    }

    public void displayBoard() {
        System.out.println("-------------");
        for (ArrayList<Character> row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean takeTurn(int row, int col) {
        if (board.get(row).get(col) == ' ') {
            board.get(row).set(col, currentPlayer);
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        } else {
            System.out.println("Invalid move! That cell is already occupied.");
            return false;
        }
    }

    // Method to check for a win
    public boolean checkWin() {
        // Check rows for a win
        for (ArrayList<Character> row : board) {
            if (row.get(0) != ' ' && row.get(0) == row.get(1) && row.get(1) == row.get(2)) {
                return true;
            }
        }

        // Check columns for a win
        for (int i = 0; i < 3; i++) {
            if (board.get(0).get(i) != ' ' && board.get(0).get(i) == board.get(1).get(i) &&
                    board.get(1).get(i) == board.get(2).get(i)) {
                return true;
            }
        }

        // Check diagonals for a win
        if (board.get(0).get(0) != ' ' && board.get(0).get(0) == board.get(1).get(1) &&
                board.get(1).get(1) == board.get(2).get(2)) {
            return true; // Diagonal win (top-left to bottom-right)
        }
        if (board.get(0).get(2) != ' ' && board.get(0).get(2) == board.get(1).get(1) &&
                board.get(1).get(1) == board.get(2).get(0)) {
            return true; // Diagonal win (top-right to bottom-left)
        }

        return false;
    }


    // Method to check if the board is full
    public boolean isBoardFull() {
        for (ArrayList<Character> row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }
}