package grokkingAlgoCourse.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Similar problems:
 * Problem 1: Given a list of intervals, find the point where the maximum number of intervals overlap.
 *
 * Problem 2: Given a list of intervals representing the arrival and departure times of trains to a train station,
 * our goal is to find the minimum number of platforms required for the train station so that no train has to wait.
 */
public class MinimumMeetingRooms {

  public static int findMinimumMeetingRooms(int[][] meetings) {
    if (meetings == null || meetings.length == 0) {
      return 0;
    }

    Arrays.sort(meetings, Comparator.comparing(meeting -> meeting[0]));
    //sort our meetings by end date to get the most recently ended
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    minHeap.add(meetings[0]);

    for (int i = 1; i < meetings.length; i++) {
      int[] currentMeeting = meetings[i];
      int[] existingMeeting = minHeap.remove();

      if (currentMeeting[0] >= existingMeeting[1]) {
        //If current meeting don't intersect with previous one, we extend end time for first,
        //because they can be in one room.
        existingMeeting[1] = currentMeeting[1];
      } else {
        minHeap.add(currentMeeting);
      }

      minHeap.add(existingMeeting);
    }

    return minHeap.size();
  }

  public static void main(String[] args) {
    System.out.println(findMinimumMeetingRooms(new int[][]{{4, 5}, {2, 3}, {2, 4}, {3, 5}}));//2
    System.out.println(findMinimumMeetingRooms(new int[][]{{6, 7}, {2, 4}, {8, 12}}));//1
  }
}
