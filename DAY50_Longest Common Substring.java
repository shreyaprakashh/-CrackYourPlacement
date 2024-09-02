// You are given two strings str1 and str2. Your task is to find the length of the longest common substring among the given strings.
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        int ans=0;
        for(int i=0; i<str1.length(); i++){
            for(int j=0; j<str2.length(); j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                    ans = Math.max(ans, dp[i+1][j+1]);
                }
            }
        }
        return ans;
    }
}
