import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 4/22/16.
 */
public class Problem324 {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }

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
        int[] a = new int[]{1,1,1,2,2,2};
        new Problem324().wiggleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
