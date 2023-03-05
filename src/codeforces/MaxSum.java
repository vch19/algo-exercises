package codeforces;

import java.util.Scanner;

public class MaxSum {

  private static final Scanner SCANNER = new Scanner(System.in);

  public static void maxSum(int[] nums) {
    int minLeft = Integer.MAX_VALUE;
    int maxRight = Integer.MIN_VALUE;

    int left = 0;

    int maxSum = nums[0];
    int sum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      sum += nums[i];

      if (sum < nums[i]) {
        sum = nums[i];
        left = i;
      }

      if (sum > maxSum) {
        maxSum = sum;
        minLeft = left;
        maxRight = i;
      } else if (sum == maxSum) {
        minLeft = Math.min(minLeft, left);
        maxRight = Math.max(maxRight, i);
      }
    }
  }

  public static void main(String[] args) {
//    int size = SCANNER.nextInt();
//    int[] nums = new int[size];
//    int i = 0;
//    while (size > 0) {
//      nums[i++] = SCANNER.nextInt();
//      size--;
//    }

    maxSum(new int[]{2, -2, 3, -1, 5, -2, 7});
  }

}
