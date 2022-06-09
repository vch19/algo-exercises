package grokkingAlgoCourse.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

  public static int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
    LinkedList<int[]> merged = new LinkedList<>();
    merged.add(intervals[0]);

    for (int i = 1; i < intervals.length; i++) {
      if (merged.getLast()[1] >= intervals[i][0]) {
        merged.getLast()[1] = Math.max(intervals[i][1], merged.getLast()[1]);
      } else {
        merged.add(intervals[i]);
      }
    }

    return merged.toArray(new int[][]{});
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))); //[1,6],[8,10],[15,18]
    System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4},{4, 5}})));//[1,5]
    System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4},{2, 3}})));//[1,4]
  }
}
