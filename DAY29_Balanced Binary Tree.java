// Given a binary tree, determine if it is height-balanced.
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(fun(root)!=-1){
            return true;
        }
        return false;
    }
    
    public int fun(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = fun(root.left);
        int right = fun(root.right);
        if(left == -1 || right ==-1){
            return -1;
        }
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
