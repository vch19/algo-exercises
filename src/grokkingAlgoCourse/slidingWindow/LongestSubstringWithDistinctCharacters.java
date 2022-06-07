package grokkingAlgoCourse.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {

  public static int findLength(String str) {
    int maxLength = 0;
    Set<Character> characters = new HashSet<>();

    int a = 0;
    int b = 0;

    while (b < str.length()) {
      if (a == b && b + 1 < str.length() && str.charAt(b) == str.charAt(b + 1)) {
        a++;
        b++;
      } else if (characters.contains(str.charAt(b))) {
        maxLength = Math.max(maxLength, characters.size());
        characters.remove(str.charAt(a));
        a++;
      } else {
        characters.add(str.charAt(b));
        b++;
      }
    }

    return Math.max(maxLength, b - a);
  }

  public static void main(String[] args) {
    System.out.println(findLength("aabccbb"));//3
    System.out.println(findLength("abbbb"));//2
    System.out.println(findLength("abccde"));//3
    System.out.println(findLength("abcabcbb"));//3
  }

}
