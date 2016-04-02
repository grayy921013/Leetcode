/**
 * Created by Zhehui Zhou on 4/2/16.
 */
public class Problem204 {
    public int countPrimes(int n) {
        int count = n < 2 ? 0 : n - 2;
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Problem204().countPrimes(30));
    }
}
