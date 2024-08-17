// You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
// Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.

class Solution {
    private long resultBaseNode = 0;
    private int[] count;
    private int N;
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        N = n;
        count = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        resultBaseNode = 0;
        dfsBase(adj, 0, -1, 0);

        int[] result = new int[n];
        result[0] = (int) resultBaseNode;
        dfs(adj, 0, -1, result);
        return result;
    }
    
    private int dfsBase(Map<Integer, List<Integer>> adj, int currNode, int prevNode, int currDepth) {
        int totalNode = 1;
        resultBaseNode += currDepth;
        for (int child : adj.getOrDefault(currNode, new ArrayList<>())) {
            if (child == prevNode) continue;
            totalNode += dfsBase(adj, child, currNode, currDepth + 1);
        }
        count[currNode] = totalNode;
        return totalNode;
    }

    private void dfs(Map<Integer, List<Integer>> adj, int parentNode, int prevNode, int[] result) {
        for (int child : adj.getOrDefault(parentNode, new ArrayList<>())) {
            if (child == prevNode) continue;
            result[child] = result[parentNode] - count[child] + (N - count[child]);
            dfs(adj, child, parentNode, result);
        }
    }
}
