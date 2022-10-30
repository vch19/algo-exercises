package leetcode;

import java.util.Arrays;

public class PaintHouseII {

  public static int minCostII(int[][] costs) {
    int minCosts = Integer.MAX_VALUE;
    if (costs.length == 1) {
      return Arrays.stream(costs[0]).max().getAsInt();
    }
    int[] previous = minArray(costs[0]);

    for (int i = 1; i < costs.length; i++) {
      int[] current = costs[i];
      for (int j = 0; j < current.length; j++) {
        if (j >= previous.length) {
          current[j] = previous[previous.length - 1] + current[j];
        } else {
          current[j] = previous[j] + current[j];
        }

        if (i == costs.length - 1) {
          minCosts = Math.min(minCosts, current[j]);
        }
      }
      previous = minArray(current);
    }

    return minCosts;
  }

  public static int[] minArray(int[] arr) {
    int[] left = new int[arr.length];
    int[] right = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      if (i == 0) {
        left[i] = Integer.MAX_VALUE;
      } else if (i == 1) {
        left[i] = arr[i - 1];
      } else {
        left[i] = Math.min(left[i - 1], arr[i - 1]);
      }
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      if (i == arr.length - 1) {
        right[i] = Integer.MAX_VALUE;
      } else if (i == arr.length - 2) {
        right[i] = arr[i + 1];
      } else {
        right[i] = Math.min(arr[i + 1], right[i + 1]);
      }
    }

    for (int i = 0; i < arr.length; i++) {
      left[i] = Math.min(left[i], right[i]);
    }

    return left;
  }

  public static void main(String[] args) {
    System.out.println(minCostII(new int[][]{
        {1, 5, 3},
        {2, 9, 4}
    }));//5

    System.out.println(minCostII(new int[][]{
        {1, 3},
        {2, 4}
    }));//5

    System.out.println(minCostII(new int[][]{
        {1, 5, 3},
        {2, 9, 4},
        {6, 1, 8, 10}
    }));//6

    System.out.println(minCostII(new int[][]{
        {1}
    }));//1
  }
}
