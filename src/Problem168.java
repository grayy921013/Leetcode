/**
 * Created by Zhehui Zhou on 3/31/16.
 */
public class Problem168 {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while(n > 0) {
            n--;
            builder.insert(0, (char)(n % 26 + 'A'));
            n = n / 26;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem168().convertToTitle(27*26+1));
    }
}
