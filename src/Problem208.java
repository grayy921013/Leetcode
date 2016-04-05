/**
 * Created by Zhehui Zhou on 4/4/16.
 */
public class Problem208 {
    class TrieNode {
        // Initialize your data structure here.
        TrieNode[] array = new TrieNode[26];
        boolean hasWord;
        public TrieNode() {

        }
        public void insert(String word, int index) {
            if (index >= word.length()) {
                hasWord = true;
                return;
            }
            if (array[word.charAt(index) - 'a'] == null) array[word.charAt(index) - 'a'] = new TrieNode();
            array[word.charAt(index) - 'a'].insert(word, index + 1);
        }
        public TrieNode searchFor(String word, int index) {
            if (index >= word.length()) {
                return this;
            }
            if (array[word.charAt(index) - 'a'] == null) return null;
            return array[word.charAt(index) - 'a'].searchFor(word, index + 1);
        }
    }
    private TrieNode root;

    public Problem208() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.searchFor(word, 0);
        return node != null && node.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.searchFor(prefix, 0);
        return node != null;
    }
}
