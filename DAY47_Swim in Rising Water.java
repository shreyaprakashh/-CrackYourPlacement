// You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
// Return the least time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

class Solution {

    static int[][] arr;
    static int n;
    static int dir[][] = {{0,1},{0,-1},{-1,0},{1,0}};

    static boolean helper(int x){
        if(arr[0][0]>x) return false;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int visited[][] = new int[n][n];
        visited[0][0] = 1;

        while(q.size()!=0){
            int a[] = q.remove();
            int r = a[0];
            int c = a[1];
            if(r==n-1 && c==n-1) return true;

            for(int i=0; i<4; i++){
                int nr = r+dir[i][0];
                int nc = c+dir[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && visited[nr][nc]!=1 && arr[nr][nc]<=x){
                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = 1;
                }
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        
        arr = grid;
        n = arr.length;
        int st = 0;
        int end = 2505;
        int ans = -1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(helper(mid)){
                ans = mid;
                end = mid-1;
            }else st = mid+1;
        }
        return ans;
    }
}
