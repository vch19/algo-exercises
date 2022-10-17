package leetcode;

public class MaximumProfitFromTradingStocks {

  public static int maximumProfit(int[] present, int[] future, int budget) {
    int[][] dp = new int[present.length][budget + 1];
    int[] profit = new int[present.length];

    for (int i = 0; i < present.length; i++) {
      profit[i] = future[i] - present[i];
    }

    for (int i = 0; i < dp[0].length; i++) {
      if (present[0] <= i) {
        dp[0][i] = Math.max(profit[0], 0);
      }
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (j >= present[i]) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - present[i]] + profit[i]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[present.length - 1][budget];
  }

  public static void main(String[] args) {
    System.out.println(maximumProfit(new int[] {0, 4}, new int[] {2,5}, 0));
  }
}
