import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Zhehui Zhou on 4/1/16.
 */
public class Problem175 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strings[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strings, 0, strings.length, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder builder = new StringBuilder();
        for(int i = strings.length - 1; i >= 0; i--) {
            if (builder.toString().equals("0")) break;
            builder.append(strings[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem175().largestNumber(new int[]{12, 121}));
    }
}
