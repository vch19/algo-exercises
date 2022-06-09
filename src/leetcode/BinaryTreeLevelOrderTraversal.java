package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    int height = getHeight(root);

    for (int i = 1; i <= height; i++) {
      List<Integer> nodes = new ArrayList<>();
      getCurrentLevelNodes(root, i, nodes);
      result.add(nodes);
    }
    return result;
  }

  public static List<List<Integer>> levelOrderEffective(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> nodes = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        nodes.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      result.add(nodes);
    }

    return result;
  }

  private static void getCurrentLevelNodes(TreeNode root, int level, List<Integer> nodes) {
    if (root == null) {
      return;
    }
    if (level == 1) {
      nodes.add(root.val);
    } else if (level > 1) {
      getCurrentLevelNodes(root.left, level - 1, nodes);
      getCurrentLevelNodes(root.right, level - 1, nodes);
    }
  }

  private static int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = getHeight(root.left);
    int right = getHeight(root.right);

    if (left > right) {
      return left + 1;
    }
    return right + 1;
  }

  public static void main(String[] args) {
    System.out.println(levelOrderEffective(
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
  }
}
