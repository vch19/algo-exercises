package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    LinkedList<int[]> merged = new LinkedList<>();

    for (int[] interval : intervals) {
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.addLast(interval);
      } else if (merged.getLast()[1] < interval[1]) {
        merged.getLast()[1] = interval[1];
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }

  public static void main(String[] args) {
    var result = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    var result1 = merge(new int[][]{{1, 4}, {2, 3}});
    System.out.println(Arrays.deepToString(result));
    System.out.println(Arrays.deepToString(result1));
  }
}
