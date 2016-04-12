/**
 * Created by Zhehui Zhou on 4/12/16.
 */
public class Problem275 {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int start = 0, end = citations.length - 1;
        int hIndex = 0;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(citations[mid] == citations.length - mid) return citations[mid];
            else if (citations[mid] < citations.length - mid) start = mid + 1;
            else end = mid - 1;
        }
        return citations.length - end - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem275().hIndex(new int[]{0,1}));
    }
}
