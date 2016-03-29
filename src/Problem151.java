
/**
 * Created by Zhehui Zhou on 3/29/16.
 */
public class Problem151 {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for(int i = words.length - 1; i > 0; i--) {
            builder.append(words[i]);
            builder.append(" ");
        }
        builder.append(words[0]);
        return builder.toString();
    }
}
