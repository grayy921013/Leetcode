/**
 * Created by Zhehui Zhou on 4/9/16.
 */
public class Problem233 {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        int num = n / 10 - 1;
        return countDigitOne(num) * 10 + (n + 9) / 10 + (n % 10 + 1) * numOfOne(n / 10);
    }

    private int numOfOne(int n) {
        int count = 0;
        while(n > 0) {
            if (n % 10 == 1) count++;
            n /= 10;
        }
        return count;
    }
}
