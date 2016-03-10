import java.util.HashSet;

/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem79 {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0) return false;
        int col = board[0].length;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if (search(i, j, board, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean search(int startX, int startY, char[][] board, String word, int index) {
        if (index == word.length()) return true;
        if (startX < 0 || startX >= board.length || startY < 0 || startY >= board[0].length) return false;
        if (board[startX][startY] != word.charAt(index)) return false;
        board[startX][startY] = 0;
        boolean flag = search(startX - 1 , startY, board, word, index + 1) || search(startX + 1, startY, board, word, index + 1) ||
                search(startX, startY - 1, board, word, index + 1) || search(startX, startY + 1, board, word, index + 1);
        board[startX][startY] = word.charAt(index);
        return flag;
    }
}
