package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

  public static int subarraySum(int[] nums, int k) {
    int answer = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(sum, map.getOrDefault(sum, 0) + 1);
      sum += nums[i];

      if (map.containsKey(sum - k)) {
        answer += map.get(sum - k);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(subarraySum(new int[] {1, 2, 3}, 3)); //2
    System.out.println(subarraySum(new int[] {1, 1, 1}, 2)); //2
  }
}
