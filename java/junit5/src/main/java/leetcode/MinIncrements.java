package leetcode;

public class MinIncrements {
    int increment = 0;
    int minIncrements(int n, int[] cost) {
        TreeNode root = genTree(cost, 0);
        postOrderTraversal(root);
        return increment;
    }

    TreeNode genTree(int[] cost, int i) {
        TreeNode root = null;
        if (i < cost.length) {
            root = new TreeNode(cost[i]);
            root.left = genTree(cost, 2 * i + 1);
            root.right = genTree(cost, 2 * i + 2);
        }
        return root;
    }

    int postOrderTraversal(TreeNode root) {
        if(root == null) return 0;

        int leftSum = postOrderTraversal(root.left);
        int rightSum = postOrderTraversal(root.right);

        increment += Math.abs(leftSum - rightSum);

        return Math.max(leftSum, rightSum) + root.val;
    }
}
