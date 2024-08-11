// Given the roots of two binary trees p and q, write a function to check if they are the same or not.
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return false;
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
