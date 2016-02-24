/**
 * Created by admin on 2/24/16.
 */
public class Problem7 {
    //reverse an integer
    public int reverse(int x) {
        boolean sign = x > 0;
        x = sign ? x : -x;
        int result = 0;
        while (x > 0) {
            //handle overflow
            if (result * 10 / 10 != result) return 0;
            result = result * 10 + x % 10;
            x = x / 10;
        }
        //handle overflow
        return sign ? result : -result;
    }

    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        System.out.println(problem7.reverse(1534236469) + "");
        System.out.println(problem7.reverse(-321) + "");
    }
}
