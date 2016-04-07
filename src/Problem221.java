/**
 * Created by Zhehui Zhou on 4/7/16.
 */
public class Problem221 {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == 0 || j == 0 || matrix[i][j] == '0') {
                    max = Math.max(max, matrix[i][j] - '0');
                    continue;
                }
                int val = (1 + Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j] , matrix[i - 1][j - 1]))) - '0';
                max = Math.max(max, val);
                matrix[i][j] = (char)(val + '0');
            }
        }
        return max * max;
    }
}
