/**
 * Created by Zhehui Zhou on 4/12/16.
 */
public class Problem273 {
    static String[] nums = new String[]{"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"
    ,"Eleven","Twelve", "Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen", "Twenty","Thirty",
    "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return numberToWords(num, 0);
    }

    public String numberToWords(int num, int level) {
        int two = num % 100;
        num /= 100;
        String s;
        if (two <= 20) s = nums[two];
        else s = two % 10 == 0 ? nums[two / 10 + 18] : nums[two / 10 + 18] + " " + nums[two % 10];
        if (num > 0) {
            s = s.equals("") ? nums[num % 10] + " Hundred" : nums[num % 10] + " Hundred " + s;
            num = num / 10;
        }
        if (level > 0) {
            if (level == 1) s += " Thousand";
            else if (level == 2) s += " Million";
            else s += " Billion";
        }
        if (num == 0) return s;
        return s.equals("") ? numberToWords(num, level + 1) : numberToWords(num, level + 1) + " " + s;
    }

    public static void main(String[] args) {
        System.out.println(new Problem273().numberToWords(1234567));
    }
}
