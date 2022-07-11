package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

  public static int[][] intervalIntersection(int[][] first, int[][] second) {
    if (first.length == 0 || second.length == 0) {
      return new int[0][];
    }

    List<int[]> intersections = new ArrayList<>();

    int a = 0;
    int b = 0;

    while (a < first.length && b < second.length) {
      // Let's check if A[i] intersects B[j].
      // max - the startpoint of the intersection
      // min - the endpoint of the intersection
      int max = Math.max(first[a][0], second[b][0]);
      int min = Math.min(first[a][1], second[b][1]);

      if (max <= min) {
        intersections.add(new int[]{max, min});
      }

      if (first[a][1] >= second[b][1]) {
        b++;
      } else {
        a++;
      }
    }

    return intersections.toArray(new int[intersections.size()][]);
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.deepToString(intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23},
            {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
  }

}
