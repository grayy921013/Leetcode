/**
 * Created by Zhehui Zhou on 3/22/16.
 */
public class Problem122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = prices[prices.length - 1];
        int min = max;
        int profit = 0;
        for(int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit += (max - min);
                max = prices[i];
                min = max;
            }
        }
        return profit + max - min;
    }
}
