package grokkingAlgoCourse.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<>();
    Map<Character, Integer> frequency = new HashMap<>();

    for (Character ch : pattern.toCharArray()) {
      frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
    }

    int left = 0;
    int matched = 0;

    for (int right = 0; right < str.length(); right++) {
      Character rightCh = str.charAt(right);
      if (frequency.containsKey(rightCh)) {
        frequency.put(rightCh, frequency.getOrDefault(rightCh, 0) - 1);
        if (frequency.get(rightCh) == 0) {
          matched++;
        }
      }

      if (matched == frequency.size()) {
        resultIndices.add(left);
      }

      if (right >= pattern.length() - 1) {
        Character leftCh = str.charAt(left++);
        if (frequency.containsKey(leftCh)) {
          if (frequency.get(leftCh) == 0) {
            matched--;
          }
          frequency.put(leftCh, frequency.get(leftCh) + 1);
        }
      }
    }

    return resultIndices;
  }

  public static void main(String[] args) {
    System.out.println(findStringAnagrams("ppqp", "pq")); //[1, 2]
    System.out.println(findStringAnagrams("abbcabc", "abc"));//[2, 3, 4]
    System.out.println(findStringAnagrams("cbaebabacd", "abc"));//[0, 6]
  }
}
