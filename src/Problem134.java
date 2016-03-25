/**
 * Created by Zhehui Zhou on 3/25/16.
 */
public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //if total sum > 0, there must be a solution
//        int maxSumVal = 0;
//        int maxSum = 0;
//        int totalSum = 0;
//        int start = 0;
//        int tempStart = 0;
//        int sum0 = 0;//maxSum starting from 0
//        for(int i = 0; i < gas.length; i++) {
//            totalSum += gas[i] - cost[i];
//            maxSum += gas[i] - cost[i];
//            if (maxSum < 0) {
//                maxSum = 0;
//                tempStart = i + 1;
//            } else {
//                //link from tail to the head
//                if (i == gas.length - 1 && sum0 > 0) {
//                    maxSum += sum0;
//                }
//                if (maxSum > maxSumVal) {
//                    maxSumVal = maxSum;
//                    start = tempStart;
//                    if (start == 0) sum0 = maxSum;
//                }
//            }
//        }
//        return totalSum >= 0 ? start : -1;

        //more elegant one: actually no need to compute the max sub sequence sum
        int totalSum = 0;
        int maxSum = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            totalSum += gas[i] - cost[i];
            maxSum += gas[i] - cost[i];
            if (maxSum < 0) {
                //if sum < 0, it's impossible to start from the current starting point
                //so we simply set sum to 0, and start to the next point
                maxSum = 0;
                start = i + 1;
            }
        }
        return totalSum < 0 ? - 1 : start;
    }
}
