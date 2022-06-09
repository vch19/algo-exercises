package leetcode;

import java.util.Arrays;

public class RemoveCoveredInterval {

  public static int removeCoveredIntervals(int[][] intervals) {
    //this comparator working in the next way:
    //if our first elements in intervals are equals, that we check second ones
    //if the second element of second interval is greater that at first it'll return 1 and otherwise.
    Arrays.sort(intervals,(a,b)-> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

    int size = intervals.length;
    int[] maxInterval = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      if (maxInterval[0] <= intervals[i][0] && maxInterval[1] >= intervals[i][1]) {
        size--;
      } else {
        maxInterval = intervals[i];
      }
    }

    return size;
  }

  public static void main(String[] args) {
    System.out.println(removeCoveredIntervals(new int[][]{
        {1, 4}, {3, 6}, {2, 8}
    })); //2

    System.out.println(removeCoveredIntervals(new int[][]{
        {1, 2}, {1, 4}, {3, 4}
    })); //1

  }
}
