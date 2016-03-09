/**
 * Created by Zhehui Zhou on 3/9/16.
 */
public class Problem67 {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int aIndex = a.length() - 1, bIndex = b.length() - 1;
        int rem = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            if (rem == 0 && (aIndex < 0 || bIndex < 0)) {
                builder.insert(0, aIndex < 0 ? b : a, 0, aIndex < 0 ? bIndex + 1: aIndex + 1);
                return builder.toString();
            }
            int sum = (aIndex >= 0 ? a.charAt(aIndex--) - '0' : 0) + (bIndex >= 0 ? b.charAt(bIndex--) - '0' : 0) + rem;
            rem = sum / 2;
            builder.insert(0, sum % 2);
        }
        if (rem > 0) builder.insert(0, rem);
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem67().addBinary("0", "0"));
    }
}
