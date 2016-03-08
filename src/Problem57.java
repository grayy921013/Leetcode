import java.util.List;

/**
 * Created by Zhehui Zhou on 3/8/16.
 */
public class Problem57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = search(intervals, newInterval.start);
        int end = search(intervals, newInterval.end);
        if (start == end) {
            //remove entries from index start+.5f to end-.5f
            if (start < 0 || start % 2 == 0) {
                intervals.add(start / 2, newInterval);
            }
        } else {
            int removeFrom = start / 2;
            int removeTo = (end - 1) / 2;
            Interval interval1 = new Interval(Math.min(newInterval.start, intervals.get(removeFrom).start), Math.max(newInterval.end, intervals.get(removeTo).end));
            intervals.subList(removeFrom, removeTo + 1).clear();
            intervals.add(removeFrom, interval1);
        }
        return intervals;
    }

    private int search(List<Interval> list, int value) {
        //if intersect with interval i, then return 2i + 1, if between i - 1 and i, return 2i + 2
        int start = 0, end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (value >= list.get(mid).start && value <= list.get(mid).end) return mid * 2 + 1;
            else if (start == end) return value > list.get(mid).start ? mid * 2 + 2 : mid * 2;
            else if (value < list.get(mid).start) end = mid - 1;
            else start = mid + 1;
            if (end == start - 1) return start * 2;
        }
        return -1;
    }
}
