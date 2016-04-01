import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Zhehui Zhou on 4/1/16.
 */
public class Problem174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        if (row == 0) return 0;
        int col = dungeon[0].length;
        int[] health = new int[col + 1];
        for (int i = 0; i <= col; i++) health[i] = Integer.MAX_VALUE;
        health[col - 1] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                health[j] = Math.max(Math.min(health[j], health[j + 1]) - dungeon[i][j], 1);
            }
        }
        return health[0];
    }


    public static void main(String[] args) {
        System.out.println(new Problem174().calculateMinimumHP(new int[][]{{0, -3}}));
    }
}