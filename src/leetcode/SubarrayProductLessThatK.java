package leetcode;

public class SubarrayProductLessThatK {

  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k <= 1) {
      return 0;
    }
    int ans = 0;
    int left = 0;
    int production = 1;

    for (int right = 0; right < nums.length; right++) {
      production *= nums[right];
      while (production >= k) {
        production /= nums[left++];
      }

      ans += right - left + 1;
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100)); //8
    System.out.println(numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19)); //18
    System.out.println(numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0)); //0
    System.out.println(numSubarrayProductLessThanK(new int[]{10, 2, 2, 5, 4, 4, 4, 3, 7, 7}, 289)); //31
  }
}
