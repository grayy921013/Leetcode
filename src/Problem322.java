/**
 * Created by Zhehui Zhou on 4/21/16.
 */
public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] cnt = new int[amount + 1];
        for(int coin : coins) {
            if (coin <= amount) cnt[coin] = 1;
            for(int i = 1; i <= amount - coin; i ++) {
                if(cnt[i] > 0) {
                    if (cnt[i + coin] == 0) cnt[i + coin] = cnt[i] + 1;
                    else cnt[i + coin] = Math.min(cnt[i + coin], cnt[i] + 1);
                }
            }
        }
        return cnt[amount] == 0 ? -1 : cnt[amount];
    }

    public static void main(String[] args) {
        new Problem322().coinChange(new int[]{2}, 4);
    }
}
