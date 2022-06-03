package grokkingAlgoCourse;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithMaximumKDistinctCharacters {

  public static int findLength(String str, int k) {
    int max = 0;

    Map<Character, Integer> frequency = new HashMap<>();
    int a = 0;
    int b = 0;

    while (b < str.length()) {
      if (!frequency.containsKey(str.charAt(b)) && frequency.size() == k) {
        max = Math.max(max, b - a);
        //remove element if it's occurs zero time.
        frequency.put(str.charAt(a), frequency.get(str.charAt(a)) - 1);
        if (frequency.get(str.charAt(a)) == 0) {
          frequency.remove(str.charAt(a));
        }
        a++;
      } else {
        frequency.put(str.charAt(b), frequency.getOrDefault(str.charAt(b), 0) + 1);
        b++;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(findLength("araaci", 2)); //4
    System.out.println(findLength("araaci", 1)); //2
    System.out.println(findLength("cbbebi", 3)); //5
  }
}
