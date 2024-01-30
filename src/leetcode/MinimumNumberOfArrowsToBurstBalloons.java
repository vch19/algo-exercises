package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {

  public static int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

    int arrows = 0;

    for (int i = 0; i < points.length; i++) {
      int[] start = points[i];

      for (int j = i + 1; j < points.length; i++, j++) {
        if (start[1] < points[j][0]) {
          start = points[j];
          break;
        }
      }
      arrows++;
    }

    return arrows;
  }

  public static void main(String[] args) {
//    System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
//    System.out.println(
//        findMinArrowShots(new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}}));
  }

}
