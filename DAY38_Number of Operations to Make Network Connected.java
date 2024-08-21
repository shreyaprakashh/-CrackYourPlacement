// You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.
// Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : connections) {
            adjList.putIfAbsent(edge[0], new ArrayList<>());
            adjList.putIfAbsent(edge[1], new ArrayList<>());
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int islands = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            islands += dfs(i, adjList, visited);
        return islands - 1;
    }

    private int dfs(int i, Map<Integer, List<Integer>> adjList, boolean[] visited) {
        if (visited[i]) return 0;
        visited[i] = true;

        for (int neighbour : adjList.getOrDefault(i, Collections.emptyList()))
            dfs(neighbour, adjList, visited);

        return 1;
    }
}
