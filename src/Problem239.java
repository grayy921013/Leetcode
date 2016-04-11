import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by Zhehui Zhou on 4/11/16.
 */
public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k <= 1) return nums;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() <= i - k) queue.poll();
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) queue.pollLast();
            queue.offer(i);
            if (i - k + 1 >= 0) result[i - k + 1] = nums[queue.peek()];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem239().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
