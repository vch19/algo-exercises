package grokkingAlgoCourse.slidingWindow;

public class MaxSumSubArrayOfSizeK {

  public static int findMaxSumSubArray(int[] nums, int k) {
    int[] sum = new int[nums.length];
    sum[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      sum[i] += sum[i - 1] + nums[i];
    }

    int result = 0;
    int left = 0;
    for (int right = k; right < nums.length; right++) {
      result = Math.max(sum[right] - sum[left++], result);
    }

    return result;
  }

  public static int findMaxSumSubArrayEffective(int[] nums, int k) {
    int maxSum = 0;
    int start = 0;
    int sum = 0;

    for (int end = 0; end < nums.length; end++) {
      sum += nums[end];
      if (end >= k - 1) {
        maxSum = Math.max(sum, maxSum);
        sum -= nums[start];
        start++;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println(findMaxSumSubArrayEffective(new int[] {2, 3, 4, 1, 5}, 2)); //7
    System.out.println(findMaxSumSubArrayEffective(new int[] {2, 1, 5, 1, 3, 2}, 3)); //9
  }

}
