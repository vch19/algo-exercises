package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubstringsOfSizeThreeWithDistinctCharacters {

  public static int countGoodSubstrings(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int counter = 0;

    int left = 0;
    for (int right = 0; right < s.length(); right++) {
      char ch = s.charAt(right);
      map.put(ch, map.getOrDefault(ch, 0) + 1);

      char leftCh = s.charAt(left);
      if (right - left == 2) {
        if (map.size() == 3) {
          counter++;
        }
        map.put(leftCh, map.get(leftCh) - 1);
        if (map.get(leftCh) == 0) {
          map.remove(leftCh);
        }
        left++;
      }
    }

    return counter;
  }

  public static int countGoodSubstringsMoreReadable(String s) {
    int count = 0;

    for (int i = 1; i < s.length() - 1; i++) {
      if (isValid(s, i)) {
        count++;
      }
    }

    return count;
  }

  private static boolean isValid(String str, int i) {
    return str.charAt(i - 1) != str.charAt(i) &&
        str.charAt(i - 1) != str.charAt(i + 1) &&
        str.charAt(i) != str.charAt(i + 1);
  }

  public static void main(String[] args) {
    System.out.println(countGoodSubstringsMoreReadable("xyzzaz"));//1
    System.out.println(countGoodSubstringsMoreReadable("aababcabc"));//4
  }
}
