package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SubarrayWithProductLessThatTarget {

  public static List<List<Integer>> findSubarrays(int[] nums, int target) {
    LinkedList<List<Integer>> subarrays = new LinkedList<>();

    int left = 0;
    int right = 0;

    int product = nums[right];

    while (right < nums.length) {
      if (product < target) {
        right++;
      } else {
        subarrays.add(List.of(nums[left++]));
        while (left < right) {
          List<Integer> result = new ArrayList<>();
          Collections.copy(result, subarrays.getLast());
          result.add(nums[left++]);
          subarrays.add(result);
        }
      }
    }

    return subarrays;
  }
}
