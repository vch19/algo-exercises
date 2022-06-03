package leetcode;

public class MaximumProductSubarray {

  public static int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int result = nums[0];

    int min = 1;
    int max = 1;

    for (int num : nums) {
      int curMin = min * num;
      int curMax = max * num;
      max = Math.max(Math.max(curMax, curMin), num);
      min = Math.min(Math.min(curMax, curMin), num);
      result = Math.max(result, max);
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(maxProduct(new int[]{2, 3, -2, 4})); //6
    System.out.println(maxProduct(new int[]{-2, 0, -1})); //0
    System.out.println(maxProduct(new int[]{-2, 3, -4})); //24
    System.out.println(maxProduct(new int[]{7, -2, -4})); //56
  }

}
