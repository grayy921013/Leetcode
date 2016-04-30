import java.util.Arrays;

/**
 * Created by Zhehui Zhou on 4/30/16.
 */
public class Problem344 {
    public String reverseString(String s) {
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        return new String(array);
    }
}
