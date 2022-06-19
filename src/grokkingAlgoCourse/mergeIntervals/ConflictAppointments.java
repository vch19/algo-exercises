package grokkingAlgoCourse.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictAppointments {

  public static boolean canAttendAllAppointments(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
    int[] prevInterval = intervals[0];

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < prevInterval[1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(canAttendAllAppointments(new int[][]{{1, 4}, {2, 5}, {7, 9}})); //false
    System.out.println(canAttendAllAppointments(new int[][]{{6, 7}, {2, 4}, {8, 12}})); //true
  }
}
