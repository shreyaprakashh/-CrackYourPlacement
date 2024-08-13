// Given the root of a binary tree, return the inorder traversal of its nodes' values.
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        help(root, al);
        return al;
    }
    public void help(TreeNode root, ArrayList<Integer> al){
        if(root == null){
            return;
        }
        help(root.left, al);
        al.add(root.val);
        help(root.right, al);
    }
}
