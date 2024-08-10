// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) {
            return false;
        }
        if(helper(root,subRoot)) {
            return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean helper(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) {
            return true;
        }
        if(root==null || subRoot==null) {
            return false;
        } 
        if(root.val!=subRoot.val) {
            return false;
        }
        return helper(root.left,subRoot.left) && helper(root.right,subRoot.right);
    }
}
