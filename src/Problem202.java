import java.util.HashSet;

/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if(set.contains(n)) return false;
            set.add(n);
            int result = 0;
            while(n > 0) {
                result += (n % 10) * (n % 10);
                n /= 10;
            }
            n = result;
        }
        return true;
    }
}
