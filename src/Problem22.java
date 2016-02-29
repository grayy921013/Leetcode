import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by admin on 2/29/16.
 */
public class Problem22 {
    public List<String> generateParenthesis(int n) {
        //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
        List<String> list = new LinkedList<>();
        dfs(list, "", 0, 0, n);
        return list;
    }

    private void dfs(List<String> list, String s, int left, int right, int number) {
        // left & right stands for the number of "(" and ")" already in s
        // if left < number then we can add "("
        // if right < left then we can add ")"
        if (left == number && right == number) list.add(s);
        if (left < number) dfs(list, s + "(", left + 1, right, number);
        if (right < left) dfs(list, s + ")", left, right + 1, number);
    }
}

