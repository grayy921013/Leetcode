import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem212 {
    public static class TrieNode {
        TrieNode[] array = new TrieNode[26];
        String s = null;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();
        //build a trie
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.array[word.charAt(i) - 'a'] == null) node.array[word.charAt(i) - 'a'] = new TrieNode();
                node = node.array[word.charAt(i) - 'a'];
            }
            node.s = word;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(list, board, i, j, root);
            }
        }
        return list;
    }

    private void search(List<String> list, char[][] board, int row, int col, TrieNode node) {
        if (node.s != null) {
            list.add(node.s); // add to list
            node.s = null; //delete this node to avoid duplication
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        char c = board[row][col];
        if (c != 0 && node.array[c - 'a'] != null) {
            board[row][col] = 0;
            search(list, board, row + 1, col, node.array[c - 'a']);
            search(list, board, row - 1, col, node.array[c - 'a']);
            search(list, board, row, col + 1, node.array[c - 'a']);
            search(list, board, row, col - 1, node.array[c - 'a']);
            board[row][col] = c;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem212().findWords(new char[][]{{'a'}}, new String[]{"a"}));
    }
}
