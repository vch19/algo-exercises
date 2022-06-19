package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubstringWithAtLeastKRepeatedCharacters {

  //Time complexity: O(n * uniqueCharacters)
  //Todo: add to ankee
  public static int longestSubstring(String s, int k) {
    int max = 0;
    int totalUniqueCharacters = uniqueCharacters(s);
    Map<Character, Integer> freq = new HashMap<>();

    for (int currentMaxUnique = 1; currentMaxUnique <= totalUniqueCharacters; currentMaxUnique++) {
      int left = 0;
      int right = 0;
      int unique = 0;
      int countAtLeastK = 0;

      while (right < s.length()) {
        Character rCh = s.charAt(right);
        if (unique <= currentMaxUnique) {
          if (freq.getOrDefault(rCh, 0) == 0) {
            unique++;
            freq.put(rCh, freq.getOrDefault(rCh, 0) + 1);
          } else {
            freq.put(rCh, freq.getOrDefault(rCh, 0) + 1);
          }

          if (freq.getOrDefault(rCh, 0) == k) {
            countAtLeastK++;
          }
          right++;
        } else {
          Character lCh = s.charAt(left);
          if (freq.get(lCh) == k) {
            countAtLeastK--;
          }
          freq.computeIfPresent(lCh, (key, v) -> v - 1);
          if (freq.get(lCh) == 0) {
            freq.remove(lCh);
            unique--;
          }
          left++;
        }

        if (unique == currentMaxUnique && unique == countAtLeastK) {
          max = Math.max(max, right - left);
        }
      }
      freq.clear();
    }

    return max;
  }

  private static int uniqueCharacters(String str) {
    return str.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet()).size();
  }

  public static void main(String[] args) {
//    System.out.println(longestSubstring("ababbc", 2));//5
//    System.out.println(longestSubstring("aaabbb", 3));//6
    System.out.println(longestSubstring("aaaaaaaaabbbcccccddddd", 5));//10
  }
}
