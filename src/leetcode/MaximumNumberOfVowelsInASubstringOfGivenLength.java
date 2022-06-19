package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {

  public int maxVowels(String s, int k) {
    int result = 0;
    Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

    int left = 0;
    int currVowels = 0;
    for (int right = 0; right < s.length(); right++) {
      if (vowels.contains(s.charAt(right))) {
        currVowels++;
      }

      if (right - left == k - 1) {
        result = Math.max(result, currVowels);
        currVowels = vowels.contains(s.charAt(left++)) ? currVowels - 1 : currVowels;
      }
    }

    return result;
  }

}
