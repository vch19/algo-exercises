package leetcode;

import java.util.Arrays;

public class LongestIdealSubsequence {

  //Idea from LIS problem
  //Time complexity O(n^2), space: O(n)
  public static int longestIdealSubsequence(String s, int k) {
    int longest = 0;

    int[] dp = new int[s.length()];
    Arrays.fill(dp, 1);

    for (int i = 1; i < s.length(); i++) {
      for (int j = 0; j < i; j++) {
        int difference = Math.abs((s.charAt(i) - 'a' + 1) - (s.charAt(j) - 'a' + 1));
        if (difference <= k) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          longest = Math.max(longest, dp[i]);
        }
      }
    }
    return longest;
  }

  public static int longestIdealSubsequenceOptimal(String s, int k) {
    int longest = 0;

    int[] dp = new int[26];

    for (int j = 0; j < s.length(); j++) {
      int i = s.charAt(j) - 'a';
      dp[i]++;

      for (int n = Math.max(0, i - k); n <= Math.min(25, i + k); n++) {
        if (i != n) {
          dp[i] = Math.max(dp[i], dp[n] + 1);
        }
      }
      longest = Math.max(dp[i], longest);
    }

    return longest;
  }

  public static void main(String[] args) {
    System.out.println(longestIdealSubsequence("acfgbd", 2));//4
  }

}
