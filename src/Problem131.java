import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/23/16.
 */
public class Problem131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) list.add(s.substring(i, i + 1));
        //list now contain all one character strings
        search(result, list, 0);
        return result;
    }

    private void search(List<List<String>> result, List<String> list, int startIndex) {
        result.add(list);
        //try to merge valid list to get new answers
        for (int i = startIndex; i < list.size() - 1; i++) {
            //compare i with i + 1
            if (isPalindromePair(list.get(i), list.get(i + 1))) {
                //make a copy and merge them
                List<String> copy = new ArrayList<>(list);
                copy.set(i, list.get(i) + list.get(i + 1));
                copy.remove(i + 1);
                search(result, copy, i);
            }
        }
        for (int i = startIndex < 1 ? 0 : startIndex - 1; i < list.size() - 2; i++) {
            //compare i with i + 2
            if (isPalindromePair(list.get(i), list.get(i + 2))) {
                //make a copy and merge them
                List<String> copy = new ArrayList<>(list);
                copy.set(i, list.get(i) + list.get(i + 1) + list.get(i + 2));
                copy.remove(i + 1);
                copy.remove(i + 1);
                search(result, copy, i);
            }
        }
    }

    private boolean isPalindromePair(String a, String b) {
        if (a.length() != b.length()) return false;
        int length = a.length();
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(length - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem131().partition("ababababababababababababcbabababababababababababa"));
    }
}
