package leetcode;

public class CountNodesEqualToAverageOfSubtree {

  public static int averageOfSubtree(TreeNode root) {
    return helper(root)[2];
  }

  private static int[] helper(TreeNode root) {
    if (root == null) {
      return new int[]{0, 0, 0};
    }

    int count = 1, sum = root.val, res = 0;

    if (root.left != null) {
      int[] left = helper(root.left);
      count += left[0];
      sum += left[1];
      res += left[2];
    }

    if (root.right != null) {
      int[] right = helper(root.right);
      count += right[0];
      sum += right[1];
      res += right[2];
    }

    if (root.val == sum / count) {
      res += 1;
    }

    return new int[] {count, sum, res};
  }

  public static void main(String[] args) {
    System.out.println(averageOfSubtree(
        new TreeNode(4, new TreeNode(8, new TreeNode(0), new TreeNode(1)),
            new TreeNode(5, null, new TreeNode(6)))));

    System.out.println(averageOfSubtree(new TreeNode(1)));
  }
}
