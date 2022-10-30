package leetcode;

public class MaximumSubarray {

  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = Integer.MIN_VALUE;

    for (int i = 1; i < nums.length; i++) {
      dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
    }

    for (int j : dp) {
      max = Math.max(max, j);
    }

    return max;
  }

  public static int maxSubArrayDivideAndConquer(int[] nums) {
    return solve(nums, nums[0], 1, nums[0]);
  }

  private static int solve(int[] nums, int sum, int i, int max) {
    if (i == nums.length) {
      return max;
    }
    if (sum + nums[i] > nums[i]) {
      return solve(nums, sum + nums[i], i + 1, Math.max(max, sum + nums[i]));
    }
    return solve(nums, nums[i], i + 1, Math.max(max, nums[i]));
  }

  public static void main(String[] args) {
    System.out.println(maxSubArrayDivideAndConquer(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); //6
  }
}
