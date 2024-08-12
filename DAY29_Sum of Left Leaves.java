// Given the root of a binary tree, return the sum of all left leaves.
class Solution {
     public int solve(TreeNode curr, boolean isLeft) {
        if (curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null && isLeft) {
            return curr.val;
        }

        return solve(curr.left, true) + solve(curr.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root, false);
    }
}
