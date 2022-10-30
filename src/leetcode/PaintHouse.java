package leetcode;

public class PaintHouse {
  public static int minCost(int[][] costs) {
    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i < costs[0].length; i++) {
      minCost = Math.min(minCost, costs[0][i]);
    }

    if (costs.length == 1) {
      return minCost;
    }

    minCost = Integer.MAX_VALUE;

    for (int i = 1; i < costs.length; i++) {
      for (int j = 0; j < costs[0].length; j++) {
        if (j == 0) {
          costs[i][j] = Math.min(costs[i][j] + costs[i - 1][j + 1], costs[i][j] + costs[i - 1][j + 2]);
        } else if (j == 2) {
          costs[i][j] = Math.min(costs[i][j] + costs[i - 1][j - 1], costs[i][j] + costs[i - 1][j - 2]);
        } else {
          costs[i][j] = Math.min(costs[i][j] + costs[i - 1][j - 1], costs[i][j] + costs[i - 1][j + 1]);
        }

        if (i == costs.length - 1) {
          minCost = Math.min(minCost, costs[i][j]);
        }
      }
    }

    return minCost;
  }
}
