import java.util.HashMap;

/**
 * Created by admin on 2/25/16.
 */
public class Problem13 {
    public int romanToInt(String s) {
        if (s.isEmpty()) return 0;
//        int[] indexs = new int[]{1, 5, 10, 50, 100, 500, 1000};
//        char[] values = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
//        HashMap<Character, Integer> maps = new HashMap<>();
//        for(int i = 0; i < indexs.length; i++) maps.put(values[i], indexs[i]);
        //usage of hashmap should be avoided
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        int result = map[s.charAt(s.length() - 1) - 'A'];
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            int newValue = map[s.charAt(i) - 'A'];
            if (newValue > value) result -= value;
            else result += value;
            value = newValue;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem13 problem13 = new Problem13();
        System.out.println(problem13.romanToInt("MCMXCVI"));
    }
}
