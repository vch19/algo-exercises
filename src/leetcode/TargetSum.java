package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {

  public static int findTargetSumWays(int[] nums, int target) {
    List<Integer> result = new ArrayList<>();
    recursion(nums, 0, 0, target, result);
    return result.size();
  }

  private static void recursion(int[] nums, int sum, int index, int target, List<Integer> result) {
    if (sum == target) {
      result.add(1);
    }
    if (index >= nums.length || sum > target) {
      return;
    }

    recursion(nums, sum + nums[index], index + 1, target, result);
    recursion(nums, sum - nums[index], index + 1, target, result);
  }

  public static void main(String[] args) {
    findTargetSumWays(new int[] {1, 0}, 1);
  }
}
