// Given the root of a binary tree, return its maximum depth.
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
        return 0;
        return (1+Math.max(maxDepth(root.left),maxDepth(root.right)));
    }
}
