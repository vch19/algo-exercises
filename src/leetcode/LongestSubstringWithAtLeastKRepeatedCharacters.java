package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestSubstringWithAtLeastKRepeatedCharacters {

  public static int longestSubstring(String s, int k) {
    int maxLength = 0;
    int totalUniqueLetters = getTotalUniqueLetters(s);
    Map<Character, Integer> lettersFrequency = new HashMap<>();

    for (int currentMaxUniqueLetters = 1; currentMaxUniqueLetters <= totalUniqueLetters;
        currentMaxUniqueLetters++) {
      int uniqueLetters = 0;
      int atLeastK = 0;
      int left = 0;

      for (int right = 0; right < s.length(); right++) {
        if (uniqueLetters <= currentMaxUniqueLetters) {
          Character rCh = s.charAt(right);
          if (!lettersFrequency.containsKey(rCh)) {
            lettersFrequency.put(rCh, 0);
            uniqueLetters++;
          }
          lettersFrequency.put(rCh, lettersFrequency.get(rCh) + 1);

          if (lettersFrequency.get(rCh) == k) {
            atLeastK++;
          }
        }

        while (uniqueLetters > currentMaxUniqueLetters) {
          Character lCh = s.charAt(left++);
          if (lettersFrequency.get(lCh) == k) {
            atLeastK--;
          }

          lettersFrequency.put(lCh, lettersFrequency.get(lCh) - 1);
          if (lettersFrequency.get(lCh) == 0) {
            lettersFrequency.remove(lCh);
            uniqueLetters--;
          }
        }

        if (uniqueLetters == currentMaxUniqueLetters && uniqueLetters == atLeastK) {
          maxLength = Math.max(maxLength, right - left + 1);
        }
      }
      lettersFrequency.clear();
    }

    return maxLength;
  }

  private static int getTotalUniqueLetters(String s) {
    return s.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet()).size();
  }

  public static void main(String[] args) {
//    System.out.println(longestSubstring("ababbc", 2));//5
//    System.out.println(longestSubstring("aaabbb", 3));//6
//    System.out.println(longestSubstring("aaaaaaaaabbbcccccddddd", 5));//10
    System.out.println(longestSubstring("aaabbb", 3));//10
  }
}
