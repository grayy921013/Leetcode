import java.util.Arrays;

/**
 * Created by admin on 3/2/16.
 */
public class Problem31 {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nextPermutation(nums, i)) return;
        }
        // the whole list is in descending order, then sort it
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    private boolean nextPermutation(int[] nums, int anchor) {
        // for int[anchor] find a number > int[anchor] in the positions > anchor, return -1 if cannot find one
        // only do this when nextpermutation(nums, anchor + 1) == false
        // therefore list after anchor is in descending order
        if (anchor == nums.length - 1) return false;
        int pos = binarysearch(nums, anchor + 1, nums.length - 1, nums[anchor]);
        if (pos == -1) return false;
        else {
            int temp = nums[pos];
            nums[pos] = nums[anchor];
            nums[anchor] = temp;
            //then sort the list
            for (int i = anchor + 1; i < (anchor + 1 + nums.length) / 2; i++) {
                temp = nums[i];
                nums[i] = nums[nums.length + anchor - i];
                nums[nums.length + anchor - i] = temp;
            }
        }
        return true;
    }

    private int binarysearch(int[] nums, int start, int end, int value) {
        //find the smallest entry in nums > value
        if (nums[start] <= value) return -1;
        if (start == end) return start;
        int mid = (start + end) / 2;
        if (nums[mid] > value && nums[mid + 1] <= value) return mid;
        else if (nums[mid + 1] > value) return binarysearch(nums, mid + 1, end, value);
        else return binarysearch(nums, start, mid, value);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2};
        new Problem31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
