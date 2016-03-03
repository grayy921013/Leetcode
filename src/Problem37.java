import java.util.LinkedList;

/**
 * Created by admin on 3/3/16.
 */
public class Problem37 {
    public void solveSudoku(char[][] board) {
        //dfs, use isvalid method in problem36 to prune
        LinkedList<Integer> empty = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') empty.push(i * 9 + j);
            }
        }
        fillin(board, empty);
    }

    private boolean fillin(char[][] board, LinkedList<Integer> empty) {
        if (!empty.isEmpty()) {
            int number = empty.poll();
            for (char c = '1'; c <= '9'; c++) {
                if (isValidSudoku(board, number / 9, number % 9, c)) {
                    board[number / 9][number % 9] = c;
                    if (fillin(board, empty)) return true;
                }
            }
            empty.addFirst(number);
            board[number / 9][number % 9] = '.';
            return false;
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board, int i, int j, char c) {
        //only need to check the row, col and cube related to (i,j) when put char c
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) return false;
        }
        for (int k = 0; k < 9; k++) {
            if (board[k][j] == c) return false;
        }
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (board[row][col] == c) return false;
            }
        }
        return true;
    }
}
