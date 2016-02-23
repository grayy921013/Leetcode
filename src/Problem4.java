/**
 * Created by admin on 2/18/16.
 */
public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int start1, int[] nums2, int start2, int k) {
        //get the kth item in two arrays with starting position start1 and start2
        if (nums1.length - start1 > nums2.length - start2) {
            return findMedianSortedArrays(nums2, start2, nums1, start1, k);
        }
        if (start1 == nums1.length) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = Math.min(nums1.length - start1, k / 2);
        int j = Math.min(nums2.length - start2, k / 2);
        //we can throw away part of the array
        if (nums1[start1 + i - 1] < nums2[start2 + j - 1])
            return findMedianSortedArrays(nums1, start1 + i, nums2, start2, k - i);
        else return findMedianSortedArrays(nums1, start1, nums2, start2 + j, k - j);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 0)
            return (findMedianSortedArrays(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2)
                    + findMedianSortedArrays(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2 + 1)) / 2;
        else return findMedianSortedArrays(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2 + 1);
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 5, 7, 9};
        int[] a2 = new int[]{2, 4, 6, 8};
        Problem4 problem4 = new Problem4();
        System.out.println(problem4.findMedianSortedArrays(a1, a2) + "");
    }
}
