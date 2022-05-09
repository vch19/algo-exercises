package leetcode;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character. Note that after backspacing an empty text, the text will continue
 * empty.
 */
public class BackspaceStringCompare {

  public boolean backspaceCompare(String S, String T) {
    return build(S).equals(build(T));
  }

  private String build(String str) {
    Stack<Character> stack = new Stack<>();

    for (char ch : str.toCharArray()) {
      if (ch != '#') {
        stack.push(ch);
      } else if (!stack.isEmpty()) {
        stack.pop();
      }
    }
    return String.valueOf(stack);
  }

  public static void main(String[] args) {
    new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c");
  }
}
