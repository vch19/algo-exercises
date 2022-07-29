package leetcode;

import java.util.Arrays;

public class LongDistance {

  public static int[] solve(int[] nums) {
    int[] result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      result[i] = helper(nums, i + 1, nums.length - 1, nums[i]);
    }

    return result;
  }

  private static int helper(int[] nums, int left, int right, int target) {
    int counter = 0;
    while (left <= right) {
      if (nums[left] < target) {
        counter++;
      }
      if (nums[right] < target && right != left) {
        counter++;
      }
      left++;
      right--;
    }

    return counter;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solve(new int[]{3, 4, 9, 6, 1})));
  }
}
