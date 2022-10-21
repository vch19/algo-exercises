package leetcode;

public class MinFallingPathSum {

  public static int minFallingPathSum(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    System.arraycopy(matrix[0], 0, dp[0], 0, matrix.length);

    int minSum = Integer.MAX_VALUE;

    for (int i = 1; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (j == 0) {
          dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], dp[i - 1][j + 1] + matrix[i][j]);
        } else if (j == matrix[0].length - 1) {
          dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], dp[i - 1][j - 1] + matrix[i][j]);
        } else {
          dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j],
              Math.min(dp[i - 1][j + 1] + matrix[i][j], dp[i - 1][j - 1] + matrix[i][j]));
        }

        if (i == matrix.length - 1) {
          minSum = Math.min(minSum, dp[i][j]);
        }
      }
    }

    return minSum;
  }

  public static void main(String[] args) {
    System.out.println(minFallingPathSum(new int[][]{
        {2, 1, 3},
        {6, 5, 4},
        {7, 8, 9}
    })); //13
  }
}
