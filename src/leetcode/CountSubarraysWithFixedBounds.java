package leetcode;

public class CountSubarraysWithFixedBounds {

  public static long countSubarrays(int[] nums, int minK, int maxK) {
    long subarrays = 0;
    int right = 0;
    int min = nums[right];
    int max = nums[right];

    while (right < nums.length) {
      if (min == minK && max == maxK) {
        while (min == minK && max == maxK) {
          if (nums[right] == minK && nums[right] == maxK) {
            subarrays++;
          }
          subarrays++;
          right++;
          min = Math.min(min, nums[right]);
          max = Math.max(max, nums[right]);
        }
      } else {
        min = Math.min(min, nums[right]);
        max = Math.max(max, nums[right]);
        right++;
      }
    }

    return subarrays;
  }

  public static void main(String[] args) {
//    System.out.println(countSubarrays(new int[] {1,3,5,2,7,5}, 1, 5));
    System.out.println(countSubarrays(new int[] {1,1,1,1}, 1, 1));
  }
}
