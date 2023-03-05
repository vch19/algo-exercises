package leetcode;

public class NumberOfDiceRollsWithTargetSum {

  private static final long MODULO = (long) 10e9 + 7;

  public static int numRollsToTarget(int n, int k, int target) {
    long[][] dp = new long[n][target];
    dp[0][0] = 1;

    for (int i = 1; i <= target; i++) {
      if (i <= k) {
        dp[0][i - 1] = 1;
      }
    }

    for (int i = 1; i < dp.length; i++) {
      dp[i][i] = 1;
      for (int j = i + 1; j < dp[0].length; j++) {
        if (j == i + 1) {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j - 2]) % MODULO;
        } else {
          dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % MODULO;
        }
      }
    }

    return (int) dp[n - 1][target - 1];
  }

  public static void main(String[] args) {
//    System.out.println(numRollsToTarget(2, 6, 7));//6
//    System.out.println(numRollsToTarget(1, 6, 3));//1
//    System.out.println(numRollsToTarget(3, 6, 7));//15
//    System.out.println(numRollsToTarget(3, 6, 30));//152
    System.out.println(numRollsToTarget(30, 30, 500));//222616187
  }
}
