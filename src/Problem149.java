import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Zhehui Zhou on 3/29/16.
 */
public class Problem149 {
    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int max = 2;
        Arrays.sort(points, 0, points.length, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x != o2.x ? o1.x - o2.x : o1.y - o2.y;
            }
        });
        int i = 0;
        while (i < points.length) {
            double[] slopes = new double[points.length - i - 1];
            for (int j = i + 1; j < points.length; j++) {
                //compute all slopes for all point j to point i
                slopes[j - i - 1] = slopeTo(points[i], points[j]);
            }
            int nanCount = 0;
            for (int j = 0; j < slopes.length; j++) {
                if (Double.isNaN(slopes[j])) {
                    double temp = slopes[nanCount];
                    slopes[nanCount] = slopes[j];
                    slopes[j] = temp;
                    nanCount++;
                }
            }
            if (nanCount < slopes.length) {
                Arrays.sort(slopes, nanCount, slopes.length);
                double prev = slopes[nanCount];
                int count = 2;
                for (int k = nanCount + 1; k < slopes.length; k++) {
                    if (slopes[k] == prev) count++;
                    else {
                        prev = slopes[k];
                        if (count + nanCount > max) max = count + nanCount;
                        count = 2;
                    }
                }
                if (count + nanCount > max) max = count + nanCount;
            } else {
                if (nanCount + 1 > max) max = nanCount + 1;
            }
            while(i + 1 < points.length && points[i + 1] == points[i]) i++;
            i++;
        }
        return max;
    }

    private double slopeTo(Point a, Point b) {
        return (double) (a.y - b.y) / (a.x - b.x);
    }


    public static void main(String[] args) {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(-1, -1);
        Point point3 = new Point(2, 2);
        Point point4 = new Point(9, -25);
        System.out.println(new Problem149().maxPoints(new Point[]{point1, point2, point3}));
    }
}
