/**
 * Created by Zhehui Zhou on 4/18/16.
 */
public class Problem309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int[] profit = new int[prices.length];
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - (i > 1 ? profit[i - 2] : 0) < min) {
                min = prices[i] - (i > 1 ? profit[i - 2] : 0);
                max = prices[i];
            } else if (prices[i] > max) max = prices[i];
            profit[i] = Math.max(profit[i - 1], max - min);
        }
        return profit[prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem309().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
