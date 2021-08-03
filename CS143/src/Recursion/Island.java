package Recursion;

import java.util.Arrays;

/**
 *
 * @author robert
 */
public class Island {

    int SIZE = 5;
    int[][] grid = {
        {0, 1, 1, 1, 0},
        {1, 1, 0, 0, 0},
        {1, 0, 0, 0, 1},
        {0, 0, 1, 0, 0},
        {1, 0, 1, 1, 0}
    };

    public static void main(String[] args) {

        Island app = new Island();
        System.out.println(app);
        System.out.println("num of island: " + app.numOfIsland());
    }

    public int numOfIsland() {
        int count = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    solve(row, col);
                    count++;
                }

            }
        }

        return count;
    }

    public void solve(int row, int col) {
        // right
        if (col + 1 < grid[row].length && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 0;
            solve(row, col + 1);

        }

        // down
        if (row + 1 < grid.length && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 0;
            solve(row + 1, col);

        }
        
        // left
        if (col - 1 >= 0  && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 0;
            solve(row, col - 1);

        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                sb.append(grid[row][col] + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
