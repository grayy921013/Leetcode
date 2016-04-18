import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/18/16.
 */
public class Problem310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        HashSet<Integer>[] adjs = new HashSet[n];
        for (int i = 0; i < n; i++) adjs[i] = new HashSet<Integer>();
        for (int[] edge : edges) {
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
        }
        List<Integer> leafs = new ArrayList<>();
        for (int i = 0; i < adjs.length; i++) {
            if (adjs[i].size() == 1) leafs.add(i);
        }
        while (n > 2) {
            n -= leafs.size();
            List<Integer> newLeafs = new ArrayList<>();
            for (int i : leafs) {
                int j = adjs[i].iterator().next();
                adjs[j].remove(i);
                if (adjs[j].size() == 1) newLeafs.add(j);
            }
            leafs = newLeafs;
        }
        return leafs;
    }
}
