package grokkingAlgoCourse.kapsnack01;

import java.util.Arrays;

public class MinimumSubsetSumDifference {
  public static int canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();

    boolean[][] dp = new boolean[nums.length][sum/2 + 1];

    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i < dp[0].length; i++) {
      dp[0][i] = i == nums[0];
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (dp[i - 1][j]) {
          dp[i][j] = dp[i - 1][j];
        } else if (j >= nums[i]) {
          dp[i][j] = dp[i - 1][j - nums[i]];
        }
      }
    }

    int sum1 = 0;
    for (int i = sum / 2; i >= 0; i--) {
      if (dp[nums.length - 1][i]) {
          sum1 = i;
          break;
      }
    }
    int sum2 = sum - sum1;
    return Math.abs(sum1 - sum2);
  }

  public static void main(String[] args) {
    System.out.println(canPartition(new int[] {1, 2, 3, 9}));
  }
}
