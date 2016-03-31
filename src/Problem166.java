import java.util.HashMap;

/**
 * Created by Zhehui Zhou on 3/31/16.
 */
public class Problem166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = Math.abs((long)numerator);
        long deno = Math.abs((long)denominator);
        boolean flag = ((long)numerator * (long)denominator) < 0;
        long a = num / deno;
        long b = num % deno;
        String result  = (flag ? "-" : "") + a + "";
        if (b == 0) return result;
        String f = "";
        HashMap<Long, Integer> map = new HashMap<>();
        while(b != 0) {
            b *= 10;
            if (map.containsKey(b)) break;
            map.put(b, f.length());
            a = b / deno;
            f += a;
            b = b % deno;
        }
        if (b == 0) return result + "." + f;
        else return result + "." + f.substring(0, map.get(b)) + "(" + f.substring(map.get(b)) + ")";
    }

    public static void main(String[] args) {
        System.out.println(new Problem166().fractionToDecimal(0, -99));
    }
}
