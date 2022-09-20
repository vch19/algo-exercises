package leetcode;

public class Knapsack {

  public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
    int[][] dp = new int[weights.length + 1][capacity + 1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (j >= weights[i - 1]) {
          dp[i][j] = Math.max(dp[i - 1][j - weights[i - 1]] + profits[i - 1], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[weights.length][capacity];
  }

  public static void main(String[] args) {
    System.out.println(solveKnapsack(new int[]{60, 50, 70, 30}, new int[]{5, 3, 4, 2}, 5));
  }
}
