import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Zhehui Zhou on 4/21/16.
 */
public class Problem318 {
    public int maxProduct(String[] words) {
        //sort the array to enable pruning
        int[] num = new int[words.length];
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });
        for (int i = 0; i < words.length; i++) num[i] = compute(words[i]);
        int product = 0;
        for(int i = 0; i < num.length - 1; i++) {
            if (words[i].length() * words[i].length() <= product) break; //prune
            for(int j = i + 1; j < num.length; j++) {
                if ((num[i] & num[j]) == 0) {
                    product = Math.max(product, words[i].length() * words[j].length());
                    break;
                }
            }
        }
        return product;
    }

    private int compute(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) num |= (1 << (s.charAt(i) - 'a'));
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Problem318().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }
}
