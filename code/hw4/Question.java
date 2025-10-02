import java.util.Scanner;

public class Question implements Comparable<Question> {
    public static void main(String[] args) {
        BinaryHeap<Question> heap = new BinaryHeap<Question>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                heap.add(new Question(i + 2, j + 2));
            }
        }

        while (true) {
            System.out.println(heap);
            Question current = heap.extract();
            current.ask();
            heap.add(current);
        }
    }
    public Scanner scan = new Scanner(System.in);
    public String statement;
    public String answer;
    public long duration;
    public long missed;

    public Question(int a, int b) {
        statement = String.format("%d x %d = ?", a, b);
        answer = String.format("%d", a * b);
        duration = 0;
        missed = 5;
    }

    public void ask() {
        // long start = System.nanoTime();
        System.out.printf("%s ", statement);
        String given = scan.next().trim();
        // duration += System.nanoTime() - start;
        missed += given.equals(answer) ? -1 : 1;
        // scan.close();

    }

    public int compareTo(Question other) {
        return -1 * Long.compare(this.key(), other.key());
    }

    public String toString() {
        return String.format("%d: %s", this.key(), statement);
    }

    public long key() {
        return missed;
    }
}