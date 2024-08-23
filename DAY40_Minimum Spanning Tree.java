// Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. 
// The graph is represented by an adjacency list, where each element adj[i] is a vector containing vector of integers.
// Each vector represents an edge, with the first integer denoting the endpoint of the edge and the second integer denoting the weight of the edge.
class Solution {
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
       Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
       boolean vis[] = new boolean[V];
       Arrays.fill(vis, false);
       
       int result = 0;
       pq.add(new int[]{0, 0});
       
       while (!pq.isEmpty())
       {
           
           int wt = pq.peek()[0];
           int node = pq.poll()[1];
           
           if (vis[node]) continue;
           
           vis[node] = true;
           result += wt;
           
           for (int[] neighbour: adj.get(node))
           {
               pq.add(new int[]{neighbour[1], neighbour[0]});
           }
           
       }
       
       return result;
    }
}
