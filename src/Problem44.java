/**
 * Created by admin on 3/5/16.
 */
public class Problem44 {
    //    '?' Matches any single character.
//    '*' Matches any sequence of characters (including the empty sequence).
    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0, starIndex = -1, match = 0;
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
                pIndex++;
                sIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                //we remember the index of last star and last match
                starIndex = pIndex;
                match = sIndex;
                //then we only increment pIndex
                pIndex++;
            } else if (starIndex != -1) {
                //go back to last matching point
                //try to match one more digit in s
                pIndex = starIndex + 1;
                match++;
                sIndex = match;
            } else return false;
        }
        for (; pIndex < p.length(); pIndex++) {
            if (p.charAt(pIndex) != '*') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem44 problem44 = new Problem44();
        System.out.println(problem44.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }
}
