import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Zhehui Zhou on 4/14/16.
 */
public class Problem295 {
    PriorityQueue<Integer> p2 = new PriorityQueue<>();
    PriorityQueue<Integer> p1 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }); //p2 the largest element will be on the top
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (p1.isEmpty() && p2.isEmpty()) p1.offer(num);
        else if (num >= p1.peek()) p2.offer(num);
        else p1.offer(num);
        if (p1.size() < p2.size()) {
            p1.offer(p2.poll());
        } else if (p1.size() > p2.size() + 1) {
            p2.offer(p1.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if((p1.size() + p2.size()) % 2 == 1) return p1.peek();
        else return (double)(p1.peek() + p2.peek()) / 2;
    }

    public static void main(String[] args) {
        Problem295 problem295 = new Problem295();
        problem295.addNum(1);
        problem295.addNum(2);
        System.out.println(problem295.findMedian());
        problem295.addNum(3);
        System.out.println(problem295.findMedian());
    }
}
