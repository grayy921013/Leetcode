import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/1/16.
 */
public class Problem187 {
    private int charToNum(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'T':
                return 1;
            case 'C':
                return 2;
            case 'G':
            default:
                return 3;
        }
    }
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (s.length() < 10) return list;
        int num = 0;
        for(int i = 0; i < 10; i++) {
            num <<= 2;
            num += charToNum(s.charAt(i));
        }
        map.put(num, 1);
        int base = 1 << (2 * 9);
        for(int i = 10; i < s.length(); i++) {
            num -= base * charToNum(s.charAt(i - 10));
            num <<= 2;
            num += charToNum(s.charAt(i));
            if (map.get(num) == null) map.put(num, 1);
            else if (map.get(num) == 1) {
                map.put(num, 2);
                list.add(s.substring(i - 9, i + 1));
            }
        }
        return list;
    }
}
