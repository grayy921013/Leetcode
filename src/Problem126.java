import java.util.*;

/**
 * Created by Zhehui Zhou on 3/22/16.
 */
public class Problem126 {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        //bfs
        Map<String, List<List<String>>> path = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        List<List<String>> result = new ArrayList<>();
        result.add(list);
        path.put(beginWord, result);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String word = queue.poll();
                char[] content = word.toCharArray();
                for (int i = 0; i < content.length; i++) {
                    char old = content[i];
                    for (int j = 0; j < 26; j++) {
                        content[i] = (char) ('a' + j);
                        String nextWord = new String(content);
                        if (!nextWord.equals(word) && (wordList.contains(nextWord) || nextWord.equals(endWord))) {
                            if (visited.contains(nextWord) || (path.get(nextWord) != null && path.get(nextWord).get(0).size() <= path.get(word).get(0).size())) {
                                continue;
                            }
                            if (path.get(nextWord) == null) {
                                path.put(nextWord, new ArrayList<>());
                                queue.offer(nextWord);
                            }
                            for(List<String> oldPath : path.get(word)) {
                                List<String> newPath = new ArrayList<>(oldPath);
                                newPath.add(nextWord);
                                path.get(nextWord).add(newPath);
                            }
                        }
                    }
                    content[i] = old;
                }
                path.remove(word);
                visited.add(word);
                size--;
            }
            if (path.containsKey(endWord)) {
                return path.get(endWord);
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(new Problem126().findLadders("hit", "cog", set));
    }

}
