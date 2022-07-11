package leetcode;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

  public static int maxFrequency(int[] nums, int k) {
    int maxLength = 0;
    long sum = 0;
    Arrays.sort(nums);

    int left = 0;
    for (int right = 0; right < nums.length; right++) {
      sum += nums[right];

      while (sum + k < (long) nums[right] * (right + left + 1)) {
        sum -= nums[left];
        left++;
      }

      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));//3
  }
}
