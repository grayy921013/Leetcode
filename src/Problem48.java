import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 3/6/16.
 */
public class Problem48 {
    public void rotate(int[][] matrix) {
        //for entry <i,j> if i < n/2 && j >= i && j < (n - 1 - i), select it as a starting point, do the rotation for 4 times;
        //fot the starting point <i,j>, the vector will be <i,j>, <j,-i>, <-i,-j>, <-j, i> corresponding to the four corner
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for(int j = i; j < n  - 1 - i; j++) {
                //rotate four times
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2},{3,4}};
        new Problem48().rotate(matrix);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
