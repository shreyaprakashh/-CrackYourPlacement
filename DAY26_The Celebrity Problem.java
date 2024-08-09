// A celebrity is a person who is known to all but does not know anyone at a party. A party is being organized by some people.  
// A square matrix mat is used to represent people at the party such that if an element of row i and column j is set to 1 it means ith person knows jth person. 
// You need to return the index of the celebrity in the party, if the celebrity does not exist, return -1.
class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int ans=-1,j=0,n=mat.length;
        for(int i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(mat[i][j]==1)break;
            }
            if(j==n){
                for(j=0;j<n;j++){
                    if(i!=j && mat[j][i]==0)break;
                }
                if(j==n)ans=i;
                break;
            }
        }
        return ans;
    }
}
