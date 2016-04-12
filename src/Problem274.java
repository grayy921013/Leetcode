import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 4/12/16.
 */
public class Problem274 {
    public int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0) return 0;
        int[] count = new int[length + 1];
        for(int i = 0; i < length; i++) {
            if(citations[i] > length) count[length]++;
            else count[citations[i]]++;
        }
        int hIndex = 0;
        for(int i = length; i >= 0; i--) {
            hIndex += count[i];
            if(hIndex >= i) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Problem274().hIndex(new int[]{4,4,0,0}));
    }
}
