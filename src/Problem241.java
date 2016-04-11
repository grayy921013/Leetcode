import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/11/16.
 */
public class Problem241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int num = 0;
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') num = num * 10 + input.charAt(i) - '0';
            else {
                nums.add(num);
                num = 0;
                operators.add(input.charAt(i));
            }
        }
        nums.add(num);
        return diffWaysToCompute(nums, operators, 0, nums.size() - 1);
    }

    public List<Integer> diffWaysToCompute(List<Integer> nums, List<Character> operators, int start, int end) {
        List<Integer> result = new ArrayList<>();
        if (start == end) {
            result.add(nums.get(start));
            return result;
        }
        if (start == end - 1) {
            result.add(calculate(nums.get(start), nums.get(end), operators.get(start)));
            return result;
        }
        for(int i = start; i < end; i++) {
            List<Integer> first = diffWaysToCompute(nums, operators, start, i);
            List<Integer> second = diffWaysToCompute(nums, operators, i + 1, end);
            for(int a : first) {
                for(int b : second) {
                    result.add(calculate(a, b, operators.get(i)));
                }
            }
        }
        return result;
    }

    private int calculate(int a, int b, char c) {
        if(c == '+') return a + b;
        else if (c == '-') return a - b;
        else return a * b;
    }

    public static void main(String[] args) {
        System.out.println(new Problem241().diffWaysToCompute("2*3-4*5"));
    }
}
