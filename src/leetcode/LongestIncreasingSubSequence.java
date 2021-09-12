package leetcode;

import utils.ProjectUtils;

public class LongestIncreasingSubSequence {

  //Time complexity: O(n^2)
  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int maxLISLength = 0;
    int[] lengths = ProjectUtils.createArrayWithCustomDefaultValue(nums.length, 1);

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          lengths[i] = Math.max(lengths[j] + 1, lengths[i]);
          maxLISLength = Math.max(maxLISLength, lengths[i]);
        }
      }
    }

    return maxLISLength;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); //4
    System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); //4
  }

}
