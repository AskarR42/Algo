import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String right = expression.substring(0, i);
                String left = expression.substring(i + 1);
                List<Integer> rightAnswer = diffWaysToCompute(right);
                List<Integer> leftAnswer = diffWaysToCompute(left);
                for (Integer p1 : rightAnswer) {
                    for (Integer p2 : leftAnswer) {
                        int res = switch (c) {
                            case '+' -> p1 + p2;
                            case '-' -> p1 - p2;
                            case '*' -> p1 * p2;
                            default -> 0;
                        };
                        answer.add(res);
                    }
                }
            }
        }
        if (answer.isEmpty()) {
            answer.add(Integer.parseInt(expression));
        }
        return answer;
    }
}
