package leetcode;

public class MaximumSumScoreOfArray {

  public static long maximumSumScore(int[] nums) {
    long[] sum = new long[nums.length];
    sum[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      sum[i] += sum[i - 1] + nums[i];
    }

    long maxScore = Math.max(nums[0], sum[sum.length - 1]);

    for (int i = 0; i < nums.length - 1; i++) {
      maxScore = Math.max(maxScore, Math.max(sum[i], sum[sum.length - 1] - sum[i]));
    }

    maxScore = Math.max(maxScore, Math.max(sum[sum.length - 1], nums[nums.length - 1]));

    return maxScore;
  }

  public static void main(String[] args) {
    System.out.println(maximumSumScore(new int[]{4, 3, -2, 5}));
    System.out.println(maximumSumScore(new int[]{-3, -5}));
  }
}
