import java.util.Scanner;

public class Eratosthenes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        if (args.length < 1) {
            System.out.print("please provide n: ");
            input = scan.nextLine();
        } else {
            input = args[0];
        }

        double startTime = System.nanoTime();
        int n = Integer.parseInt(input);
        boolean[] places = new boolean[n];
        for (int i = 2; i < Math.sqrt(places.length); i++) {
            for (int j = i + i; j < places.length; j+= i) {
                if (j % i == 0) {
                    places[j] = true;

                }
            }
        }
        double duration = System.nanoTime() - startTime;
        duration = duration / Math.pow(10, 9);
        System.out.println("Time to run: " + duration + " seconds");
        int count = 0;
        for (int i = places.length - 1; count < 5; i--) {
            if (!places[i]) {
                System.out.printf("%d ", i);
                count++;
            }
        }
        scan.close();
    }
}
