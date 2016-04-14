/**
 * Created by Zhehui Zhou on 4/14/16.
 */
public class Problem289 {
    public void gameOfLife(int[][] board) {
        if (board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                calculate(board, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                else if (board[i][j] == -1) board[i][j] = 1;
            }
        }
    }

    private void calculate(int[][] board, int row, int col) {
        int liveCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) continue;
                if (row + i < 0 || row + i >= board.length || col + j < 0 || col + j >= board[0].length) continue;
                if (board[row + i][col + j] >= 1) liveCount++;
            }
        }
        if (board[row][col] == 1 && (liveCount < 2 || liveCount > 3)) board[row][col] = 2;
        if (board[row][col] == 0 && liveCount == 3) board[row][col] = -1;
    }
}
