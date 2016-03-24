import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Zhehui Zhou on 3/23/16.
 */
public class Problem130 {
    public void solve(char[][] board) {
        //start from 0 on the edge to mark 0 that should not be flipped
        Queue<Integer> queue = new ArrayDeque<>();
        int rowNum = board.length;
        if (rowNum == 0) return;
        int colNum = board[0].length;
        int a = 0, b = (rowNum - 1) * colNum, c = colNum, d = 2 * colNum - 1;
        for(int i = 0; i < colNum; i++) {
            queue.add(a++);
            queue.add(b++);
        }
        for(int i = 1; i < rowNum - 1; i++) {
            queue.add(c);
            queue.add(d);
            c += colNum;
            d += colNum;
        }
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int row = num / colNum;
            int col = num % colNum;
            if (board[row][col] != 'O') continue;
            board[row][col] = '.'; //mark it
            if (row > 0 && board[row - 1][col] == 'O') queue.add((row - 1) * colNum + col);
            if (row < rowNum - 1 && board[row + 1][col] == 'O') queue.add((row + 1) * colNum + col);
            if (col > 0 && board[row][col - 1] == 'O') queue.add(row * colNum + col - 1);
            if (col < colNum - 1 && board[row][col + 1] == 'O') queue.add(row * colNum + col + 1);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
}
