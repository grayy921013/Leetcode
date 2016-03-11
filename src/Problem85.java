import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/11/16.
 */
public class Problem85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] height = new int[col];
        int max = 0;
        for(int i = 0; i < row; i++) {
            //process row by row
            //for each row, turn it into a largest rectangle area problem
            Stack<Integer> stack = new Stack<>();
            for(int j = 0; j <= col; j++) {
                int h = 0;
                if (j < col) {
                    if (matrix[i][j] == '1') height[j]++;
                    else height[j] = 0;
                    h = height[j];
                }
                while (!stack.isEmpty() && height[stack.peek()] > h) {
                    int p = stack.pop();
                    max = Math.max(max, height[p] * (stack.isEmpty() ? j : (j - 1 - stack.peek())));
                }
                stack.push(j);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Problem85().maximalRectangle(new char[][]{{'1'}}));
    }
}
