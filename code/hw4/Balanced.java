public class Balanced {
    public static void main(String[] args) {
        double balanced = 0;
        double count = 1000000;
        for (int i = 0; i < count; i++) {
            String s = "";
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < 6; j++) {
                s += (Math.random() > 0.5) ? "(" : ")";
                if (!stack.isEmpty() && s.charAt(j) == ')' && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }
            }
            if (stack.isEmpty()) {
                balanced++;
            }
            // System.out.println(balanced / (i + 1));
        }
        System.out.println(balanced / count);
    }
}

