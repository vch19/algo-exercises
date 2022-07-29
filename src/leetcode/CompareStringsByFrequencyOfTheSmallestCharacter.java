package leetcode;

import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter {

  public static int[] numSmallerByFrequency(String[] queries, String[] words) {
    int[] result = new int[queries.length];

    int[] wordsFrequency = new int[words.length];

    for (int i = 0; i < words.length; i++) {
      wordsFrequency[i] = getFreq(words[i]);
    }

    Arrays.sort(wordsFrequency);

    for (int i = 0; i < queries.length; i++) {
      int left = 0;
      int right = wordsFrequency.length - 1;

      while (left <= right) {
        int middle = left + (right - left) / 2;
        if (wordsFrequency[middle] <= getFreq(queries[i])) {
          left = middle + 1;
        } else {
          right = middle - 1;
        }
      }

      result[i] = wordsFrequency.length - left;
    }

    return result;
  }

  private static int getFreq(String word) {
    int[] frequency = new int[26];
    int minIndex = Integer.MAX_VALUE;
    for (char ch : word.toCharArray()) {
      if (ch - 'a' < minIndex) {
        minIndex = ch - 'a';
      }
      frequency[ch - 'a']++;
    }

    return frequency[minIndex];
  }


  public static void main(String[] args) {
//    System.out.println(Arrays.toString(
//        numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"})));

    System.out.println(Arrays.toString(
        numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"})));
  }

}
