package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {

  public static int[] intersect(int[] a, int[] b) {
    Map<Integer, Integer> frequency = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    for (int k : a) {
      frequency.put(k, frequency.getOrDefault(k, 0) + 1);
    }

    for (int j : b) {
      if (frequency.containsKey(j) && frequency.get(j) > 0) {
        result.add(j);
        frequency.put(j, frequency.get(j) - 1);
      }
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
  }
}
