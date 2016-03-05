/**
 * Created by admin on 3/5/16.
 */
public class Problem42 {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int leftHeight = 0;
        int rightHeight = 0;
        int vol = 0;
        while (start < end) {
            if (leftHeight <= rightHeight) {
                if (height[start] <= leftHeight) {
                    vol += (leftHeight - height[start]);
                    start++;
                } else leftHeight = height[start];
            } else {
                if (height[end] <= rightHeight) {
                    vol += (rightHeight - height[end]);
                    end--;
                } else rightHeight = height[end];
            }
        }
        return vol;
    }

    public static void main(String[] args) {
        System.out.println(new Problem42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
