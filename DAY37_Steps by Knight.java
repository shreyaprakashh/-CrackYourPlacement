// Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    class Value{
       int row;
       int col;
       int dist;
       
       Value(int row,int col,int dist){
           this.row=row;
           this.col=col;
           this.dist=dist;
       }
    }
    
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int ans=Integer.MAX_VALUE;
        int[][] matrix=new int[N][N];
        matrix[TargetPos[1]-1][TargetPos[0]-1]=-2;
        matrix[KnightPos[1]-1][KnightPos[0]-1]=-1;
        Queue<Value> dq=new LinkedList<>();
        boolean[][] visited=new boolean[N][N];
        
        dq.offer(new Value(KnightPos[1]-1,KnightPos[0]-1,0));
        
        while(!dq.isEmpty()){
            Value val=dq.poll();
            int row=val.row;
            int col=val.col;
            int dist=val.dist;
            if(row==TargetPos[1]-1 && col==TargetPos[0]-1) {
                ans=Math.min(ans,dist);
                break;
            }
            int dx[] = {1,2,-1,-2,1,-1,2,-2};
            int dy[] = {2,1,-2,-1,-2,2,-1,1};
            
            for(int i=0; i<8; i++){
                int drow=dx[i]+row;
                int dcol=dy[i]+col;
                
                if(drow>=0 && drow<N && dcol>=0 && dcol<N){
                    if(!visited[drow][dcol]){
                    visited[drow][dcol]=true;
                    dq.offer(new Value(drow,dcol,dist+1));
                    }
                }
            }
            
            
            
        }
        
        return ans;
        
    }
}
