import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Zhehui Zhou on 4/19/16.
 */
public class Problem313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] indexes = new int[primes.length];
        PriorityQueue<Integer> next = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return ugly[indexes[o1]] * primes[o1] - ugly[indexes[o2]] * primes[o2];
            }
        });
        for(int i = 0; i < primes.length; i++) {
            next.offer(i);
        }
        for(int i = 1; i < n; i++) {
            int num;
            do {
                int index = next.poll();
                num = ugly[indexes[index]] * primes[index];
                indexes[index]++;
                ugly[i] = num;
                next.offer(index);
            } while(ugly[indexes[next.peek()]] * primes[next.peek()] == num);
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem313().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
