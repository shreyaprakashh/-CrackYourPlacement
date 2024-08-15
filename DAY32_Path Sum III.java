// Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
    return solve(root, targetSum, new ArrayList<>(), 0);
    }

    private int solve(TreeNode root, int targetSum, ArrayList<TreeNode> path, long currentSum) {
        if (root == null) {
            return 0;
        }

        path.add(root);
        currentSum += root.val;

        int count = 0;
        long sum = 0;

        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).val;
            if (sum == targetSum) {
                count++;
            }
        }

        count += solve(root.left, targetSum, path, currentSum);
        count += solve(root.right, targetSum, path, currentSum);


        path.remove(path.size() - 1);
        currentSum -= root.val;

        return count;
    }

}
