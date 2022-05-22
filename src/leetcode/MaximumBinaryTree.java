package leetcode;

public class MaximumBinaryTree {

  public static TreeNode constructMaximumBinaryTree(int[] nums) {
    TreeNode tree = new TreeNode();
    build(tree, nums);
    return tree;
  }

  private static void build(TreeNode tree, int[] nums) {
    int max = getMax(nums);

    tree.val = nums[max];

    int[] left = new int[max];
    System.arraycopy(nums, 0, left, 0, max);
    int[] right = new int[nums.length - max - 1];
    System.arraycopy(nums, max + 1, right, 0, nums.length - max - 1);

    if (left.length != 0) {
      tree.left = new TreeNode();
      build(tree.left, left);
    }
    if (right.length != 0) {
      tree.right = new TreeNode();
      build(tree.right, right);
    }
  }

  private static int getMax(int[] numbers) {
    int index = 0;

    for (int i = 0; i < numbers.length; i++) {
      index = numbers[i] > numbers[index] ? i : index;
    }

    return index;
  }

  public static void main(String[] args) {
    constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
  }
}
