package leetcode;

public class UniquePathsII {

  public static int uniquePathsWithObstacles(int[][] grid) {
    if (grid[0][0] == 1) {
      return 0;
    }

    int[][] dp = new int[grid.length + 1][grid[0].length + 1];
    dp[1][1] = 1;

    for (int i = 2; i <= grid[0].length; i++) {
      if (grid[0][i - 1] == 1) {
        dp[1][i] = 0;
      } else {
        dp[1][i] = dp[0][i] + dp[1][i - 1];
      }
    }

    for (int i = 2; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (grid[i - 1][j - 1] == 1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        }
      }
    }

    return dp[grid.length][grid[0].length];
  }

  public static void main(String[] args) {
    System.out.println(uniquePathsWithObstacles(new int[][]{
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    }));//2

    System.out.println(uniquePathsWithObstacles(new int[][]{
        {0, 0},
        {1, 1},
        {0, 0}
    }));//0

    System.out.println(uniquePathsWithObstacles(new int[][]{
        {0, 1, 0, 0, 0},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0}
    }));//0
  }
}
