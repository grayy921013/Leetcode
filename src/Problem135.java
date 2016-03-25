/**
 * Created by Zhehui Zhou on 3/25/16.
 */
public class Problem135 {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for(int i = 0; i < candies.length; i++) candies[i] = 1;
        int sum = ratings.length;
        for(int i = 0; i < ratings.length - 1; i++) {
            //search to the left
            if (ratings[i + 1] > ratings[i] && candies[i + 1] < candies[i] + 1) {
                sum += candies[i] + 1 - candies[i + 1];
                candies[i + 1] = candies[i] + 1;
            }
        }
        for(int i = ratings.length - 1; i > 0; i--) {
            //search to the left
            if (ratings[i - 1] > ratings[i] && candies[i - 1] < candies[i] + 1) {
                sum += candies[i] + 1 - candies[i - 1];
                candies[i - 1] = candies[i] + 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Problem135().candy(new int[]{1, 0, 2}));
        System.out.println(new Problem135().candy(new int[]{2, 1}));
    }
}
