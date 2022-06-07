package leetcode;

public class LongestSubarrayOf1AfterDeletingOneElement {

  public static int longestSubarray(int[] nums) {
    int max = 0;
    int k = 1;
    int i = 0;

    for (int j = 0; j < nums.length; j++) {
      if (nums[j] == 0) {
        k--;
      }

      while (k < 0) {
        if (nums[i] == 0) {
          k++;
        }
        i++;
      }
      max = Math.max(max, j - i);
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));//3
    System.out.println(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));//5
    System.out.println(longestSubarray(new int[]{1, 1, 1}));//2
    System.out.println(longestSubarray(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));//4
    System.out.println(longestSubarray(new int[]{0, 0, 0}));//0
    System.out.println(longestSubarray(new int[]{1, 0, 0, 1, 0}));//1
  }
}
