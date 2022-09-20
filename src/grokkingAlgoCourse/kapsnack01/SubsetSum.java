package grokkingAlgoCourse.kapsnack01;

public class SubsetSum {

  public static boolean canPartition(int[] nums, int sum) {
    boolean[][] dp = new boolean[nums.length][sum + 1];

    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < dp[0].length; i++) {
      dp[0][i] = i == nums[0];
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (dp[i - 1][j]) {
          dp[i][j] = dp[i - 1][j];
        } else if (j >= nums[i]) {
          dp[i][j] = dp[i - 1][j - nums[i]];
        }
      }
    }

    return dp[nums.length - 1][sum];
  }
}
