package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {
  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> preorder = new ArrayList<>();
    buildPreorderArray(root, preorder);
    return preorder;
  }

  private static void buildPreorderArray(TreeNode root, List<Integer> preorder) {
    if (root == null) {
      return;
    }

    preorder.add(root.val);

    buildPreorderArray(root.left, preorder);
    buildPreorderArray(root.right, preorder);
  }

  public static void main(String[] args) {
    System.out.println(preorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
  }
}
