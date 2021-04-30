package leetcode;

public class PartitionArrayForMaximumSum {
    public static int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length + 1];
        dp[0] = A[0];
        int initMax = A[0];

        for (int i = 1; i < K; i++) {
            if (A[i] > initMax) {
                initMax = A[i];
            }
            dp[i] = (i + 1) * initMax;
        }

        for (int i = K; i < A.length; i++) {
            int cur = 0;
            int kIntervalMax = A[i];
            for (int j = 1; j <= K; j++) {
                if (A[i - j + 1] > kIntervalMax) {
                    kIntervalMax = A[i - j + 1];
                }

                cur = dp[i - j] + j * kIntervalMax;

                if (cur > dp[i]) {
                    dp[i] = cur;
                }
            }
        }

        System.out.println(dp[A.length - 1]);
        return dp[A.length - 1];
    }

    public static void main(String[] args) {
        maxSumAfterPartitioning(new int[] {1,15,7,9,2,5,10}, 3);
//        maxSumAfterPartitioning(new int[] {1,2,3,4}, 2);
    }
}
