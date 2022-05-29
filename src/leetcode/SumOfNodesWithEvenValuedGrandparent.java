package leetcode;

public class SumOfNodesWithEvenValuedGrandparent {

  private static int result = 0;

  public static int sumEvenGrandparent(TreeNode root) {
    result = 0;
    recursion(root);
    return result;
  }

  public static void recursion(TreeNode root) {
    if (root == null) {
      return;
    }

    if (root.val % 2 == 0) {
      result += calculate(root);
    }
    recursion(root.left);
    recursion(root.right);
  }

  private static int calculate(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int result = 0;

    TreeNode leftChildren = root.left;
    TreeNode rightChildren = root.right;

    if (leftChildren != null) {
      if (leftChildren.left != null) {
        result += leftChildren.left.val;
      }
      if (leftChildren.right != null) {
        result += leftChildren.right.val;
      }
    }

    if (rightChildren != null) {
      if (rightChildren.left != null) {
        result += rightChildren.left.val;
      }
      if (rightChildren.right != null) {
        result += rightChildren.right.val;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(sumEvenGrandparent(new TreeNode(6,
        new TreeNode(7, new TreeNode(2, new TreeNode(9), null),
            new TreeNode(7, new TreeNode(1), new TreeNode(4))),
        new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))))));
  }
}
