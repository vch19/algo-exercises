package leetcode;

public class MinFallingSum2 {

  /*
  Time complexity: O(m * n ^ 2)
  Space complexity: O(n)
  */
  public static int minFallingPathSum(int[][] grid) {
    if (grid.length == 1) {
      return grid[0][0];
    }
    int[] previous = new int[grid[0].length];
    int[] current = new int[grid[0].length];

    System.arraycopy(grid[0], 0, previous, 0, grid[0].length);

    int minSum = Integer.MAX_VALUE;

    for (int i = 1; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        current[j] = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) {
          if (j != k) {
            current[j] = Math.min(current[j], grid[i][j] + previous[k]);
          }

          if (i == grid.length - 1) {
            minSum = Math.min(minSum, current[j]);
          }
        }
      }
      previous = current;
      current = new int[grid[0].length];
    }
    return minSum;
  }

  public static void main(String[] args) {
    System.out.println(minFallingPathSum(
        new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }
    )); //13
  }
}
