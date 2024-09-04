// Given a string s. In one step you can insert any character at any index of the string.
// Return the minimum number of steps to make s palindrome.

class Solution {
    public int minInsertions(String s) {
        String s1 = s;
        StringBuffer sb = new StringBuffer(s);
        String s2 = sb.reverse().toString();
        int n = s1.length();
        int m =s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n-dp[n][m];
    }
}
