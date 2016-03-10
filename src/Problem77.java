import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem77 {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        addCombination(result,new ArrayList<>(), n, 0, 0, k);
        return result;
    }
    private void addCombination(List<List<Integer>> result, List<Integer> list, int n, int startIndex, int level, int k) {
        if (level == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = startIndex + 1; i <= n - k + level + 1; i++) {
            list.add(i);
            addCombination(result, list, n, i, level + 1, k);
            list.remove(list.size() - 1);
        }
    }
}
