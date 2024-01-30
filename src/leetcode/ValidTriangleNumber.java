package leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {

  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);

    int triangles = 0;

    for (int i = nums.length - 1; i >= 2; i--) {
      int left = 0;
      int right = i - 1;

      while (left < right) {
        if (nums[left] + nums[right] >= nums[i]) {
          triangles += right - left;
          right--;
        } else {
          left++;
        }
      }
    }

    return triangles;
  }

  public static void main(String[] args) {
    System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{4, 2, 3, 4}));
  }
}
