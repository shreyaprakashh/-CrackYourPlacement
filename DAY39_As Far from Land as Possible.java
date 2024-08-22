// Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. 
// If no land or water exists in the grid, return -1.

class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        LinkedList<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int dist = -1;
        while (!q.isEmpty()) {
            int j = q.size();

            while (j-- > 0) {
                int[] p = q.poll();
                for (int[] dir: dirs) {
                    int[] np = new int[]{dir[0] + p[0], dir[1] + p[1]};
                    if (np[0] >= 0 && np[1] >= 0 && np[0] < n && np[1] < n && grid[np[0]][np[1]] == 0) {
                        grid[np[0]][np[1]] = 1;
                        q.addLast(np);
                    }
                }
            }

            dist += 1;
        }

        return dist == 0 ? -1: dist;
    }
}
