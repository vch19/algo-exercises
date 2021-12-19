package cci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairsWithKDifference {

  //Time complexity: O(n), space complexity: O(n)
  public static List<int[]> findPairs(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    List<int[]> pairs = new ArrayList<>();

    for (int num : nums) {
      set.add(num);
    }

    for (int num : nums) {
      if (set.contains(num + k)) {
        pairs.add(new int[]{num, num + k});
      }
    }

    return pairs;
  }

  public static void main(String[] args) {
    List<int[]> pairs = findPairs(new int[]{1, 7, 5, 9, 2, 12, 3}, 2);

    for (int[] pair : pairs) {
      System.out.println(Arrays.toString(pair));
    }
  }

}
