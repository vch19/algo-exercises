package leetcode;

public class MinimumASCIIDeleteSumForTwoStrings {

  public static int minimumDeleteSum(String s1, String s2) {
    String lcs = lcs(s1, s2);

    return -1;
  }

  private static String lcs(String s1, String s2) {
    String[][] dp = new String[s1.length() + 1][s2.length() + 1];

    for (int i = 1; i <= s1.length(); i++) {
      for (int j = 1; j <= s2.length(); j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = getString(dp[i - 1][j - 1]) + s1.charAt(i - 1);
        } else {
          dp[i][j] = getLength(dp[i - 1][j]) > getLength(dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  private static int getLength(String s) {
    if (s == null) {
      return 0;
    }

    return s.length();
  }

  private static String getString(String str) {
    if (str == null) {
      return "";
    }
    return str;
  }

  public static void main(String[] args) {
//    System.out.println(minimumDeleteSum("delete", "leet"));
    System.out.println((int)'a');
  }
}
