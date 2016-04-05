import java.util.Random;

/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        //quick select
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) return nums[start];
        int pivot = nums[new Random().nextInt(end - start + 1) + start]; //random pivot
        int i = start, lt = start, rt = end;
        while(i <= rt) {
            //quick sort in reverse order
            if(nums[i] > pivot) {
                swap(nums, i++, lt++);
            } else if (nums[i] < pivot) {
                swap(nums, i, rt--);
            } else {
                i++;
            }
        }
        if (k <= lt - start) {
            return quickSelect(nums, start, lt - 1, k);
        } else if (k > lt - start && k <= i - start) return pivot;
        else {
            return quickSelect(nums, rt + 1, end, k - i + start);
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) return;
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Problem215().findKthLargest(new int[]{7,6,5,4,3,2,1},5));
    }
}
