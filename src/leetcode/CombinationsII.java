package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationsII {

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Set<List<Integer>> combinations = new HashSet<>();
    backtracking(combinations, new ArrayList<>(), 0, candidates, target);
    return new ArrayList<>(combinations);
  }

  private static void backtracking(Set<List<Integer>> combinations, List<Integer> combination,
      int start, int[] candidates, int target) {
    if (target == 0) {
      combinations.add(new ArrayList<>(combination));
      return;
    }

    if (target < 0) {
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      combination.add(candidates[i]);
      backtracking(combinations, combination, i + 1, candidates, target - candidates[i]);
      combination.remove(Integer.valueOf(candidates[i]));
    }
  }

  public static void main(String[] args) {
    System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
  }

}
