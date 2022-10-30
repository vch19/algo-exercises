package leetcode;

public class MaximumSubarraySumAfterOneOperation {

  public static int maxSumAfterOperation(int[] nums) {
    int[][] dp = new int[nums.length][2];
    dp[0][0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
    }

    dp[0][1] = nums[0] * nums[0];
    int max = Math.max(dp[0][0], dp[1][0]);

    for (int i = 1; i < nums.length; i++) {
      dp[i][1] = Math.max(nums[i] * nums[i], Math.max(dp[i][0],
          Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0] + (nums[i] * nums[i]))));

      max = Math.max(max, dp[i][1]);
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxSumAfterOperation(
        new int[]{-4, -49, -12, -75, -48, 46, 72, 10, 51, -51, 26, -74, 70, -1, -25, 29, 27}));
  }
}
