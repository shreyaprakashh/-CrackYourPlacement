// A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
// The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
// Return the number of minutes needed to inform all the employees about the urgent news.
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            if(manager[i]!=-1)
                adj.get(manager[i]).add(i);
        }

        int ans[]={0};
        int maxi[]={0};
        dfs(headID,adj,informTime,ans,maxi);
        return maxi[0];
    }

    public void dfs(int manager,ArrayList<ArrayList<Integer>>adj,int[] informTime,int[]ans,int []maxi){
        maxi[0]=Math.max(ans[0],maxi[0]);

        for(int emp:adj.get(manager)){
            ans[0]+=informTime[manager];
            dfs(emp,adj,informTime,ans,maxi);
            ans[0]-=informTime[manager];
        }
    }
}
