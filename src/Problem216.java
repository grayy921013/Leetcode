import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        traverse(result, list, k, 1, n);
        return result;
    }

    private void traverse(List<List<Integer>> results, List<Integer> list, int numNeed, int startFrom, int remain) {
        if (remain < startFrom * numNeed || 9 * numNeed < remain) return;
        if (numNeed == 1) {
            List<Integer> result = new ArrayList<>(list);
            result.add(remain);
            results.add(result);
            return;
        }
        for (int i = startFrom; i * numNeed < remain && i <= 9 - numNeed + 1; i++) {
            list.add(i);
            traverse(results, list, numNeed - 1, i + 1, remain - i);
            list.remove(list.size() - 1);
        }
    }
}
