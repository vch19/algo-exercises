package leetcode;

import java.util.Stack;

public class ReverseParentheses {

    public static String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        stack.add(new StringBuilder());

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.add(new StringBuilder());
            } else if (Character.isLetter(ch)) {
                stack.peek().append(ch);
            } else {
                StringBuilder top = stack.peek().reverse();
                stack.peek().append(top);
            }
        }

        return stack.peek().toString();
    }
}
