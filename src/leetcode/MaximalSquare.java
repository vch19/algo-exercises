package leetcode;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int columns = rows > 0 ? matrix[0].length : 0;

        int[][] dp = new int[rows + 1][columns + 1];

        int maxSquareLength = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
                }
            }
        }

        return maxSquareLength * maxSquareLength;
    }

    public static void main(String[] args) {
        maximalSquare(new char[][] { { '0', '1' }, { '1', '0' } }); //1
    }
}
