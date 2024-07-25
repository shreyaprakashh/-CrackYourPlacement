//Given an array nums[] of size n, where nums[i] denotes the number of characters in one word. Let K be the limit on the number of characters that can be put in one line (line width). 
//Put line breaks in the given sequence such that the lines are printed neatly.
//Assume that the length of each word is smaller than the line width. When line breaks are inserted there is a possibility that extra spaces are present in each line. 
//The extra spaces include spaces put at the end of every line except the last one. 
//You have to minimize the following total cost where total cost = Sum of cost of all lines, where cost of line is = (Number of extra spaces in the line)2.
class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE); 
        dp[n] = 0;
        for(int i=n-1; i>=0; i--) {
            int sum = 0;
            for(int j=i; j<n && sum + nums[j]<=k; j++) {
                sum += nums[j];
                int spaces = (j != n-1) ? k-sum : 0;
                dp[i] = Math.min(dp[i], spaces*spaces+dp[j+1]);
                sum++;
            }
        } 
        return dp[0];
    }
}
