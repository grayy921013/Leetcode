import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/21/16.
 */
public class Problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        int i = 0;
        List<Integer> lastRow = null;
        for(List<Integer> present : triangle) {
            if (i == 0) {
                lastRow = present;
                i++;
                continue;
            }
            present = new ArrayList<>(triangle.get(i));
            present.set(0, present.get(0) + lastRow.get(0));
            for(int j = 1; j < i; j++) {
                present.set(j, present.get(j) + Math.min(lastRow.get(j - 1), lastRow.get(j)));
            }
            present.set(i, present.get(i) + lastRow.get(i - 1));
            lastRow = present;
            i++;
        }
        return Collections.min(lastRow);
    }
}
