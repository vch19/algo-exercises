package leetcode;

public class MaxRectangleSum {

    public static int maxRectangleSum(int[][] matrix) {
        int[] dp = new int[matrix.length];
        int maxRectangleSum = Integer.MIN_VALUE;
        int length = 0;

        while (length != matrix[0].length) {
            for (int i = length; i < matrix[0].length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    dp[j] = dp[j] + matrix[j][i];
                }
                maxRectangleSum = Math.max(maxRectangleSum, maxContinuousArraySum(dp));
            }
            dp = new int[matrix.length];
            length++;
        }

        return maxRectangleSum;
    }

    private static int maxContinuousArraySum(int[] dp) {
        int max = dp[0];
        int[] temp = new int[dp.length];
        temp[0] = dp[0];

        for (int i = 1; i < dp.length; i++) {
            temp[i] = Math.max(dp[i], dp[i] + temp[i - 1]);
            max = Math.max(max, temp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        maxRectangleSum(new int[][] {
            { 6, -5, -7, 4, -4 },
            { -9, 3, -6, 5, 2 },
            { -10, 4, 7, -6, 3 },
            { -8, 9, -3, 3, -7 }
        });//17
    }
}
