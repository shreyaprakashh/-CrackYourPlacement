// Given an integer n denoting the Length of a line segment. 
// You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
// After performing all the cut operations, your total number of cut segments must be maximum. 
// Return the maximum number of cut segments possible.

class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = help(n,x,y,z,dp);
        return ans<0?0:ans;
    }
    int help(int n,int x,int y,int z,int dp[]){
        if(n<0)return Integer.MIN_VALUE;
        if(n==0)return 0;
        if(dp[n]!=-1)return dp[n];
        return dp[n]=1+Math.max(help(n-x,x,y,z,dp),Math.max(help(n-y,x,y,z,dp),help(n-z,x,y,z,dp)));
    }
    
}
