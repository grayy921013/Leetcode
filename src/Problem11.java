/**
 * Created by admin on 2/24/16.
 */
public class Problem11 {
    public int maxArea(int[] height) {
        //O(N) algorithm
        int len = height.length, low = 0, high = len - 1;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                //when the left line is smaller than the right one, all box with left = low,  low < right < high
                //will has smaller volume than the box(low,high) because the max possible vol = hight[low] * (right - left)
                //therefore we move the left pointer
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
