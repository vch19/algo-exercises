package leetcode;

import java.util.Arrays;

public class ThreeSumSmallest {

//  public static int threeSumSmaller(int[] nums, int target) {
//    Arrays.sort(nums);
//
//    int triplets = 0;
//
//    int left = 0;
//    int right = 0;
//
//    while (right - left > 1) {
//      int sum = nums[left] + nums[right];
//
//      if (sum >= target) {
//        right--;
//        continue;
//      } else {
//        for (int i = right - 1; i > left; i--) {
//          if (sum + nums[i] < target) {
//            triplets++;
//          }
//        }
//      }
//      right--;
//    }
//
//    return triplets;
//  }

  public static int threeSumSmaller(int[] nums, int target) {
    Arrays.sort(nums);

    int triplets = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      triplets += twoSum(nums, i + 1, target - nums[i]);
    }

    return triplets;
  }

  private static int twoSum(int[] nums, int start, int target) {
    int pairs = 0;

    int left = start;
    int right = nums.length - 1;

    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum < target) {
        pairs += right - left;
      }

      if (sum > target) {
        right--;
      } else {
        left++;
      }
    }

    return pairs;
  }

  public static void main(String[] args) {
    System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));//2
//    System.out.println(threeSumSmaller(new int[]{3, 1, 0, -2}, 4));//3
  }
}
