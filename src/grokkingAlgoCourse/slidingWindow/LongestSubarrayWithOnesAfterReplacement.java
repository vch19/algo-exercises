package grokkingAlgoCourse.slidingWindow;

public class LongestSubarrayWithOnesAfterReplacement {

  public static int findLength(int[] nums, int k) {
    int max = 0;
    int ones = 0;

    int a = 0;

    for (int b = 0; b < nums.length; b++) {
      ones = nums[b] == 1 ? ones + 1 : ones;

      if (b - a + 1 - ones > k) {
        ones = nums[a] == 1 ? ones - 1 : ones;
        a++;
      }
      max = Math.max(max, b - a + 1);
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2)); //6
    System.out.println(findLength(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2)); //6
    System.out.println(findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3)); //9
  }
}
