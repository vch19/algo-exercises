package leetcode;

//@task https://leetcode.com/problems/binary-tree-coloring-game/
public class BinaryTreeColoringGame {
    private int left;
    private int right;
    private int value;

    public boolean btreeGameWinningMove(TreeNode tree, int n, int x) {
        value = x;
        count(tree);
        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    private int count(TreeNode tree) {
        if (tree == null) {
            return 0;
        }

        int left = count(tree.left);
        int right = count(tree.right);

        if (tree.val == value) {
            this.left = left;
            this.right = right;
        }

        return left + right + 1;
    }

    public static void main(String[] args) {
        new BinaryTreeColoringGame().btreeGameWinningMove(new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5, new TreeNode(10), new TreeNode(11))),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))),
            11, 3);

        System.out.println(new BinaryTreeColoringGame().btreeGameWinningMove(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 3, 3));
    }
}

