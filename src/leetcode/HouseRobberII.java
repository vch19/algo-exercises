package leetcode;

import java.util.Arrays;

public class HouseRobberII {

  public static int rob(int[] nums) {
    if (nums.length <= 3) {
      return Arrays.stream(nums).max().getAsInt();
    }

    return Math.max(maxProfit(nums, 0, nums.length - 1), maxProfit(nums, 1, nums.length));
  }

  public static int maxProfit(int[] nums, int start, int end) {
    int[] dp = new int[end - start];
    int max = 0;
    dp[0] = nums[start];
    dp[1] = nums[start + 1];

    int j = start + 2;

    for (int i = 2; i < dp.length; i++) {
      if (i == 2) {
        dp[i] = dp[i - 2] + nums[j];
      } else {
        dp[i] = Math.max(dp[i - 2] + nums[j], dp[i - 3] + nums[j]);
      }

      max = Math.max(max, dp[i]);
      j++;
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(rob(new int[]{1, 2, 3})); //3
    System.out.println(rob(new int[]{1, 2, 3, 1})); //4
  }
}
