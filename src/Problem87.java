import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 3/16/16.
 */
public class Problem87 {
    public boolean isScramble(String s1, String s2) {
        //This is true if s1.part1 is scramble of s2.part1 && s1.part2 is scramble of s2.part2
        //One tricky method is to use prime number to create fake hash
        //More reliable method:
        int length = s1.length();
        if (length <= 1) return s1.equals(s2);
        for (int i = 1; i < length; i++) {
            String part1 = s1.substring(0, i);
            String part2 = s1.substring(i);
            String part3 = s2.substring(0, i);
            String part4 = s2.substring(i);
            String part5 = s2.substring(length - i);
            String part6 = s2.substring(0, length - i);
            if (stringEqual(part1, part3) && stringEqual(part2, part4) && isScramble(part1, part3) && isScramble(part2, part4)) {
                return true;
            }
            if (stringEqual(part1, part5) && stringEqual(part2, part6) && isScramble(part1, part5) && isScramble(part2, part6)) {
                return true;
            }
        }
        return false;
    }

    private boolean stringEqual(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        Arrays.sort(array1);
        char[] array2 = s2.toCharArray();
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {
        System.out.println(new Problem87().isScramble("hobobyrqd", "hbyorqdbo"));
    }
}
