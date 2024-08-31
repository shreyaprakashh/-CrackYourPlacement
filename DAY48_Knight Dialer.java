// Given an integer n, return how many distinct phone numbers of length n we can dial.
// class Solution {
    public int knightDialer(int n) {
        int[][] dp = new int[n][10];
        int MOD = 1000000007;
        int ans = 0;
        
        for(int i = 0 ; i < 10 ; i++)
        {
            dp[0][i] = 1;
        }

        for(int i = 1 ; i < n ; i ++)
        {
            dp[i][0] = (dp[i-1][4]+dp[i-1][6])%MOD;
            dp[i][1] = (dp[i-1][6]+dp[i-1][8])%MOD;
            dp[i][2] = (dp[i-1][7]+dp[i-1][9])%MOD;
            dp[i][3] = (dp[i-1][4]+dp[i-1][8])%MOD;
            dp[i][4] = (((dp[i-1][0]+dp[i-1][3])%MOD)+dp[i-1][9])%MOD;
            dp[i][5] = 0;
            dp[i][6] = (((dp[i-1][0]+dp[i-1][1])%MOD)+dp[i-1][7])%MOD;
            dp[i][7] = (dp[i-1][2]+dp[i-1][6])%MOD;
            dp[i][8] = (dp[i-1][1]+dp[i-1][3])%MOD;
            dp[i][9] = (dp[i-1][2]+dp[i-1][4])%MOD;
        }

        for(int i = 0 ; i < 10 ; i++)
        {
            ans = (ans+dp[n-1][i])%MOD;
        }
        
        return ans;
    }
}
