package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

  private int maxLength = 0;

  public int maxLength(List<String> words) {
    Map<Character, Integer> freq = new HashMap<>();
    for (int i = 0; i < words.size(); i++) {
      recursion(i, words, freq);
    }
    return maxLength;
  }

  private void recursion(int j, List<String> words, Map<Character, Integer> freq) {
    String word = words.get(j);

    if (!isUnique(word, freq)) {
      return;
    }

    for (int i = 0; i < word.length(); i++) {
      freq.put(word.charAt(i), 1);
    }

    maxLength = Math.max(maxLength, freq.size());

    for (int i = j + 1; i < words.size(); i++) {
      recursion(i, words, freq);
    }

    for (int k = 0; k < word.length(); k++) {
      freq.remove(word.charAt(k));
    }
  }

  private boolean isUnique(String word, Map<Character, Integer> freq) {
    Set<Character> characterSet = new HashSet<>();

    for (Character ch : word.toCharArray()) {
      if (characterSet.contains(ch)) {
        return false;
      }
      characterSet.add(ch);
    }

    for (Character ch : word.toCharArray()) {
      if (freq.containsKey(ch)) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(new MaximumLengthOfAConcatenatedStringWithUniqueCharacters()
        .maxLength(List.of("cha", "r", "act", "ers"))); //6
    System.out.println(new MaximumLengthOfAConcatenatedStringWithUniqueCharacters()
        .maxLength(List.of("aa", "bb"))); //2
    System.out.println(new MaximumLengthOfAConcatenatedStringWithUniqueCharacters()
        .maxLength(List.of("a", "abc", "d", "de", "def"))); //6
  }
}
