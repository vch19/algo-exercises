package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

  public static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> merged = new ArrayList<>();

    int i = 0;

    //There we add all elements which cannot be merged with newInterval
    while (i < intervals.length && intervals[i][1] < newInterval[0]) {
      merged.add(intervals[i++]);
    }

    //Merge all intervals which intersect with newInterval
    //We check if an end of new interval greater or equals to start of another
    while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
      newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
      newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
      i++;
    }

    merged.add(newInterval);

    while (i < intervals.length) {
      merged.add(intervals[i++]);
    }

    return merged.toArray(new int[merged.size()][]);
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));//[1, 5], [6, 9]

    System.out.println(Arrays
        .deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
            new int[]{4, 8})));//[[1,2],[3,10],[12,16]]
////
//    System.out.println(Arrays
//        .deepToString(insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
//            new int[]{0, 1})));//[[0,2],{3, 5}, {6, 7}, {8, 10}, {12, 16}]
//
//    System.out.println(Arrays
//        .deepToString(insert(new int[][]{{1, 5}},
//            new int[]{2, 7})));//[1, 7]
  }
}
