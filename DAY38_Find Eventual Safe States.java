// There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
// Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        final int n = graph.length;
        boolean[] safe = new boolean[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i, graph, visited, safe);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < safe.length; i++) {
            if (safe[i]) {
                res.add(i);
            }
        }

        return res;
    }

    
    private boolean dfs(int curr, int[][] graph, boolean[] visited, boolean[] safe) {
        if (visited[curr]) {
            return safe[curr];
        }

        visited[curr] = true;

        boolean isSafe = true;
        for (int next : graph[curr]) {
            isSafe &= dfs(next, graph, visited, safe);
        }

        safe[curr] = isSafe;
        return isSafe;
    }
}
