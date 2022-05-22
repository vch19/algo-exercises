package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepestLeavesSum {

  public static int deepestLeavesSum(TreeNode root) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    find(root, 0, map);
    int max = map.keySet().stream().max(Comparator.naturalOrder()).orElse(0);
    return map.get(max).stream().reduce(0, Integer::sum);
  }

  public static void find(TreeNode root, int lvl, Map<Integer, List<Integer>> map) {
    if (root == null) {
      return;
    }

    find(root.left, lvl + 1, map);
    find(root.right, lvl + 1, map);
    map.putIfAbsent(lvl, new ArrayList<>());
    map.get(lvl).add(root.val);
  }

  public static void main(String[] args) {
    var tree = new TreeNode(1,
        new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)),
        new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));

    System.out.println(deepestLeavesSum(tree));
  }
}
