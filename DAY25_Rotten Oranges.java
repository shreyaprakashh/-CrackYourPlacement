// Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
// 0 : Empty cell
// 1 : Cells have fresh oranges
// 2 : Cells have rotten oranges
// We have to determine what is the earliest time after which all the oranges are rotten. 
// A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.

class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        Queue<int[]> q=new LinkedList<>();
        
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}},freshCount=0,timeTaken=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]==1) freshCount++;
            }
        }
        
        if(freshCount==0) return 0;
        
        while(!q.isEmpty()){
            int n=q.size();
            for(int j=0;j<n;j++){
                int[] curr=q.poll(); 
                for(int i=0;i<4;i++){
                    int nr=curr[0]+dir[i][0],nc=curr[1]+dir[i][1]; 
                    if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1){ 
                        grid[nr][nc]=2; 
                        q.add(new int[]{nr,nc}); 
                        freshCount--; 
                    }
                }
            }
            timeTaken++;
        }
        return freshCount==0?timeTaken-1:-1;
    }
}
