import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/21/16.
 */
public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (i == 0) {
                result.add(list);
                continue;
            }
            for(int j = 0; j < i - 1; j++) {
                list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
