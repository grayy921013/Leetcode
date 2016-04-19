import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/19/16.
 */
public class Problem312 {
    public int maxCoins(int[] nums) {
        //use DP
        int length = nums.length + 2;
        int[] balloon = new int[length];
        for (int i = 0; i < nums.length; i++) balloon[i + 1] = nums[i];
        balloon[0] = 1;
        balloon[length - 1] = 1;
        int[][] coin = new int[length][length];
        for (int k = 2; k < length; k++) {
            for (int start = 0; start < length - k; start++) {
                int end = start + k;
                for (int i = start + 1; i < end; i++) {
                    coin[start][end] = Math.max(coin[start][end],
                            coin[start][i] + coin[i][end] + balloon[i] * balloon[start] * balloon[end]);
                }
            }
        }
        return coin[0][length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem312().maxCoins(new int[]{3, 1, 5, 8}));
    }
}
