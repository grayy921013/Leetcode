import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/11/16.
 */
public class Problem84 {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                //if larger then push it in
                s.push(i);
            } else {
                //if smaller, pop a element and calculate corresponding area with respect to this rect
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Problem84().largestRectangleArea(new int[]{3, 4, 5, 1}));
    }
}
