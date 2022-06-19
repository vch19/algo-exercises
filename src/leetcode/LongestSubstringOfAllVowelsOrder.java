package leetcode;

public class LongestSubstringOfAllVowelsOrder {

  public static int longestBeautifulSubstring(String word) {
    int length = 0;
    int left = 0;
    int unique = 1;

    for (int right = 1; right < word.length(); right++) {
      if (word.charAt(right - 1) > word.charAt(right)) {
        unique = 1;
        left = right;
      } else if (word.charAt(right - 1) < word.charAt(right)) {
        unique++;
      }

      if (unique == 5) {
        length = Math.max(length, right - left + 1);
      }
    }

    return length;
  }

  public static void main(String[] args) {
    System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu")); //13
  }
}
