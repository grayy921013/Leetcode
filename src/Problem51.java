import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/7/16.
 */
public class Problem51 {
    public List<List<String>> solveNQueens(int n) {
        //use dfs and place queue row by row
        char[][] board = new char[n][n];
        for(char[] array : board) {
            for(int i = 0; i < array.length; i++) array[i] = '.';
        }
        List<List<String>> result = new ArrayList<>();
        solveRow(board, result, 0);
        return result;
    }

    private void solveRow(char[][] board, List<List<String>> result, int row) {
        if (row == board.length) {
            //this is a solution
            List<String> list = new ArrayList<>();
            for(char[] array : board) {
                list.add(new String(array));
            }
            result.add(list);
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, row, i)) {
                board[row][i] = 'Q';
                solveRow(board, result, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int row, int col) {
        //no need to check row; check col and diagonal; only need to check positions above [row,col]
        for (int i = 0; i < row; i++) {
            if (col - row + i >= 0 && board[i][col - row + i] == 'Q') return false;
            if (col + row - i < board.length && board[i][col + row - i] == 'Q') return false;
            if (board[i][col] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem51().solveNQueens(2));
    }
}
