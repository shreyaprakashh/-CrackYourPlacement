// Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return addBst(1, n, dp);
    }

    public List<TreeNode> addBst(int low, int high, List<TreeNode>[][] dp) {
        if (low > high) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        if (dp[low][high] != null) {
            return dp[low][high];
        }

        List<TreeNode> list = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftSubtree = addBst(low, i - 1, dp);
            List<TreeNode> rightSubtree = addBst(i + 1, high, dp);

            for (TreeNode left : leftSubtree) {
                for (TreeNode right : rightSubtree) {
                    list.add(new TreeNode(i, left, right));
                }
            }
        }
        return dp[low][high] = list;
    }
}
