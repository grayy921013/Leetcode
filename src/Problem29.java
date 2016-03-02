/**
 * Created by admin on 3/1/16.
 */
public class Problem29 {
    //Divide two integers without using multiplication, division and mod operator.
    public int divide(int dividend, int divisor) {
        if ((dividend == Integer.MIN_VALUE && divisor == -1) || divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long dividendl = Math.abs((long)dividend);
        long divisorl = Math.abs((long)divisor);
        long[] div = new long[]{dividendl};
        return flag ? divideloop(div, divisorl) : -divideloop(div, divisorl);
    }

    private int divideloop(long[] dividend, long divisor) {
        //use array to modify dividend
        int result = 0;
        if (divisor + divisor > 0 && dividend[0] >= divisor + divisor) {
            result = divideloop(dividend, divisor + divisor);
            result = result << 1;
        }
        if (dividend[0] < divisor) return result;
        else {
            dividend[0] -= divisor;
            return result + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem29().divide(-2147483648, 1));
    }
}
