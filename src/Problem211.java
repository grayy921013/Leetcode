/**
 * Created by Zhehui Zhou on 4/4/16.
 */
public class Problem211 {
    private static class TrieNode {
        TrieNode[] array = new TrieNode[26];
        private boolean hasWord;
        public TrieNode put(char c) {
            if (array[c - 'a'] == null) array[c - 'a'] =  new TrieNode();
            return array[c - 'a'];
        }

        public boolean search(String word, int index) {
            if (index == word.length()) return hasWord;
            if(word.charAt(index) != '.') {
                if (array[word.charAt(index) - 'a'] == null) return false;
                return array[word.charAt(index) - 'a'].search(word, index + 1);
            } else {
                for(int i = 0; i < 26; i++) {
                    if(array[i] != null && array[i].search(word, index + 1)) return true;
                }
                return false;
            }
        }
    }
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            node = node.put(word.charAt(i));
        }
        node.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word, 0);
    }

    public static void main(String[] args) {
        Problem211 problem211 = new Problem211();
        problem211.addWord("a");
        System.out.println(problem211.search("."));
    }
}
