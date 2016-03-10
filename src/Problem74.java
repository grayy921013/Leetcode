/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //regard matrix as an array
        if (matrix.length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == matrix[mid / col][mid % col]) return true;
            else if (target < matrix[mid / col][mid % col]) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
