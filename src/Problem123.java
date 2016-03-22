/**
 * Created by Zhehui Zhou on 3/22/16.
 */
public class Problem123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        int n = prices.length;
        int[] profits = new int[n]; //profits[i] denotes the profit can earn from i to n
        //from tail to head
        for(int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                //if update max, have to update min at the same time
                max = prices[i];
                min = prices[i];
            }
            if (prices[i] < min) min = prices[i];
            if (max - min > profit) profit = max - min;
            profits[i] = profit;
        }
        //then from head to tail
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        profit = profits[0]; //if only make one transaction
        for(int i = 0; i < prices.length - 2; i++) {
            if (prices[i] < min) {
                //if update max, have to update min at the same time
                max = prices[i];
                min = prices[i];
            }
            if (prices[i] > max) max = prices[i];
            int total = max - min + profits[i + 1]; //one transaction in [0, i], one in [i+1, n]
            if (total > profit) profit = total;
        }
        return profit;
    }

    public static void main(String[] args) {
        new Problem123().maxProfit(new int[]{1, 2});
    }
}
