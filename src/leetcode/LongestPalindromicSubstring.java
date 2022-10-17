package leetcode;

public class LongestPalindromicSubstring {

  public static String longestPalindrome(String s) {
    int start = 0;
    int end = 0;

    int length = s.length();
    boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];

    for (int i = length - 1; i >= 0; i--) {
      for (int j = i; j < length; j++) {
        dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j - 1]);

        if (dp[i][j] && ((end - start + 1) < (j - i + 1))) {
          start = i;
          end = j;
        }
      }
    }

    return s.substring(start, end + 1);
  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
  }
}
