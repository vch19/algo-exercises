package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindromeByConcatenatingTwoLetterWords {

  public static int longestPalindrome(String[] words) {
    int length = 0;
    Map<String, Integer> p = new HashMap<>();

    for (int i = 0; i < words.length; i++) {
      if (p.containsKey(words[i])) {
        length += 4;
        if (p.get(words[i]) - 1 == 0) {
          p.remove(words[i]);
        } else {
          p.put(words[i], p.get(words[i]) - 1);
        }
      } else {
        p.put(getPalindrome(words[i]), p.getOrDefault(getPalindrome(words[i]), 0) + 1);
      }
    }

    for (Entry<String, Integer> entry : p.entrySet()) {
      if (isPalindrome(entry.getKey())) {
        return length + (2 * entry.getValue());
      }
    }

    return length;
  }

  private static String getPalindrome(String s) {
    return s.charAt(1) + "" + s.charAt(0);
  }

  private static boolean isPalindrome(String s) {
    return s.charAt(0) == s.charAt(1);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome(new String[]{"lc", "cl", "gg"}));//6
    System.out.println(longestPalindrome(new String[]{"ab"}));//0
    System.out.println(longestPalindrome(new String[]{"bb"}));//2
    System.out.println(longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"}));//8
    System.out.println(longestPalindrome(new String[]{"cc", "ll", "xx"}));//2
    System.out.println(longestPalindrome(
        new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd",
            "cc"}));//22
    System.out.println(longestPalindrome(new String[] {
        "qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"
    }));//14
  }
}
