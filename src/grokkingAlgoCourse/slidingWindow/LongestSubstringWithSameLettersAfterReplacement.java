package grokkingAlgoCourse.slidingWindow;

public class LongestSubstringWithSameLettersAfterReplacement {

  public static int findLength(String str, int k) {
    int max = 0;

    int[] frequency = new int[26];
    int maxFrequency = 0;

    int a = 0;
    int b = 0;

    while (b < str.length()) {
      if (Math.abs(b - a - maxFrequency) <= k) {
        max = Math.max(max, b - a);
        maxFrequency = Math.max(maxFrequency, ++frequency[str.charAt(b) - 'a']);
        b++;
      } else {
        frequency[str.charAt(a) - 'a']--;
        a++;
      }
    }

    return Math.abs(b - a - maxFrequency) <= k ? Math.max(max, b - a) : max;
  }

  public static void main(String[] args) {
    System.out.println(findLength("aabccbb", 2)); //5
    System.out.println(findLength("abccde", 1)); //3
  }
}
