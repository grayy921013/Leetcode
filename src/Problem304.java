/**
 * Created by Zhehui Zhou on 4/17/16.
 */
public class Problem304 {
    int[][] matrix;

    public Problem304(int[][] matrix) {
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                if (i == 0) matrix[i][j] = sum;
                else matrix[i][j] = matrix[i - 1][j] + sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2][col2] - (row1 > 0 ? matrix[row1 - 1][col2] : 0) - (col1 > 0 ? matrix[row2][col1 - 1] : 0) +
                ((row1 > 0 && col1 > 0) ? matrix[row1 - 1][col1 - 1] : 0);
    }
}
