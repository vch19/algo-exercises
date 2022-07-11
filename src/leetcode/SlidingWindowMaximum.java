package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[]{};
    }

    int[] windows = new int[nums.length - k + 1];

    Queue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> (nums[i2] - nums[i1]));

    for (int i = 0; i < nums.length; i++) {
      int start = i - k;

      if (start >= 0) {
        maxHeap.remove(start);
      }

      maxHeap.offer(i);

      if (maxHeap.size() == k) {
        windows[i - k + 1] = nums[maxHeap.peek()];
      }
    }

    return windows;
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));//[3,3,5,5,6,7]

    System.out.println(
        Arrays.toString(maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));//[3,3,2,5]

    System.out.println(
        Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));//1
  }
}
