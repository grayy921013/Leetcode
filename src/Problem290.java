/**
 * Created by Zhehui Zhou on 4/14/16.
 */
public class Problem290 {
    public boolean wordPattern(String pattern, String str) {
        String[] match = new String[26];
        String[] letters = str.split(" ");
        if (pattern.length() != letters.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            int index = pattern.charAt(i) - 'a';
            if (match[index] == null) {
                for(int j = 0; j < 26; j++) {
                    if(letters[i].equals(match[j])) return false;
                }
                match[index] = letters[i];
            }
            else if (!match[index].equals(letters[i])) return false;
        }
        return true;
    }
}
