import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/9/16.
 */
public class Problem68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<>();
        int start = 0, end = 0;
        while(end < words.length) {
            int wordLength = 0;
            while (end < words.length && wordLength <= maxWidth) {
                wordLength += words[end].length();
                if (wordLength >  maxWidth) {
                    //too long, minus this word and the previous space
                    wordLength = wordLength - words[end].length();
                    break;
                } else {
                    end++;
                    //for space
                    wordLength += 1;
                }
            }
            //minus the last space
            wordLength -= 1;
            StringBuilder builder = new StringBuilder();
            if (end == words.length) {
                //last line
                for(int j = start; j < end; j++) {
                    builder.append(words[j]);
                    if (j != end - 1) builder.append(' ');
                }
                for(int j = maxWidth - wordLength; j > 0; j--) builder.append(' ');
            } else {
                //not last line
                int extraSpace = maxWidth - wordLength;
                int spaceCount = end - start - 1;
                int eachSpace;
                int reminder = 0;
                if (spaceCount == 0) {
                    eachSpace = extraSpace;
                } else {
                    eachSpace = extraSpace / spaceCount;
                    reminder = extraSpace % spaceCount;
                }
                for(int j = start; j < end; j++) {
                    builder.append(words[j]);
                    if (spaceCount != 0 && j != end - 1) {
                        for(int k = 0; k < eachSpace; k++) builder.append(' ');
                        if (reminder-- > 0) builder.append(' ');
                        builder.append(' ');
                    } else if (spaceCount == 0) {
                        for(int k = 0; k < eachSpace; k++) builder.append(' ');
                    }
                }
                start = end;
            }
            result.add(builder.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Problem68().fullJustify(new String[]{"Listen","to","many,","speak","to","a","few."}, 6));
    }
}
