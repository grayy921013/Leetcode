/**
 * Created by Zhehui Zhou on 3/8/16.
 */
public class Problem59 {
    public int[][] generateMatrix(int n) {
        //this problem is very similar to Problem54
        int[][] matrix = new int[n][n];
        if (n == 0) return matrix;
        int num = 0;
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        while (true) {
            for (int i = colStart; i <= colEnd; i++) matrix[rowStart][i] = ++num;
            rowStart++;
            if (rowStart > rowEnd) break;
            for (int i = rowStart; i <= rowEnd; i++) matrix[i][colEnd] = ++num;
            colEnd--;
            if (colStart > colEnd) break;
            for (int i = colEnd; i >= colStart; i--) matrix[rowEnd][i] = ++num;
            rowEnd--;
            if (rowStart > rowEnd) break;
            for (int i = rowEnd; i >= rowStart; i--) matrix[i][colStart] = ++num;
            colStart++;
            if (colStart > colEnd) break;
        }
        return matrix;
    }
}
