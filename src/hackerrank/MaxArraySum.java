package hackerrank;

import utils.ProjectUtils;

public class MaxArraySum {

    //Time complexity O(n^2), space O(n)
    public static int maxSubsetSum(int[] arr) {
        final int[] dp = ProjectUtils.createArrayWithCustomDefaultValue(arr.length, Integer.MIN_VALUE);
        int max = 0;
        dp[0] = arr[0];
        dp[1] = arr[1];

        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(Math.max(arr[i] + dp[j], arr[i]), dp[i]);
                max = Math.max(dp[i], max);
            }
        }

        return max;
    }

    //Time complexity O(n), space O(n)
    public static int maxSubsetSumEffective(int[] arr) {
        final int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1];

        int max = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], arr[i]);
            dp[i - 1] = Math.max(dp[i - 1], dp[i - 2]);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSumEffective(new int[] { -2, 1, 3, -4, 5 }));//8
        System.out.println(maxSubsetSumEffective(new int[] { 3, 7, 4, 6, 5 }));//13
        System.out.println(maxSubsetSumEffective(new int[] { 2, 1, 5, 8, 4 }));//11
        System.out.println(maxSubsetSumEffective(new int[] { 3, 5, -7, 8, 10 }));//15
    }
}
