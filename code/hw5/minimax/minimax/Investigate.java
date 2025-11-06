public class Investigate extends Test{
    public static void main(String[] args) {
        Minimax model = new Minimax(3);
        System.out.println(model.root);
        int minWins = DFS(model.root, -1);
        int draws = DFS(model.root, 0);
        int maxWins = DFS(model.root, 1);

        System.out.println("draws: " + draws);
        System.out.println("maxWins: " + maxWins);
        System.out.println("minWins: " + minWins);
    }
}
