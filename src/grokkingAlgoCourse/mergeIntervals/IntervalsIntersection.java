package grokkingAlgoCourse.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalsIntersection {

  public static int[][] intersections(int[][] a, int[][] b) {
    List<int[]> intersections = new ArrayList<>();
    int i = 0;
    int j = 0;

    //There we check if the first interval is intersected with second one.
    //If first point of first interval is greater or equals to for the same point in second interval
    //and at the same moment first point of first interval should not be greater that second point of second interval and otherwise
    // |-------------| a
    //     |--------------| b
    // b.first > a.first and b.start < a.end
    while (i < a.length && j < b.length) {
      if ((a[i][0] >= b[j][0] && a[i][0] <= b[j][1])
          || (b[j][0] >= a[i][0] && b[j][0] <= a[i][1])) {
        intersections.add(new int[]{Math.max(a[i][0], b[j][0]), Math.min(a[i][1], b[j][1])});
      }

      if (a[i][1] < b[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    return intersections.toArray(new int[intersections.size()][]);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(intersections(
        new int[][]{{1, 3}, {5, 6}, {7, 9}},
        new int[][]{{2, 3}, {5, 7}}
    ))); //[2, 3], [5, 6], [7, 7]

    System.out.println(Arrays.deepToString(intersections(
        new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
        new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}
    )));
  }
}
