package leetcode;

import java.util.Arrays;

/**
 * 279. Perfect Squares
 */
public class PerfectSquares {

  public static int numSquares(int n) {
    int max = (int) Math.round(Math.sqrt(n));

    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j <= max; j++) {
        if (i >= j * j) {
          dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numSquares(1));//1
    System.out.println(numSquares(12));//3
    System.out.println(numSquares(13));//2
  }
}
