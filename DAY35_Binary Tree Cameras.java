// You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.
// Return the minimum number of cameras needed to monitor all nodes of the tree.

class Solution {
    int camera = 0;
    public int minCameraCover(TreeNode root) {
        camera = 0;
        int ans = solve(root);
        return (ans == 0) ? ++camera:camera;
    }

    private int solve(TreeNode root) {
        if(root == null) return 1;

        int left = solve(root.left);
        int right = solve(root.right);

        if(left == 0 || right == 0) {
            camera++;
            return 2;
        }

        if(left == 1 && right == 1) {
            return 0;
        }

        if(left == 2 || right == 2) {
            return 1;
        }

        return -1;
    }
}
