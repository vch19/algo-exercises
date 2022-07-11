package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> freq = new HashMap<>();

    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      if (freq.size() > 1 && right - left <= k) {
        if (freq.containsValue(nums[right])) {
          return true;
        }
      } else if (right - left > k - 1) {
        freq.remove(left);
        left++;
      }

      freq.put(right, nums[right]);
    }

    return false;
  }

  public static void main(String[] args) {
//    System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));//true
    System.out.println(containsNearbyDuplicate(new int[]{4, 1, 2, 3, 1, 5}, 3));//true
  }
}
