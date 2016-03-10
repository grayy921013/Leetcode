/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m < n) return minDistance(word2, word1);
        //O(mn) space:
//        int[][] cost = new int[m + 1][n + 1];
//        for (int i = 0; i <= m; i++) cost[i][0] = i;
//        for (int i = 1; i <= n; i++) cost[0][i] = i;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (word1.charAt(i) == word2.charAt(j)) cost[i + 1][j + 1] = cost[i][j];
//                else {
//                    int minCost = Math.min(cost[i][j], cost[i][j + 1]);
//                    minCost = Math.min(minCost, cost[i + 1][j]);
//                    cost[i+1][j+1] = minCost + 1;
//                }
//            }
//        }
//        return cost[m][n];
        //O(n) space:
        int[] cost = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            int pre = cost[0];
            for (int j = 0; j <= n; j++) {
                int temp = cost[j];
                if (i == 0) cost[j] = j;
                else if (j == 0) cost[j] = i;
                else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) cost[j] = pre;
                    else {
                        int minCost = Math.min(cost[j - 1], cost[j]);
                        minCost = Math.min(minCost, pre);
                        cost[j] = minCost + 1;
                    }
                }
                pre = temp;
            }
        }
        return cost[n];
    }
}
