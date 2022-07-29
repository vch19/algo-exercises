package leetcode;

import java.util.Arrays;

public class FindTwoNonOverlappingSubarraysEachWithTargetSum {

  public static int minSumOfLengths(int[] nums, int target) {
    int[] prefix = new int[nums.length];
    Arrays.fill(prefix, Integer.MAX_VALUE);
    int[] suffix = new int[nums.length];
    Arrays.fill(suffix, Integer.MAX_VALUE);

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6));
  }
}
