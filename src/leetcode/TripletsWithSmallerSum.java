package leetcode;

import java.util.Arrays;

public class TripletsWithSmallerSum {

  public static int searchTriplets(int[] nums, int target) {
    Arrays.sort(nums);
    int triplets = 0;

    for (int i = 0; i < nums.length; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum < target - nums[i]) {
          triplets += right - left;
          left++;
        } else {
          right--;
        }
      }
    }

    return triplets;
  }

  public static void main(String[] args) {
    System.out.println(searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
  }

}
