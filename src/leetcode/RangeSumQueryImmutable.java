package leetcode;

public class RangeSumQueryImmutable {
    private int[] dp;

    public RangeSumQueryImmutable(int[] nums) {
        this.dp = new int[nums.length];
        this.dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return dp[right];
        return dp[right] - dp[left - 1];
    }

    public static void main(String[] args) {
        System.out.println(new RangeSumQueryImmutable(new int[] {-2, 0, 3, -5, 2, -1}).sumRange(2, 5));
    }
}
