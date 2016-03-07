import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/7/16.
 */
public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;
        while (true) {
            for (int i = colStart; i <= colEnd; i++) list.add(matrix[rowStart][i]);
            rowStart++;
            if (rowStart > rowEnd) break;
            for (int i = rowStart; i <= rowEnd; i++) list.add(matrix[i][colEnd]);
            colEnd--;
            if (colStart > colEnd) break;
            for (int i = colEnd; i >= colStart; i--) list.add(matrix[rowEnd][i]);
            rowEnd--;
            if (rowStart > rowEnd) break;
            for (int i = rowEnd; i >= rowStart; i--) list.add(matrix[i][colStart]);
            colStart++;
            if (colStart > colEnd) break;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Problem54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
