// You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V]; 
        ArrayList<Integer> res = new ArrayList<>(); 
        dfs(0, visited, adj, res);
        
        return res;
    }
    
     private  void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        visited[node] = true;
        res.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, res);
            }
        }
    }
}
