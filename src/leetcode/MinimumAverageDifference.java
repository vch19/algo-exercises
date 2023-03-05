package leetcode;

public class MinimumAverageDifference {

  public static int minimumAverageDifference(int[] nums) {
    long[] prefix = new long[nums.length];
    prefix[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      prefix[i] = prefix[i - 1] + nums[i];
    }

    int minAvg = Integer.MAX_VALUE;
    int minIndex = 0;

    for (int i = 0; i < prefix.length; i++) {
      long average = Math.abs(
          (prefix[i] / (i + 1)) - ((prefix[prefix.length - 1] - prefix[i]) /
              (prefix.length - i - 1 == 0 ? 1 : prefix.length - i - 1)));

      if (average < minAvg) {
        minAvg = (int) average;
        minIndex = i;
      }
    }

    return minIndex;
  }

  public static void main(String[] args) {
    System.out.println(minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
  }
}
