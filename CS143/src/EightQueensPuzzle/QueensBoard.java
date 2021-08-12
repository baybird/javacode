package EightQueensPuzzle;

/**
 * Brute force solution or a exhaustive search or a recursive backtracking
 * solution
 *
 * @author robert
 */
public class QueensBoard {

    public static final char EMPTY = ' ';
    protected char[][] board;
    private int placed = 0;

    public QueensBoard(int size) {
        if (size == 2 || size == 3) {
            String msg = "Queens cannot be played with a board of size 2 or 3.";
            System.out.println(msg);
            throw new IllegalArgumentException(msg);
        }

        board = new char[size][size];
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = EMPTY;
            }
        }
        placed = 0;
    }
    
    public static void main(String[] args) {
        final int SIZE = 8;
        QueensBoard qb = new QueensBoard(SIZE);
//        QueensGUI qb = new QueensGUI(SIZE);
        qb.solve();
        System.out.println(qb);
    }

    // Places a Queen and adds one to placed count
    public void place(int row, int column) {
        board[row][column] = 'Q';
        placed++;
//        printBoard("place");
    }

    // Removes the Queen and subtracts one from placed count
    public void remove(int row, int column) {
        board[row][column] = EMPTY;
        placed--;
//        printBoard("remove");
    }
    
    private void printBoard(String note){
        System.out.println("******* "+note+" *******");
        System.out.println(this);
    }

    public boolean solve() {
        if (allPlaced()) {
            return true;
        }

        for (int c = 0; c < board.length; c++) {
            for (int r = 0; r < board.length; r++) {
                if (isSafe(r, c)) {
                    place(r, c);

                    if (solve()) {
                        return true;
                    }

                    remove(r, c);
                }
            }
        }

        return false;
    }

    private boolean allPlaced() {
        return placed == board.length;
    }

    // checks if board[row][column] is a valid placement for a Queen
    public boolean isSafe(int row, int column) {
        // if this spot isn't empty --> not safe
        if (board[row][column] != EMPTY) {
            return false;
        }

        // if there is another Queen on the row -> not safe
        for (int r = 0; r < board.length; r++) {
            if (r != row && board[r][column] == 'Q') {
                return false;
            }
        }

        // it there is another Queen on the column -> not safe
        for (int c = 0; c < board[row].length; c++) {
            if (c != column && board[row][c] == 'Q') {
                return false;
            }
        }
        // if there is another queen diagonally -> not safe
        return checkDiagonals(row, column);
    }

    private boolean checkDiagonals(int row, int col) {
        // check lower-left diagonal
        for (int i = row, j = col; (i >= 0 && j >= 0); i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check lower-right diagonal
        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check upper-left diagonal
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // check upper-right diagonal
        for (int i = row, j = col; i < board.length && j < board.length; i++, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        StringBuilder layout = new StringBuilder();
        for (char[] row : board) {
            for (char cell : row) {
                if(cell == EMPTY){
                    layout.append("-");
                }
                else{
                    layout.append(cell);
                }                
                layout.append(" ");
            }
            layout.append("\n");
        }
        
        return layout.toString();
    }
}
