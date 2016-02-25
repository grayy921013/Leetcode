import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2/25/16.
 */
public class Problem17 {
    public List<String> letterCombinations(String digits) {
        String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> newResult = new ArrayList<>();
            for (String s : result) {
                String add = map[digits.charAt(i) - '2'];
                for (int j = 0; j < add.length(); j++) {
                    newResult.add(s + add.charAt(j));
                }
            }
            result = newResult;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem17().letterCombinations("23"));
    }
}
