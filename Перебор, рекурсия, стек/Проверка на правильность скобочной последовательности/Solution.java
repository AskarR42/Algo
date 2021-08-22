import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.addLast(bracket);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char prevBracket = stack.pollLast();
                if (prevBracket == '(' && bracket != ')' || prevBracket == '{' && bracket != '}' || prevBracket == '[' && bracket != ']') {
                    return false;
                }
            }
        }
        
        return stack.size() == 0;
    }
}
