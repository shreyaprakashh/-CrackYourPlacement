// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
class Solution {
    List<Integer> inorder = new ArrayList<>();
	
    public int kthSmallest(TreeNode root, int k) {
        printInorder(root, k);
        return inorder.get(k-1);
    }
	
    public void printInorder(TreeNode root, int k) {
        if(root != null && inorder.size() < k) {
            printInorder(root.left, k);
            inorder.add(root.val);
            printInorder(root.right, k);
        }
    }
}
