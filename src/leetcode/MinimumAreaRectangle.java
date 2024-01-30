package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MinimumAreaRectangle {

  public static int minAreaRect(int[][] points) {
//    Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//    Map<Integer, Integer> x = new HashMap<>();
//    Map<Integer, Integer> y = new HashMap<>();
//
//    for (int i = 0; i < points.length; i++) {
//      if (!x.containsKey(points[i][0])) {
//        x.put(points[i][0], Integer.MAX_VALUE);
//      } else {
//        x.put(points[i][0], Math.min(x.get(points[i][0]), points[i][1]));
//      }
//
//      if (!y.containsKey(points[i][1])) {
//        y.put(points[i][1], Integer.MAX_VALUE);
//      } else {
//        y.put(points[i][1], Math.min(x.get(points[i][1]), points[i][0]));
//      }
//    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}}));
  }

}
