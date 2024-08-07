// Given an array arr of positive integers, consider all binary trees such that:
// Each node has either 0 or 2 children;
// The values of arr correspond to the values of each leaf in an in-order traversal of the tree.
// The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.
// Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        int[][] max = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i ++) {
            int localMax = 0;
            for(int j = i; j < arr.length; j ++) {
                if(arr[j] > localMax) {
                    localMax = arr[j];
                }
                max[i][j] = localMax;
            }
        }
        for(int len = 1; len < arr.length; len ++) {
            for(int left = 0; left + len < arr.length; left ++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                if(len == 1) {
                    dp[left][right] = arr[left]*arr[right];
                } else {
                    for(int k = left; k < right; k ++) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k+1][right] + max[left][k]*max[k+1][right]);
                    }
                }
            }
        }
        return dp[0][arr.length-1];
    }
}
