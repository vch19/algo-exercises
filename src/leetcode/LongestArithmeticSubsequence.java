package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {

//  public static int longestArithSeqLength(int[] nums) {
//    int longest = 2;
//
//    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
//
//    for (int i = 0; i < nums.length; i++) {
//      Map<Integer, Integer> bucket = new HashMap<>();
//      for (int j = 0; j < i; j++) {
//        int diff = nums[i] - nums[j];
//
//        bucket.put(diff, memo.get(j).getOrDefault(diff, 1) + 1);
//
//        longest = Math.max(longest, bucket.get(diff));
//      }
//      memo.put(i, bucket);
//    }
//
//    return longest;
//  }

  public static int longestArithSeqLength(int[] nums) {
    int longest = 2;

    Map<Integer, Integer>[] memo = new HashMap[nums.length];

    for (int i = 0; i < nums.length; i++) {
      Map<Integer, Integer> bucket = memo[i];
      for (int j = 0; j < i; j++) {
        int diff = nums[i] - nums[j];

        bucket.put(diff, memo[j].getOrDefault(diff, 1) + 1);

        longest = Math.max(longest, bucket.get(diff));
      }
    }

    return longest;
  }

  public static void main(String[] args) {
    System.out.println(longestArithSeqLength(new int[]{9, 4, 7, 2, 10})); //3
    System.out.println(longestArithSeqLength(new int[]{3, 6, 9, 12})); //4
    System.out.println(longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8})); //4
  }
}
