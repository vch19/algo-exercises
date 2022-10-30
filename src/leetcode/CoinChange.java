package leetcode;

import java.util.Arrays;

public class CoinChange {

  private int minCoins = Integer.MAX_VALUE;

  public int coinChangeBruteForce(int[] coins, int amount) {
    helper(coins, amount, 0);
    return minCoins;
  }

  private void helper(int[] coins, int amount, int deep) {
    if (amount < 0) {
      return;
    } else if (amount == 0) {
      minCoins = Math.min(minCoins, deep);
    }

    for (int i = 0; i < coins.length; i++) {
      helper(coins, amount - coins[i], deep + 1);
    }
  }

  public static int coinChangeTopDown(int[] coins, int amount) {
    int[] memo = new int[amount + 1];
    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[0] = 0;
    helper(amount, coins, memo);
    return -1;
  }

  public static void helper(int amount, int[] coins, int[] memo) {
    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amount) {
        if (memo[amount - coins[i]] != Integer.MAX_VALUE) {
          memo[amount] = memo[amount - coins[i]] + 1;
        } else {
          helper(amount - coins[i], coins, memo);
        }
      }
    }
  }

  public static int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    System.out.println(coinChangeTopDown(new int[]{1, 2, 5}, 11)); //3
    System.out.println(coinChange(new int[]{2}, 3)); //-1
    System.out.println(coinChange(new int[]{1}, 0)); //0
    System.out.println(coinChange(new int[]{2}, 1)); //-1
    System.out.println(coinChange(new int[]{2}, 3)); //-1
  }
}
