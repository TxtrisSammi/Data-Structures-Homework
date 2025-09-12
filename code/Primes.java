import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Primes {
    public static void main(String[] args) {
        double startTime = System.nanoTime();
        byte[] bytes = getFileBytes("half_gaps.bin");

        double duration = System.nanoTime() - startTime;
        long[] output = getPrimes(bytes);
        duration = duration / Math.pow(10, 9);

        System.out.println("Time to run: " + duration + " seconds");
        for (int i = 0; i < 15; i++) {
            System.out.println(output[i]);
        }

        for (int i = output.length - 5; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }

    public static byte[] getFileBytes(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static long[] getPrimes(byte[] bytes) {
        int[] gaps = new int[bytes.length];
        long[] output = new long[gaps.length + 2];

        for (int i = 0; i < bytes.length; i++) {
            gaps[i] = Byte.toUnsignedInt(bytes[i]);
            if (i > 0) {
                gaps[i] = gaps[i] + gaps[i - 1];
            }
        }

        for (int i = 2; i < gaps.length + 2; i++) {
            output[i] = (Long.valueOf(gaps[i - 2])) * 2 + 3;
        }
        output[0] = 2;
        output[1] = 3;
        return output;
    }

}