import java.util.ArrayList;

/**
 * Created by Zhehui Zhou on 3/8/16.
 */
public class Problem60 {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fact *= (i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0, level = k - 1; i < n; i++) {
            fact /= (n - i);
            builder.append(list.remove(level / fact));
            level -= level / fact * fact;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem60().getPermutation(3, 5));
    }
}
