/**
 * Created by Zhehui Zhou on 3/7/16.
 */
public class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                + start +
                ", " + end +
                '}';
    }
}
