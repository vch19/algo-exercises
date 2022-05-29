package leetcode;

import static utils.ProjectUtils.createArrayWithCustomDefaultValue;

public class CoinChange {

  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }

    int[] iterations = new int[amount];

    for (int i = 1; i <= amount; i++) {
      int min = Integer.MAX_VALUE;
      for (int coin : coins) {
        if (coin == i) {
          min = Math.min(min, 1);
        } else if (i - coin >= 0) {
          min = Math.min(iterations[i - 1 - coin] + 1, min);
        }
      }
      iterations[i - 1] = min == Integer.MAX_VALUE ? -1 : min;
    }
    return iterations[amount - 1];
  }

  public static void main(String[] args) {
    System.out.println(coinChange(new int[]{1, 2, 5}, 11)); //3
    System.out.println(coinChange(new int[]{2}, 3)); //-1
    System.out.println(coinChange(new int[]{1}, 0)); //0
    System.out.println(coinChange(new int[]{2}, 1)); //-1
    System.out.println(coinChange(new int[]{2}, 3)); //-1
  }
}
