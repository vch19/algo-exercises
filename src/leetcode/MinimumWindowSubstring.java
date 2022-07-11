package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

  //Time complexity: O(s.length + t.length)
  //Space complexity: O(t.length)
  public static String minWindow(String s, String t) {
    int minWindow = Integer.MAX_VALUE;
    String result = "";

    Map<Character, Integer> freq = new HashMap<>();
    for (Character ch : t.toCharArray()) {
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }

    int unique = freq.size();
    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      Character rightCh = s.charAt(right);
      if (freq.containsKey(rightCh)) {
        freq.put(rightCh, freq.get(rightCh) - 1);
      }

      if (freq.containsKey(rightCh) && freq.get(rightCh) == 0) {
        unique--;
      }

      while (unique == 0) {
        Character leftCh = s.charAt(left);

        if (freq.containsKey(leftCh)) {
          freq.put(leftCh, freq.get(leftCh) + 1);
        }

        if (freq.containsKey(leftCh) && freq.get(leftCh) == 1) {
          unique++;
        }

        if (right - left + 1 < minWindow) {
          result = s.substring(left, right + 1);
          minWindow = Math.min(minWindow, right - left + 1);
        }

        left++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(minWindow("ADOBECODEBANC", "ABC")); //BANC -> 4
    System.out.println(minWindow("a", "aa")); //empty -> 0
    System.out.println(minWindow("a", "a")); //'a' -> 1
  }
}
