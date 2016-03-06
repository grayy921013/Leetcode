import java.util.*;

/**
 * Created by Zhehui Zhou on 3/6/16.
 */
public class Problem49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs) {
            ArrayList<String> queue;
            String key = getSmallestPerm(s);
            if ((queue = map.get(key)) == null) {
                queue = new ArrayList<>();
                map.put(key, queue);
            }
            queue.add(s);
        }
        for(List<String> list : map.values()) Collections.sort(list);

        return new ArrayList<>(map.values());
    }
    private String getSmallestPerm(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
