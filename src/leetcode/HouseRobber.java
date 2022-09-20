package leetcode;

public class HouseRobber {

  public static int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = nums[1];

    int result = Math.max(dp[0], dp[1]);

    for (int i = 0; i <= nums.length - 3; i++) {
      dp[i + 2] = Math.max(dp[i] + nums[i + 2], dp[i + 2]);
      result = Math.max(result, dp[i + 2]);
      if (i + 3 < nums.length) {
        dp[i + 3] = Math.max(dp[i] + nums[i + 3], dp[i]);
        result = Math.max(result, dp[i + 3]);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(rob(new int[] {6, 6, 4, 8, 4, 3, 3, 10}));//27
    System.out.println(rob(new int[]{4, 1, 2, 7, 5, 3, 1}));//14
  }
}
