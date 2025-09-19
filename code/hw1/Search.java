import java.util.Random;

public class Search extends Primes{
    public static void main(String[] args) {
        Random random = new Random();
        double start = System.nanoTime();
        double favourable = 0;
        byte[] bytes = getFileBytes("half_gaps.bin");
        long[] primes = getPrimes(bytes);
        int sampleSize = 1000000;

        for (int i = 1; i < sampleSize; i++) {
            long x = random.nextInt(1, Integer.MAX_VALUE);
            x += 1;
            // favourable += linearSearch(x, primes) ? 1.0 : 0.0;
            favourable += binarySearch(x, primes, 0, primes.length - 1) ? 1.0 : 0.0;
            System.out.println(favourable / i);
        }

        // System.out.println(favourable / sampleSize);
        double duration = (System.nanoTime() - start) / Math.pow(10, 9);
        System.out.printf("Time taken: %.2f seconds%n", duration);
    } 

    public static boolean linearSearch(long x, long[] primes) {
        for (int i = 0; primes[i] <= x; i++){
            if (x == primes[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(long x, long[] primes, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (primes[mid] == x) {
                return true;
            } else if (primes[mid] < x) {
                low = mid + 1;
            } else if (primes[mid] > x) {
                high = mid - 1;
            }
        }
        return false;
    }
}
