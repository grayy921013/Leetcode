import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 3/30/16.
 */
public class Problem164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        //use bucket sort
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            //get min and max value of the array
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //divide max - min to length - 1 buckets, because maxGap must > (max - min) / (length - 1)
        int gap = (int)Math.ceil((double)(max - min) / (nums.length - 1));
        int[] bucketMin = new int[nums.length - 1]; //store the min value of a bucket
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        int[] bucketMax = new int[nums.length - 1]; //store the max value of a bucket
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == min || nums[i] == max) continue;
            int index = (nums[i] - min) / gap;
            bucketMin[index] = Math.min(bucketMin[index], nums[i]);
            bucketMax[index] = Math.max(bucketMax[index], nums[i]);

        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i = 0; i < nums.length - 1; i++) {
            if(bucketMin[i] == Integer.MAX_VALUE) continue; //empty bucket
            maxGap = Math.max(maxGap, bucketMin[i] - previous);
            previous = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }

    public static void main(String[] args) {
        System.out.println(new Problem164().maximumGap(new int[]{3,6,1,9}));
    }
}
