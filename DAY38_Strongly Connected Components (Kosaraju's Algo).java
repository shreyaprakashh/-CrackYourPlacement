// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int count = 0;
        Stack<Integer> q = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]){
                norDFS(adj, vis, i, q);
            }
        }
        
        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reversedAdj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            for (int n: adj.get(i))
            reversedAdj.get(n).add(i);
        }
        
        Arrays.fill(vis, false);
        while (!q.isEmpty()) {
            int curr = q.pop();
            if (!vis[curr]) {
                revDFS(reversedAdj, vis, curr);
                count++;
            }
        }
        return count;
    }
    
    public void norDFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr, Stack<Integer> s) {
        vis[curr] = true;
        for (int n: adj.get(curr)) {
            if (!vis[n]) {
                norDFS(adj, vis, n, s);
            }
        }
        s.push(curr);
    }
    
    public void revDFS(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int curr) {
        vis[curr] = true;
        for (int n: adj.get(curr)) {
            if (!vis[n]) {
                revDFS(adj, vis, n);
            }
        }
    }
}
