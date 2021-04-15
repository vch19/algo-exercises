package leetcode;

public class LongestCommonContinuousSequence {
    private static int longestContiguousCommonSequence(String first, String second) {
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        int max = 0;

        for (int i = 1; i < first.length(); i++) {
            for (int j = 1; j < second.length(); j++) {
                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    if (dp[i - 1][j - 1] == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestContiguousCommonSequence("aabbbaab", "aabzzzzzz")); //3(aab)
        System.out.println(longestContiguousCommonSequence("azbfddggqweqwvfqw", "ddggqweqwefsdfe")); //9(ddggqweqw)
    }
}