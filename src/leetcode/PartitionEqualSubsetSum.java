package leetcode;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

  public static boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();

    if (sum % 2 != 0) {
      return false;
    }

    sum /= 2;

    boolean[][] dp = new boolean[nums.length][sum + 1];
    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= sum; i++) {
      dp[0][i] = nums[0] == i;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j <= sum; j++) {
        if (dp[i - 1][j]) {
          dp[i][j] = dp[i - 1][j];
        } else if (j >= nums[i]) {
          dp[i][j] = dp[i - 1][j - nums[i]];
        }
      }
    }

    return dp[nums.length - 1][sum];
  }

  public static void main(String[] args) {
    System.out.println(canPartition(new int[]{1, 2, 3, 4}));//true
    System.out.println(canPartition(new int[]{1,5,11,5}));//true
  }
}
