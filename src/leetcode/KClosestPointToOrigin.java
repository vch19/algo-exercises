package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointToOrigin {

  private static final Comparator<int[]> POINT_COMPARATOR = Comparator.comparing(point -> point[1]);

  public static int[][] kClosest(int[][] points, int k) {
    List<int[]> result = new ArrayList<>();

    Queue<int[]> maxHeap = new PriorityQueue<>(POINT_COMPARATOR);

    maxHeap.addAll(Arrays.asList(points));

    for (int i = 0; i < k; i++) {
      result.add(maxHeap.poll());
    }

    return result.toArray(new int[][]{});
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(
        kClosest(new int[][]{
            {3, 3},
            {5, -1},
            {-2, 4}
        }, 2)
    ));
  }
}
