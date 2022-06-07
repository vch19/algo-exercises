package grokkingAlgoCourse.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInAString {

  public static boolean findPermutation(String string, String pattern) {
    Map<Character, Integer> freq = new HashMap<>();

    for (Character ch : pattern.toCharArray()) {
      freq.put(ch, freq.getOrDefault(ch, 0) + 1);
    }

    int matchedLetters = 0;
    int left = 0;

    for (int right = 0; right < string.length(); right++) {
      Character rightCharacter = string.charAt(right);
      if (freq.containsKey(rightCharacter)) {
        freq.put(rightCharacter, freq.getOrDefault(rightCharacter, 0) - 1);
        if (freq.get(rightCharacter) == 0) {
          matchedLetters++;
        }
      }

      if (matchedLetters == freq.size()) {
        return true;
      }

      if (right >= pattern.length() - 1) {
        Character leftCharacter = string.charAt(left++);
        if (freq.containsKey(leftCharacter)) {
          if (freq.get(leftCharacter) == 0) {
            matchedLetters--;
          }
          freq.put(leftCharacter, freq.get(leftCharacter) + 1);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(findPermutation("oidbcaf", "abc"));//true
    System.out.println(findPermutation("odicf", "dc"));//false
    System.out.println(findPermutation("ooolleoooleh", "hello"));//false
    System.out.println(findPermutation("eidbaooo", "ab"));//true
    System.out.println(findPermutation("eidboaoo", "ab"));//false
    System.out.println(findPermutation("lznomzggwrvrkxecjaq", "rvwrk"));//true
  }
}
