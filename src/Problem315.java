import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/20/16.
 */
public class Problem315 {
    private static class Element {
        int index;
        int num;

        public Element(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        //use merge sort
        int[] smaller = new int[nums.length];
        Element[] array = new Element[nums.length];
        for(int i = 0; i < nums.length; i++) array[i] = new Element(i, nums[i]);
        mergeSort(array,0, array.length - 1, smaller);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < smaller.length; i++) result.add(smaller[i]);
        return result;
    }

    private void mergeSort(Element[] array, int start, int end, int[] smaller) {
        if (start >= end) return;
        int mid = (start + end) >>> 1;
        mergeSort(array, mid + 1, end, smaller);
        mergeSort(array, start, mid, smaller);
        Element[] auxiliary = new Element[end - start + 1];
        int i = start, j = mid + 1;
        while (i <= mid || j <= end) {
            if (j > end || i <= mid && array[i].num <= array[j].num) {
                //we know there are (j - mid - 1) items in the latter part of the list,
                //which is smaller than the array[i]
                auxiliary[i + j - start -  mid - 1] = array[i];
                smaller[array[i].index] += (j - mid - 1);
                i++;
            } else {
                auxiliary[i + j - start -  mid - 1] = array[j];
                j++;
            }
        }
        for(i = 0; i <= end - start; i++) array[i + start] = auxiliary[i];
    }

    public static void main(String[] args) {
        System.out.println(new Problem315().countSmaller(new int[]{5,2,6,1}));
    }
}
