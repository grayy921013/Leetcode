import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/7/16.
 */
public class Problem56 {
    public List<Interval> merge(List<Interval> intervals) {
        //Method 1: insert one by one
        List<Interval> list = new ArrayList<>();
        if (intervals.size() == 0) return list;
//        for (Interval interval : intervals) {
//            insert(list, interval);
//        }
        //Method 2: sort and insert
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval : intervals) {
            if (interval.start > end) {
                list.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(interval.end, end);
            }
        }
        list.add(new Interval(start, end));
        return list;
    }



    //Method 1:
    private void insert(List<Interval> list, Interval interval) {
        int start = search(list, interval.start);
        int end = search(list, interval.end);
        if (start == end) {
            //remove entries from index start+.5f to end-.5f
            if (start < 0 || start % 2 == 0) {
                list.add(start / 2, interval);
            }
        } else {
            int removeFrom = start / 2;
            int removeTo = (end - 1) / 2;
            Interval interval1 = new Interval(Math.min(interval.start, list.get(removeFrom).start), Math.max(interval.end, list.get(removeTo).end));
            list.subList(removeFrom, removeTo + 1).clear();
            list.add(removeFrom, interval1);
        }
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

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        System.out.println(new Problem56().merge(list));
    }
}
