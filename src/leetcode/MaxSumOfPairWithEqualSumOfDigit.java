package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSumOfPairWithEqualSumOfDigit {

  public static int maximumSum(int[] nums) {
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      int sum = sum(num);

      if (map.containsKey(sum)) {
        max = Math.max(max, map.get(sum) + num);
      }
      map.put(sum, Math.max(map.getOrDefault(sum, 0), num));
    }

    return max;
  }

  public static int sum(int num) {
    int sum = 0;

    while (num != 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
  }
}
