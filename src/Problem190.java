/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem190 {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem190().reverseBits(1));
    }
}
