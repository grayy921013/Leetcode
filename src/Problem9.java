/**
 * Created by admin on 2/24/16.
 */
public class Problem9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        //use reverse idea in problem7
        int result = 0;
        while (x > 0) {
            //handle overflow
            if (result > (Integer.MAX_VALUE - x % 10) / 10) return false;
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return x == result;
    }
}
