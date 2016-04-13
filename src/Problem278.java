/**
 * Created by Zhehui Zhou on 4/13/16.
 */
public class Problem278 {
    public boolean isBadVersion(int n) {
        if (n >= 1702766719) return true;
        return false;
    }
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while(start <= end) {
            int mid = (start + end) >>> 1;
            if (isBadVersion(mid)) end = mid - 1;
            else start = mid + 1;
        }
        return end + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem278().firstBadVersion(2126753390));
    }
}
