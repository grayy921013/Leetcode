import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Zhehui Zhou on 3/22/16.
 */
public class Problem127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //two-end bfs
        Set<String> visited = new HashSet<>();
        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);
        int length = 1;
        //start from the smaller set, get all one-character distance word of words in this set
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                Set<String> temp = begin;
                begin = end;
                end = temp;
            }
            Set<String> nextSet = new HashSet<>();
            for (String word : begin) {
                char[] content = word.toCharArray();
                for(int i = 0; i < content.length; i++) {
                    char old = content[i];
                    for(int j = 0; j < 26; j++) {
                        content[i] = (char)('a' + j);
                        String nextWord = new String(content);
                        if (end.contains(nextWord)) return length + 1;
                        if (!visited.contains(nextWord) && wordList.contains(nextWord)) {
                            nextSet.add(nextWord);
                            visited.add(nextWord);
                        }
                    }
                    content[i] = old;
                }
            }
            begin = nextSet;
            length++;
        }
        return 0;
    }


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(new Problem127().ladderLength("hit", "cog", set));
    }
}
