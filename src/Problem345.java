/**
 * Created by Zhehui Zhou on 4/30/16.
 */
public class Problem345 {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int start = 0, end = array.length - 1;
        while (start < end) {
            while (start < end && !isVowel(array[start])) start++;
            if (start >= end) break;
            while (start < end && !isVowel(array[end])) end--;
            if (start >= end) break;
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return new String(array);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
