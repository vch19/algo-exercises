package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsContainingAllThreeCharacters {

  public static int numberOfSubstrings(String s) {
    Map<Character, Integer> unique = new HashMap<>();
    int counter = 0;

    for (int right = 0; right < s.length(); right++) {
      char rightChar = s.charAt(right);
      unique.put(rightChar, unique.getOrDefault(rightChar, 0) + 1);

      if (unique.size() == 3) {
        counter++;
      }
    }

    for (int left = 0; left < s.length(); left++) {
      char leftChar = s.charAt(left);
      unique.put(leftChar, unique.get(leftChar) - 1);
      if (unique.get(leftChar) == 0) {
        unique.remove(leftChar);
      }
      if (unique.size() == 3) {
        counter++;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    System.out.println(numberOfSubstrings("abcabc"));//10
  }
}
