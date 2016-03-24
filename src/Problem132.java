
/**
 * Created by Zhehui Zhou on 3/24/16.
 */
public class Problem132 {
    public int minCut(String s) {
        //pad[j][i] = true if s[j..i] is a palindrome
//        boolean[][] pad = new boolean[s.length()][s.length()];
//        int[] cut = new int[s.length()];
//        for(int i = 0; i < s.length(); i++) {
//            int min = i;
//            for(int j = 0; j <= i; j++) {
//                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || pad[j + 1][i - 1])) {
//                    pad[j][i] = true;
//                    min = Math.min(j == 0 ? 0 : cut[j - 1] + 1, min);
//                }
//            }
//            cut[i] = min;
//        }
//        return cut[cut.length - 1];
        //another solution
        int length = s.length();
        int[] cut = new int[length + 1];
        for(int i = 0; i < cut.length; i++) cut[i] = i - 1;
        for(int i = 0; i < length; i++) {
            //use i as the center, find all the palindrome
            for(int j = 0; i - j >= 0 && i + j < length && s.charAt(i - j) == s.charAt(i + j); j++) {
                //odd length
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j] + 1);
            }
            for(int j = 1; i - j + 1 >= 0 && i + j < length && s.charAt(i - j + 1) == s.charAt(i + j); j++) {
                //even length
                cut[i + j + 1] = Math.min(cut[i + j + 1], cut[i - j + 1] + 1);
            }
        }
        return cut[length];
    }

    public static void main(String[] args) {
        new Problem132().minCut("bb");
    }

}
