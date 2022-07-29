package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindKClosestElements {

  public static List<Integer> findClosestElements(int[] nums, int k, int x) {
    PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> {
      if (Math.abs(a - x) == Math.abs(b - x)) {
        return Integer.compare(a, b);
      }

      return Integer.compare(Math.abs(a - x), Math.abs(b - x));
    });

    for (int i = 0; i < nums.length; i++) {
      heap.add(nums[i]);
    }

    List<Integer> result = new ArrayList<>();

    while (k > 0) {
      result.add(heap.poll());
      k--;
    }

    Collections.sort(result);

    return result;
  }

  public static List<Integer> findClosestElementsEffective(int[] nums, int k, int x) {
    int left = 0;
    int right = nums.length - 1;

    while (right - left >= k) {
      if (Math.abs(nums[left] - x) > Math.abs(nums[right] - x)) {
        left++;
      } else {
        right--;
      }
    }

    List<Integer> result = new ArrayList<>();
    for (int i = left; i <= right; i++) {
      result.add(nums[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(findClosestElementsEffective(new int[]{1, 2, 3, 4, 5}, 4, 3));
  }
}
