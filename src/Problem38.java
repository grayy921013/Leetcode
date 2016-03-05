/**
 * Created by admin on 3/5/16.
 */
public class Problem38 {
    public String countAndSay(int n) {
        if (n <= 1) return "1";
        String s = countAndSay(n - 1);
        char c = s.charAt(0);
        int count = 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char c2 = s.charAt(i);
            if (c2 != c) {
                builder.append(count);
                builder.append(c);
                c = c2;
                count = 1;
            } else {
                count++;
            }
        }
        builder.append(count);
        builder.append(c);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem38().countAndSay(2));
    }
}
