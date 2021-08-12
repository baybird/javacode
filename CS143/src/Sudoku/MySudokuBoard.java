//package Sudoku;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * <pre>
 * File         SudokuBoard.java
 * Project      Week 5 - HW #3: Solving a Sudoku Puzzle
 * Course       CS143
 * Description  This application will solve the Sudoku Puzzle.
 *              What does it look like to recursively try and solve a Sudoku 
 *              puzzle? Basically you try to place the values 1-9 in the empty 
 *              spots of a Sudoku puzzle (move forward with a brute force attempt) 
 *              until you either reach an invalid state (which causes you to 
 *              backtrack) or you solve the puzzle or find out it's unsolvable
 *              (which ends the recursion).
 * Platform     Mac, Big Sur 11.2.3, jdk 1.8.0_241, JGRASP
 * Date         7/29/2021
 * History Log
 * @author      <i>Robert Tang</i>
 * @version 1.0.0
 * </pre>
 */
public class MySudokuBoard {
    private final String EMPTY_PLACEHOLDER = ".";
    private final int SIZE = 9;
    private final String[][] board = new String[SIZE][SIZE];
    private Set<String> numberSet;
    private String description;
    
    public MySudokuBoard() {
    }

    public MySudokuBoard(String fileLocation) {
        try {
            numberSet = new HashSet<>();
            for (int i = 1; i <= SIZE; i++) {
                numberSet.add(String.valueOf(i));
            }
            setDescription(fileLocation);
            loadFile(fileLocation);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public void loadFile(String fileLocation) throws Exception {
        try {
            Scanner input = new Scanner(new File(fileLocation));

            int index = 0;
            // Ensure the number of file lines is not more than the SIZE
            while (input.hasNext() && index < SIZE) {
                String[] myStrs = input.next().split("");
                for (int j = 0; j < myStrs.length && j < SIZE; j++) {
                    try {
                        board[index][j] = myStrs[j].trim();
                    } catch (NumberFormatException ex) { // if input is not a number
                        board[index][j] = EMPTY_PLACEHOLDER;
                    }
                }
                index++;
            }
        } catch (FileNotFoundException ex) {
            throw new Exception("No such file or directory. " + fileLocation);
        }
    }

    public void setDescription(String fileLocation) {
        description = fileLocation;
    }

    public String getDescription() {
        return description;
    }
    
    private boolean isEmpty(int x, int y){
        return board[x][y].endsWith(EMPTY_PLACEHOLDER);
    }
    
    public String getEmpty(){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(isEmpty(row, col)){
                    return (String.valueOf(row) + String.valueOf(col));
                }
            }
        }
        return "**";
    }
    
    private void place(int x, int y, int val){
        board[x][y] = String.valueOf(val);
    }
    
    private void remove(int x, int y){
        board[x][y] = EMPTY_PLACEHOLDER;
    }
    
    // post: return true if a num is safe in specified row, column, and miniboard,
    //       false otherwise.
    private boolean isSafe(int row, int col, int num){ 
        // row: {0,1,2} -> 0 -> { 2-2%3 = 2-2 = 0, 1-1%3=1-1=0, 0-0%3=0-0=0}
        // col: {6,7,8} -> 6 -> { 6-6%3 = 6, 7-7%3 = 7-1=6, 8-8%3=8-2=6}
        int beginRow = row - row % 3;
        int beginCol = col - col % 3;
        String input = String.valueOf(num);
        for (int i = 0; i < SIZE; i++) {
            // travel row
            if(board[i][col].equals(input)){
                return false;
            }
            
            // travel column
            if(board[row][i].equals(input)){
                return false;
            }
            
            // travel mini board
            // suppose it begins from (0,6), it should travel from 
            // (0,6),(0,7),(0,8) 
            // (1,6),(1,7),(1,8)
            // (2,6),(2,7),(2,8)
            // as i from 0 to 8
            // x increased as i/3, such that 0/3=0, 1/3=0, 2/3=0, 3/3=1, 4/3=1, 5/3=1, 6/3=2, 7/3=2, 8/3=2 
            // y increased as i%2, such that 0%3=0, 1%3=0, 2%3=0, 3%3=0, 4%3=1, 5%3=2, 6%3=0, 7%3=1, 8%3=2
            int x = beginRow + i / 3;
            int y = beginCol + i % 3;
            if (board[x][y].equals(input)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean solve(){
        if(!isValid()){
            System.out.println("This board is not valid and cannot be solved.");
            return false;
        }
        
        if(isSolved()){
            System.out.println("This board is already solved.");
            return true;
        }
        
        if(explore()){
            return true;
        }
        else{
            System.out.println("This board cannot be solved.");
            return false;
        }
    }
    
    private boolean explore(){
        String word = getEmpty();
        // base case
        if("**".equals(word)){ 
            return true;
        }
        
        // recursive case
        int row = Integer.valueOf(word.substring(0, 1));
        int col = Integer.valueOf(word.substring(1));
        for (int num = 1; num <= 9; num++) {
            if(isSafe(row, col, num)){
                place(row, col, num);
                if(explore()){ 
                    return true;
                }
                remove(row, col);
            }
        }
        return false;    
    }
    
    /**
     *  post: return true if all of the following constraints are followed, false otherwise:
     *        1. there is no data in the board that is not a 1-9 or a space 
     *           (or your representation of a space - could be a '.' or a 0, etc)
     *        2. no row contains any duplicate values of 1-9
     *        3. no column contains any duplicate values of 1-9
     *        4. no mini-square contains any duplicate values of 1-9
     */
    public boolean isValid() {
        return validating(false);
    }
    
    /**
     * post: return true if there are nine occurrences of every number 1-9 in 
     *       the grid AND all the constraints of isValid are followed.
     */
    public boolean isSolved() {
        return validating(true);
    }

    public boolean validating(boolean checkForSolved) {
        Map<Integer, Set<String>> rows = new HashMap<>();
        Map<Integer, Set<String>> cols = new HashMap<>();
        Map<Integer, Set<String>> minBoards = new HashMap<>();
    
        // O(N)
        for (int i = 0; i < SIZE; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            minBoards.put(i, new HashSet<>());
        }

        // O(N^2)
        for (int m = 0; m < SIZE; m++) {
            for (int n = 0; n < SIZE; n++) {
                // if is validating for the isValid() method, then check for invalid data (non 0-9 or placehold)
                if (!checkForSolved && !board[m][n].equals(EMPTY_PLACEHOLDER) && !numberSet.contains(board[m][n])) {
                    return false;
                }

                // check rows
                if (rows.get(m).contains(board[m][n])) { // duplicates
                    return false;
                }               
                if(!board[m][n].equals(EMPTY_PLACEHOLDER)){ // is a number 1-9
                     rows.get(m).add(board[m][n]);
                }
                else if(checkForSolved){// is not a number
                     return false; 
                }

                // check columns
                int colIndex = m;
                int rowIndex = n;
                String value = board[rowIndex][colIndex];
                if (cols.get(colIndex).contains(value)) {
                    return false;
                } else if (checkForSolved || !value.equals(EMPTY_PLACEHOLDER)) {
                    cols.get(colIndex).add(value);
                }

                // check mini-board 
                int currentMinBoard = calculateMiniBoardIndex(m, n);                           
                if (minBoards.get(currentMinBoard).contains(board[n][m])) {
                    return false;
                } else if (checkForSolved || !board[n][m].equals(EMPTY_PLACEHOLDER)) {
                    minBoards.get(currentMinBoard).add(board[n][m]);
                }
            }
        }

        return true;
    }
    
    // compute the current mini-board (3x3)                
    // total 9 mini-boards
    //  0 | 1 | 2  -> (0+0)+0, (1+0)+0, (2+0)+0
    //  3 | 4 | 5  -> (1+0)+2, (1+1)+2, (1+2)+2
    //  6 | 7 | 8  -> (2+0)+4, (2+1)+4, (2+2)+4  
    // as n from 1 to 2, plus 2^n
    public int calculateMiniBoardIndex(int row, int col){
        int x = row / 3;
        int y = col / 3;
        int ratio = 0;
        if (x > 0) {
            ratio = (int) Math.pow(2, x);
        }
        return (int) (x + y + ratio);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i += 1) {
            if (i % 3 == 0) {
                sb.append("---------------------");
                sb.append(System.lineSeparator());
            }

            sb.append(board[i][0]);
            for (int j = 1; j < board[i].length; j++) {
                if (j % 3 == 0) {
                    sb.append(" |");
                }
                sb.append(" " + board[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        sb.append("---------------------");
        return sb.toString();
    }
}

/*
Paste the output from JGrasp here.
Altering output will earn you an automatic zero for the assignment.

Output in another file
*/