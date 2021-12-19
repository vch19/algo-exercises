package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {

  public static String removeDuplicateLetters(String s) {
    int[] frequency = new int[26];

    for (Character ch : s.toCharArray()) {
      frequency[ch - 'a']++;
    }

    Deque<Character> stack = new ArrayDeque<>();
    //Contains element which currently in stack
    boolean[] visited = new boolean[26];

    for (Character ch : s.toCharArray()) {
      if (visited[ch - 'a']) {
        frequency[ch - 'a']--;
        continue;
      }

      while (!stack.isEmpty() && ch < stack.peek() && frequency[stack.peek() - 'a'] > 0) {
        visited[stack.peek() - 'a'] = false;
        stack.pop();
      }
      stack.push(ch);
      frequency[ch - 'a']--;
      visited[ch - 'a'] = true;
    }

    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.append(stack.pop());
    }

    return builder.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(removeDuplicateLetters("bcabc")); //abc
    System.out.println(removeDuplicateLetters("cbacdcbc")); //acdb
    System.out.println(removeDuplicateLetters("bbcaac")); //bac
  }
}
