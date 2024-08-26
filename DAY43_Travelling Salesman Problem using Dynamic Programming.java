// Given a matrix cost of size n where cost[i][j] denotes the cost of moving from city i to city j. 
// Your task is to complete a tour from city 0 (0-based index) to all other cities such that you visit each city exactly once and then at the end come back to city 0 at minimum cost.

class Solution {
     public int total_cost(int[][] cost)  {
        int n=cost.length;
        return getMinCost(cost, new int[1<<n][n], n, 0, 1);
    }
    
    private int getMinCost(int[][] cost, int[][] dp, int n, int cur, int mask) {  
        if (mask==(1<<n)-1) {
            return cost[cur][0];
        }

        if (dp[mask][cur]==0) {
            dp[mask][cur]=Integer.MAX_VALUE;
            for (int i=0; i<n; i++) {
                if ((mask & (1<<i))==0) {
                    dp[mask][cur]=Math.min(dp[mask][cur], cost[cur][i]+getMinCost(cost, dp, n, i, mask|1<<i));
                }
            }
        }
        return dp[mask][cur];
    }
}
