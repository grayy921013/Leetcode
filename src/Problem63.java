/**
 * Created by Zhehui Zhou on 3/8/16.
 */
public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //use DP, because you can only go right and down
        if (obstacleGrid.length == 0) return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] count = new int[col];
        count[0] = 1;
        for (int i = 0; i < row; i++) {
            //for each row
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) count[j] = 0;
                else count[j] = count[j] + (j - 1 >= 0 ? count[j - 1] : 0);
            }
        }
        return count[col - 1];
    }
}
