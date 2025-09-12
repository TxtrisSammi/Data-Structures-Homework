public class Fibonacci {
    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Please enter n");
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 0; i < n; i++) {
            fibonacci(n - 1, arr);
            System.out.print("      " + arr[i]);
            if (i % 6 == 0 && i != 0) {
                System.out.println("");
            }
        }
    }
        public static int fibonacci(int i, int[] arr) {
        if (i < 2)
            return arr [i] = i;
        return arr [i] = fibonacci(i - 1 , arr) + fibonacci(i - 2, arr);
    }
}

