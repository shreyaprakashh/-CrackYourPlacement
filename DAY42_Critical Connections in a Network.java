// There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. 
// Any server can reach other servers directly or indirectly through the network.
// A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
// Return all critical connections in the network in any order.

class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (List<Integer> edge: connections) {
            int node1 = edge.get(0);
            int node2 = edge.get(1);
            
            g.putIfAbsent(node1, new ArrayList<>());
            g.get(node1).add(node2);
            
            g.putIfAbsent(node2, new ArrayList<>());
            g.get(node2).add(node1);
        }
        
        
        int[] timestamps = new int[n];
        helper(g, 0, 0, 1, timestamps);
        
        return result;
    }
    
    private int helper(Map<Integer, List<Integer>> g, int curr, int parent, int ts, int[] timestamps) {
        timestamps[curr] = ts;
        for (int nextNode: g.get(curr)) {
            
            if (nextNode == parent) continue;
            
            
            if (timestamps[nextNode] > 0)
                timestamps[curr] = Math.min(timestamps[curr], timestamps[nextNode]);
            else
                
                timestamps[curr] = Math.min(timestamps[curr], helper(g, nextNode, curr, ts + 1, timestamps));
            
            
            if (ts < timestamps[nextNode])
                result.add(Arrays.asList(curr, nextNode));
        }
        
        return timestamps[curr];
    }
}
