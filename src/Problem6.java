/**
 * Created by admin on 2/23/16.
 */
public class Problem6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; ; j++) {
                int index = j * (2 * numRows - 2) + i;
                if (index >= s.length()) break;
                builder.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    index += (numRows - i - 1) * 2;
                    if (index >= s.length()) break;
                    builder.append(s.charAt(index));
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Problem6 problem6 = new Problem6();
        System.out.println(problem6.convert("PAYPALISHIRING", 3));
    }
}
