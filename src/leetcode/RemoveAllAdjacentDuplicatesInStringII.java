package leetcode;

import java.util.Stack;

class Pair {

  public char ch;
  public int occurrences;

  private Pair(char ch, int occurrences) {
    this.ch = ch;
    this.occurrences = occurrences;
  }

  public static Pair of(char ch, int occurrences) {
    return new Pair(ch, occurrences);
  }
}

public class RemoveAllAdjacentDuplicatesInStringII {

  public static String removeDuplicates(String s, int k) {
    Stack<Pair> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);

      if (stack.isEmpty() || currentChar != stack.peek().ch) {
        stack.push(Pair.of(currentChar, 1));
      } else if (currentChar == stack.peek().ch) {
        stack.peek().occurrences++;
      }

      if (!stack.isEmpty() && stack.peek().occurrences == k) {
        stack.pop();
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      Pair pair = stack.pop();
      while (pair.occurrences != 0) {
        sb.insert(0, pair.ch);
        pair.occurrences--;
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicates("deeedbbcccbdaa", 3)); //aa
    System.out.println(removeDuplicates("abcd", 2)); //abcd
  }
}
