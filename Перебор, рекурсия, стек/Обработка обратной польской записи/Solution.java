import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operations = new HashSet<>();
        operations.add("+");
        operations.add("-");
        operations.add("*");
        operations.add("/");

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (operations.contains(token)) {
                int secondOperand = stack.pollLast();
                int firstOperand = stack.pollLast();
                switch (token) {
                    case "+" -> stack.addLast(firstOperand + secondOperand);
                    case "-" -> stack.addLast(firstOperand - secondOperand);
                    case "*" -> stack.addLast(firstOperand * secondOperand);
                    case "/" -> stack.addLast(firstOperand / secondOperand);
                }
            } else {
                stack.addLast(Integer.parseInt(token));
            }
        }
        
        return stack.pollLast();
    }
}
