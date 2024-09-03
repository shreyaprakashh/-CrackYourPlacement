// Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches to keys[i]. 
// Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.

class Solution
{
    static int optimalSearchTree(int keys[], int freq[], int n)
    {
        // code here
        int[][] dp = new int[n][n];
        int[] sum = new int[n]; 
        sum[0] = freq[0];
        for(int i = 1;i<n;i++){
            sum[i]=sum[i-1]+freq[i];
        }
        for(int g = 0;g<n;g++){
            for(int i = 0,j = g;j<n;j++,i++){
                if(g==0){
                    dp[i][j] = freq[j];
                }else if(g==1){
                    dp[i][j] = Math.min(freq[i]+freq[j]*2,freq[i]*2+freq[j]);
                }else{
                    int prifix = i-1<0? 0:sum[i-1];
                    int freqS = sum[j]-prifix;
                    
                    int min = Integer.MAX_VALUE;
                    for(int k = i;k<=j;k++){
                        int left = k==i? 0 :dp[i][k-1];
                        int right =k==j?0: dp[k+1][j];
                        if(left+right+freqS<min){
                            min = left+right+freqS;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n-1];
    }
    
    
}
