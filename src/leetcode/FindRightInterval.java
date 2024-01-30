package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindRightInterval {

  public static int[] findRightInterval(int[][] intervals) {
    Map<int[], Integer> pos = new HashMap<>();

    for (int i = 0; i < intervals.length; i++) {
      pos.put(intervals[i], i);
    }

    Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    int[] res = new int[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      int[] rightInterval = binarySearch(intervals, intervals[i][1], i, intervals.length - 1);
      res[pos.get(intervals[i])] = rightInterval == null ? -1 : pos.get(rightInterval);
    }

    return res;
  }

  private static int[] binarySearch(int[][] intervals, int target, int start, int end) {
    if (start >= end) {
      if (intervals[start][0] >= target) {
        return intervals[start];
      }
      return null;
    }

    int mid = (start + end) / 2;

    if (intervals[mid][0] < target) {
      return binarySearch(intervals, target, mid + 1, end);
    } else {
      return binarySearch(intervals, target, start, mid);
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
    System.out.println(Arrays.toString(findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}})));
  }

}
