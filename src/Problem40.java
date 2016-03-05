import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 3/5/16.
 */
public class Problem40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        if (startIndex >= candidates.length) return;
        int i = startIndex;
        while (i < candidates.length) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);
                //no need to start at the index with same value
                //but for next level, we may still need to make use of entry with equal value
                findCombination(lists, list, candidates, target - candidates[i], i + 1);
                int j = i;
                while(i < candidates.length && candidates[i] == candidates[j]) i++;
                list.remove(list.size() - 1);
            } else break;
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 2};
        System.out.println(new Problem40().combinationSum2(candidates, 2));
    }
}
