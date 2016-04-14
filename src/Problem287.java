/**
 * Created by Zhehui Zhou on 4/14/16.
 */
public class Problem287 {
    public int findDuplicate(int[] nums) {
        //bianry search
//        int start = 1, end = nums.length - 1;
//        while(start <= end) {
//            int mid = (start + end) >>> 1;
//            int countMid = 0;
//            int countLessMid = 0; //count numbers less than mid
//            for(int i = 0; i < nums.length; i++) {
//                if(nums[i] == mid) {
//                    countMid++;
//                    if (countMid > 1) return mid;
//                } else if (nums[i] <mid) countLessMid++;
//            }
//            if (countLessMid > mid - 1) end = mid - 1;
//            else start = mid + 1;
//        }
//        return 0;

        //slow, fast pointer
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem287().findDuplicate(new int[]{2, 1, 1, 1, 4}));
    }
}
