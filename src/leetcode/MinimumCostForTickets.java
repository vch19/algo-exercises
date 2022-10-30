package leetcode;

import java.util.Arrays;

/**
 * 983. Minimum Cost For Tickets
 */
public class MinimumCostForTickets {

  public static int minCostTickets(int[] days, int[] costs) {
    int[] dp = new int[days[days.length - 1] + 1];
    int n = dp.length;
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    int j = 0;

    for (int i = 1; i < n; i++) {
      if (i == days[j]) {
        dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);

        if (i + 6 < n) {
          dp[i + 6] = Math.min(dp[i + 6], dp[i - 1] + costs[1]);
        } else {
          dp[n - 1] = Math.min(dp[n - 1], dp[i - 1] + costs[1]);
        }

        if (i + 29 < n) {
          dp[i + 29] = Math.min(dp[i + 29], dp[i - 1] + costs[2]);
        } else {
          dp[n - 1] = Math.min(dp[n - 1], dp[i - 1] + costs[2]);
        }
        j++;
      } else {
        dp[i] = Math.min(dp[i], dp[i - 1]);
      }
    }

    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    System.out.println(minCostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15}));//6
    System.out.println(minCostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));//11
    System.out.println(
        minCostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15}));//17
    System.out.println(minCostTickets(new int[]{5}, new int[]{100, 50, 2}));//2
  }
}
