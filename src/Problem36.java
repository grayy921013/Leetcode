/**
 * Created by admin on 3/3/16.
 */
public class Problem36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] row = new boolean[board.length];
            boolean[] col = new boolean[board.length];
            boolean[] cube = new boolean[board.length];
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1']) return false;
                    else row[board[i][j] - '1'] = true;
                }
                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1']) return false;
                    else col[board[j][i] - '1'] = true;
                }
                int rIndex = j / 3 + i / 3 * 3;
                int cIndex = j % 3 + i % 3 * 3;
                if (board[rIndex][cIndex] != '.') {
                    if (cube[board[rIndex][cIndex] - '1']) return false;
                    else cube[board[rIndex][cIndex] - '1'] = true;
                }
            }
        }
        return true;
    }
}
