/**
 * Created by Zhehui Zhou on 3/22/16.
 */
public class Problem121 {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                //if update max, have to update min at the same time
                max = prices[i];
                min = prices[i];
            }
            if (prices[i] < min) min = prices[i];
            if (max - min > profit) profit = max - min;
        }
        return profit;
    }
}
