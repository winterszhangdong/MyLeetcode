package problems;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        String s = ")()())";
        System.out.println(lvp.solution(s));
    }
    public int solution(String s) {
        Stack<String> stack = new Stack<String>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.substring(i, i+1).equals("(")) {
                stack.push(s.substring(i, i+1));
            } else if (!stack.isEmpty()) {
                stack.pop();
                result += 2;
            }
        }
        return result;
    }
}
