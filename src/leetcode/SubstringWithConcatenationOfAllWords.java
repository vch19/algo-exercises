package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

  public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> positions = new ArrayList<>();
    Map<String, Integer> freq = new HashMap<>();

    int wordLength = words[0].length();

    for (String word : words) {
      freq.put(word, freq.getOrDefault(word, 0) + 1);
    }

    int left = 0;
    int right = wordLength - 1;
    int countOfWords = freq.size();
    while (right < s.length()) {
      String substring = s.substring(left, right + 1);
      if (freq.containsKey(substring)) {
        freq.put(substring, freq.get(substring) - 1);
      }

      if (freq.containsKey(substring) && freq.get(substring) == 0) {
        countOfWords--;
      }

//      if (countOfWords == 0) {
//        positions.add()
//      }

//      if (freq.containsKey(s.substring(left, right + 1)) && positions.isEmpty()) {
//        positions.add(left);
//        left = right + 1;
//        right += wordLength + 1;
//      } else if (freq.containsKey(s.substring(left, right + 1))) {
//        left = right + 1;
//        right += wordLength + 1;
//      } else {
//        if (!positions.isEmpty()) {
//          int removed = positions.remove(positions.size() - 1);
//          freq.put(s.substring(left, removed), freq.getOrDefault(s.substring(left, right), 0) + 1);
//        }
//        right++;
//      }
    }

    return positions;
  }

  public static void main(String[] args) {
    System.out.println(findSubstring("barfoothefoobarman", new String[]{"bar", "foo"}));
  }
}
