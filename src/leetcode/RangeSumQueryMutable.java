package leetcode;

//todo: Can be improved by using tree and then update will be O(log n)
public class RangeSumQueryMutable {
    private final int[] dp;

    //Initialization: O(n)
    public RangeSumQueryMutable(int[] nums) {
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    //Update: O(n)
    public void update(int index, int val) {
        int prev = dp[index];
        dp[index] = index == 0 ? val : dp[index - 1] + val;

        for (int i = index + 1; i < dp.length; i++) {
            int newVal = dp[i] - prev + dp[i - 1];
            prev = dp[i];
            dp[i] = newVal;
        }
    }

    //Sum: O(1)
    public int sumRange(int left, int right) {
        if (left == 0) return dp[right];
        return dp[right] - dp[left - 1];
    }

    public static void main(String[] args) {
        RangeSumQueryMutable rangeSumQueryMutable =
            new RangeSumQueryMutable(new int[] { 1, 3, 5 });

        System.out.println(rangeSumQueryMutable.sumRange(0, 2));
        rangeSumQueryMutable.update(1, 2);
        System.out.println(rangeSumQueryMutable.sumRange(0, 2));
    }
}
