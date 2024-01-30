package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumSumCircularSubarray {

  public static int maxSubarraySumCircular(int[] nums) {
    int max = nums[0];
    int currentSum = nums[0];

    List<Integer> used = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();

    used.add(nums[0]);

    for (int i = 1; i < nums.length; i++) {
      if (currentSum + nums[i] > nums[i]) {
        currentSum += nums[i];
        used.add(nums[i]);
        max = Math.max(max, currentSum);
      } else {
        deque.addAll(used);
        used.clear();
        currentSum = nums[i];
        used.add(nums[i]);
        max = Math.max(max, currentSum);
      }
    }

    while (!deque.isEmpty()) {
      if (currentSum + deque.peekFirst() > deque.peekFirst()) {
        currentSum += deque.peekFirst();
        used.add(deque.pollFirst());
        max = Math.max(max, currentSum);
      } else {
        deque.addAll(used);
        used.clear();
        currentSum = deque.peekFirst();
        used.add(deque.pollFirst());
        max = Math.max(max, currentSum);
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}));//10
    System.out.println(maxSubarraySumCircular(new int[]{-2, 4, -5, 4, -5, 9, 4}));//15
  }
}
