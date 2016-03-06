import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 3/6/16.
 */
public class Problem46 {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        permute(lists, list, 0, nums);
        return lists;
    }

    private void permute(List<List<Integer>> lists, ArrayList<Integer> list, int index, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(list);
            return;
        }
        for (int i = 0; i <= list.size(); i++) {
            ArrayList<Integer> list1 = new ArrayList<>(list);
            list1.add(i, nums[index]);
            permute(lists, list1, index + 1, nums);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem46().permute(new int[]{1, 2, 3}));
    }
}
