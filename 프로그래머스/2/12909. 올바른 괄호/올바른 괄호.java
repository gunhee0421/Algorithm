import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i + 1).equals("(")) {
                stack.push(s.substring(i, i + 1));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}