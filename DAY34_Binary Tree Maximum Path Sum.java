// Given the root of a binary tree, return the maximum path sum of any non-empty path.
class Solution {
    int max = Integer.MIN_VALUE;
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        max = Math.max(max, left+right+root.val);
        return Math.max(left, right) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
}
