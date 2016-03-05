import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 3/5/16.
 */
public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //sort the candidates first
        Arrays.sort(candidates);
        findCombination(lists, list, candidates, target, 0);
        return lists;
    }
    private void findCombination(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int startIndex) {
        //dfs, we only search from the startIndex to avoid duplication
        if (target == 0) lists.add(new ArrayList<>(list));
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                findCombination(lists, list, candidates, target - candidates[i], i);
                list.remove(list.size() - 1);
            } else break;
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(new Problem39().combinationSum(candidates, 7));
    }
}
