// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }

        if(((p.val <= root.val) && ( q. val >= root.val)) || ((p.val >= root.val) && ( q. val <= root.val))){
            return root;
        }
        else if(((p.val > root.val) && (q.val  > root.val))){
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
