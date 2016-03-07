import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/7/16.
 */
public class Problem52 {
    public int totalNQueens(int n) {
        //use three 1D array to represent col and two diagonals, instead of store the whole board
        boolean[] col = new boolean[n];
        boolean[] diag = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        return solveRow(col, diag, diag2, 0);
    }

    private int solveRow(boolean[] col, boolean[] diag, boolean[] diag2, int row) {
        int n = col.length;
        if (row == col.length) {
            //this is a solution
            return 1;
        }
        int result = 0;
        for (int i = 0; i < col.length; i++) {
            if (!col[i] && !diag[i - row + n - 1] && !diag2[i + row]) {
                col[i] = true;
                diag[i - row + n - 1] = true;
                diag2[i + row] = true;
                result += solveRow(col, diag, diag2, row + 1);
                col[i] = false;
                diag[i - row + n - 1] = false;
                diag2[i + row] = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem52().totalNQueens(4));
    }
}
