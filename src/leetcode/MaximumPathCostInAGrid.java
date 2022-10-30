package leetcode;

import java.util.Arrays;


public class MaximumPathCostInAGrid {

  public static int minPathCost(int[][] grid, int[][] moveCost) {
    int[][] dp = new int[grid.length][grid[0].length];
    System.arraycopy(grid[0], 0, dp[0], 0, grid[0].length);

    for (int i = 1; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
        }
      }
    }

    return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
  }



  public static void main(String[] args) {
    System.out.println(minPathCost(new int[][]{
        {5, 3},
        {4, 0},
        {2, 1}
    }, new int[][]{
        {9, 8},
        {1, 5},
        {10, 12},
        {18, 6},
        {2, 4},
        {14, 3}
    }));//17
  }
}
