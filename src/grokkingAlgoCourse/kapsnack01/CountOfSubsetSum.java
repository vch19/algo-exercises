package grokkingAlgoCourse.kapsnack01;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubsetSum {

  public static int subarraySum(int[] nums, int k) {
    int subarrays = 0;
    int sum = 0;
    Map<Integer, Integer> memo = new HashMap<>();
    memo.put(0, 1);

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (memo.containsKey(sum - k)) {
        subarrays += memo.get(sum - k);
      }
      memo.put(sum, memo.getOrDefault(sum, 0) + 1);
    }

    return subarrays;
  }

  public static int subarraySum2(int[] nums, int k) {
    int[][] dp = new int[nums.length][k + 1];

    for (int i = 0; i < dp.length; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i < dp[0].length; i++) {
      dp[0][i] = nums[0] == i ? 1 : 0;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        dp[i][j] = dp[i - 1][j];

        if (j >= nums[i]) {
          dp[i][j] += dp[i - 1][j - nums[i]];
        }
      }
    }

    return dp[dp.length - 1][k];
  }

  public static void main(String[] args) {
    System.out.println(subarraySum(new int[]{1, 1, 2, 3}, 4));
//    System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
//    System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
//    System.out.println(subarraySum(new int[]{1, 1, 1}, 1));
//    System.out.println(subarraySum(new int[]{1, 1, 1}, 3));
  }
}
