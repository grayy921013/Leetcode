import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/16/16.
 */
public class Problem89 {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        List<Integer> result = grayCode(n - 1);
        int offset = 1 << (n - 1);
        int length = result.size();
        for(int i = length - 1; i >= 0; i--) {
            result.add(result.get(i) + offset);
        }
        return result;
    }
}
