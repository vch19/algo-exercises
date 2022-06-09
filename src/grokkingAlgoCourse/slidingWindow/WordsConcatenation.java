package grokkingAlgoCourse.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsConcatenation {

  public static List<Integer> findWordConcatenation(String str, String[] words) {
    List<Integer> resultIndices = new ArrayList<>();
    Map<String, Integer> wordsFrequency = new HashMap<>();
    int wordLength = words.length;
    int wordsSize = words[0].length();

    for (int i = 0; i < str.length() - wordsSize * wordLength; i++) {
      Map<String, Integer> wordsSeen = new HashMap<>();
      for (int j = 0; j < wordLength; j++) {
        int nextWordsIndex = i + j * wordLength;
        String word = str.substring(nextWordsIndex, nextWordsIndex + wordsSize);
        if (!wordsFrequency.containsKey(word)) {
          break;
        }

        wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

        if (wordsSeen.get(word) > wordsFrequency.getOrDefault(word, 0)) {
          break;
        }

        if (j + 1 == wordLength) {
          resultIndices.add(i);
        }
      }
    }

    return resultIndices;
  }

  public static void main(String[] args) {
    System.out.println(findWordConcatenation("catfoxcat", new String[]{"cat", "fox"}));
  }
}
