/**
 * Created by Zhehui Zhou on 3/31/16.
 */
public class Problem165 {
    public int compareVersion(String version1, String version2) {
        int index1 = 0;
        int index2 = 0;
        while(index1 < version1.length() || index2 < version2.length()) {
            int num1 = 0, num2 = 0;
            while(index1 < version1.length() && version1.charAt(index1) != '.') num1 = num1 * 10 + version1.charAt(index1++) - '0';
            while(index2 < version2.length() && version2.charAt(index2) != '.') num2 = num2 * 10 + version2.charAt(index2++) - '0';
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
            index1++;
            index2++;
        }
        return 0;
    }
}
