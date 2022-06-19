package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KRadiusSubarrayAverages {

  public static int[] getAverages(int[] nums, int k) {
    if (k == 0) {
      return nums;
    }
    Map<Integer, Long> sum = new HashMap<>();
    sum.put(0, (long) nums[0]);

    for (int i = 1; i < nums.length; i++) {
      sum.put(i, sum.get(i - 1) + nums[i]);
    }

    int[] result = new int[nums.length];
    Arrays.fill(result, -1);

    for (int i = k; i < nums.length - k; i++) {
      long temp = (sum.get(i + k) - sum.getOrDefault(i - k - 1, 0L)) / (k * 2L + 1);
      result[i] = (int) temp;
    }

    return result;
  }

  public static void main(String[] args) {
//    System.out.println(Arrays.toString(
//        getAverages(new int[]{56725, 48784, 74934, 6772, 98570, 96847, 46483, 6592, 62552}, 1)));
    System.out.println(Arrays.toString(getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));
    System.out.println(Arrays.toString(getAverages(new int[]{100000}, 1)));
    System.out.println(Arrays.toString(getAverages(new int[]{100000}, 0)));
    System.out.println(Arrays.toString(getAverages(new int[]{8}, 100000)));
  }
}
