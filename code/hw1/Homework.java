import java.util.Scanner;

public class Homework {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        
        boolean [] toSort = new boolean[n];
        eratosthenes(toSort);
        System.out.println("n: " + n);
        scan.close();
    }

    public static int conditionalWork(int n) {
        int seconds = 0;
        for (int i = 0; i < n; i++) {
            if (Math.random() < 0.5) {
                seconds += 4;
                // System.out.println("TASK A");
            } else {
                seconds += 20;
                // System.out.println("TASK B");
            }
        }
        System.out.println(Integer.MIN_VALUE);
        // System.out.println(String.valueOf(seconds).length());
        return seconds;
    }

    public static void sortIntegers(int[] toSort) {
        int i = 0, j = 0, k = 0, max = Integer.MIN_VALUE;

        for (i = 0; i < toSort.length; i++) {
            max = toSort[i] > max ? toSort[i] : max;
            System.out.println("max");
        }

        int[] counts = new int[max + 1];
        System.out.println("counts");

        for (i = 0; i < toSort.length; i++) {
            counts[toSort[i]]++;
            System.out.println("i");
        }

        for (i = 0; i < counts.length; i++) {
            for (j = 0; j < counts[i]; j++) {
                toSort[k++] = i;
                System.out.println("k");
            }
        }
        System.out.println("Total");
        System.out.println("i: " + i);
        System.out.println("j: " + j);
        System.out.println("k: " + k);
        
    }

    public static void eratosthenes(boolean[] toSieve) {
        toSieve[0] = true;
        toSieve[1] = true;
        int counts = 0;
        int loop1 = 0;
        int loop2 = 0;
        for (int i = 2; i < Math.sqrt(toSieve.length); i++){
            // System.out.println("loop 1");
            loop1 ++;
            counts ++;
            if (!toSieve[i]) {
                System.out.println(i);
                for (int j = i*i; j < toSieve.length; j += i){
                    // System.out.println("loop 2");
                    loop2 ++;
                    counts ++;
                    toSieve[j] = true;
                }
            }
        }
        System.out.println("counts: " + counts);
        System.out.println("loop1: " + loop1);
        System.out.println("loop2: " + loop2);
        
    }
}
