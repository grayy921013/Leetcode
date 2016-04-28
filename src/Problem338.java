/**
 * Created by Zhehui Zhou on 4/28/16.
 */
public class Problem338 {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for(int i = 1; i < num + 1; i++) {
            bits[i] = bits[i>>>1] + (i & 1);
        }
        return bits;
    }
}
