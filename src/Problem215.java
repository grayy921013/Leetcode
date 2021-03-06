import java.util.Random;

/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        //quick select
        return nums[quickSelect(nums, 0, nums.length - 1, k - 1)];
    }


    private int partition5(int[] nums, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = nums[i];
            int j = i - 1;
            for (; (j >= start) && (nums[j] > key); j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = key;
        }
        return (start + end) >>> 1;
    }

    private int getPivot(int[] nums, int start, int end) {
        if (end - start < 5) return partition5(nums, start, end);
        for (int i = start; i <= end; i += 5) {
            int subRight = Math.min(i + 4, end);
            int median5 = partition5(nums, i, subRight);
            swap(nums, median5, start + (i - start) / 5);
        }
        return quickSelect(nums, start, start + (int) Math.ceil((double) (end - start) / 5) - 1, (end - start) / 10);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) return start;
        int pivot = nums[getPivot(nums, start, end)]; //median of medians
        int i = start, lt = start, rt = end;
        while (i <= rt) {
            if (nums[i] > pivot) {
                swap(nums, i++, lt++);
            } else if (nums[i] < pivot) {
                swap(nums, i, rt--);
            } else {
                i++;
            }
        }
        if (k < lt - start) {
            return quickSelect(nums, start, lt - 1, k);
        } else if (k >= lt - start && k < i - start) return start + k;
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
