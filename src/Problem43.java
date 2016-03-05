import java.math.BigInteger;
import java.util.LinkedList;

/**
 * Created by admin on 3/5/16.
 */
public class Problem43 {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int mul = (num1.charAt(m - 1 - i) - '0') * (num2.charAt(n - 1 - j) - '0') + result[i + j];
                result[i + j] = mul % 10;
                //no need to make sure entry (i+j+1) < 10, because this entry will be processed in the future
                result[i + j + 1] += mul / 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = m + n - 1; i >= 0; i--) {
            if (result[i] != 0 || builder.length() != 0) builder.append(result[i]);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem43().multiply("123", "456"));
    }
}
