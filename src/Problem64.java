/**
 * Created by Zhehui Zhou on 3/8/16.
 */
public class Problem64 {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] count = new int[col];
        for (int i = 1; i < col; i++) count[i] = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            //for each row
            for (int j = 0; j < col; j++) {
                count[j] = Math.min(count[j], (j - 1 >= 0 ? count[j - 1] : count[j])) + grid[i][j];
            }
        }
        return count[col - 1];
    }
}
