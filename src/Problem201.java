/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem201 {
    public int rangeBitwiseAnd(int m, int n) {
        //only care bits that m has, higher bits will be 0
        int offset = n - m;
        int divisor = 1;
        offset--; // the lowest bit need an extra one to get a carry
        while (offset >= 0) {
            if ((m & divisor) != 0) {
                m -= (m & divisor); // this bit position is 1 for m, then we set it to 0
            } else offset -= divisor; // if this bit position is 0 for m, we need divisor to get a carry
            divisor <<= 1;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(new Problem201().rangeBitwiseAnd(5, 7));
    }
}
