package leetcode;

public class MaximumContiguousSubArray {
    public static int maxContiguousSubarraySum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxContiguousSum = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //Every time you should ask question.
            //Should I continue or start new array?
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            maxContiguousSum = Math.max(dp[i], maxContiguousSum);
        }

        return maxContiguousSum;
    }

    public static void main(String[] args) {
        maxContiguousSubarraySum(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
    }
}
