/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Problem191().hammingWeight(11));
    }
}
