package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
  public static int deleteAndEarn(int[] nums) {
    Map<Integer, Integer> memo = new HashMap<>();
    int max = 0;

    for (int num : nums) {
      memo.put(num, memo.getOrDefault(num, 0) + num);
      max = Math.max(max, num);
    }

    int[] maxPoints = new int[max + 1];
    maxPoints[1] = memo.getOrDefault(1, 0);

    for (int i = 2; i < maxPoints.length; i++) {
      int gain = memo.getOrDefault(i, 0);
      maxPoints[i] = Math.max(maxPoints[i - 1], maxPoints[i - 2] + gain);
    }

    return maxPoints[max];
  }

  public static void main(String[] args) {
    System.out.println(deleteAndEarn(new int[] {3, 4, 2}));
  }
}
