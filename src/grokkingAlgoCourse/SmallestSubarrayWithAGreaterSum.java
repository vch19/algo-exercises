package grokkingAlgoCourse;

public class SmallestSubarrayWithAGreaterSum {

  //The time complexity: O(N + N), space: O(1)
  public static int findMinSubArray(int k, int[] nums) {
    int length = Integer.MAX_VALUE;

    int a = 0;
    int b = 0;

    int sum = 0;

    while (a < nums.length || b < nums.length) {
      if (sum >= k) {
        length = Math.min(length, b - a);
        sum -= nums[a++];
      } else if (b < nums.length) {
        sum += nums[b++];
      } else {
        sum -= nums[a++];
      }
    }
    return length == Integer.MAX_VALUE ? 0 : length;
  }

  public static void main(String[] args) {
    System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2})); //2
    System.out.println(findMinSubArray(7, new int[]{2, 3, 1, 2, 4, 3})); //2
    System.out.println(findMinSubArray(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1})); //0
    System.out.println(findMinSubArray(7, new int[]{2, 1, 5, 2, 8})); //1
  }
}
