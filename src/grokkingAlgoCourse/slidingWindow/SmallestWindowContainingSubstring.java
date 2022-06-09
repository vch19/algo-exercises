package grokkingAlgoCourse.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {

  public static String findSubstring(String str, String pattern) {
    Map<Character, Integer> frequency = new HashMap<>();
    for (Character ch : pattern.toCharArray()) {
      frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }

    int left = 0;
    int matched = 0;

    String result = "";

    for (int right = 0; right < str.length(); right++) {
      Character rCh = str.charAt(right);
      if (frequency.containsKey(rCh)) {
        frequency.put(rCh, frequency.get(rCh) - 1);
        if (frequency.get(rCh) == 0) {
          matched++;
        }
      }

      while (matched == frequency.size()) {
        Character lCh = str.charAt(left);
        if (frequency.containsKey(lCh)) {
          frequency.put(lCh, frequency.get(lCh) + 1);
          if (frequency.get(lCh) > 0) {
            matched--;
          }
        }

        String substring = str.substring(left++, right + 1);
        if (result.equals("") || substring.length() < result.length()) {
          result = substring;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(findSubstring("aabdec", "abc"));//abdec
    System.out.println(findSubstring("aabdec", "abac"));//aabdec
    System.out.println(findSubstring("abdbca", "abc"));//bca
    System.out.println(findSubstring("a", "a"));//a
  }
}
