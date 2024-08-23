// There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1, which is expressed as a pair: [0, 1]
// Given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.

class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        int[] vis = new int[N];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < P; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < N; i++) {
            if (dfs(i, adj, vis) == true) {
                return false;
            }
        }

        return true;
    }
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;

        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis) == true) {
                    return true;
                }
            } else if (vis[i] == 1) {
                return true;
            }
        }

        vis[node] = 2;
        return false;
    }
    
}
