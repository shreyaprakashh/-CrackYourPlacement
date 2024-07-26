//Given a matrix where every element is either ‘O’ or ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’.
//A ‘O’ (or a set of ‘O’) is considered to be surrounded by ‘X’ if there are ‘X’ at locations just below, just above, just left, and just right of it. 
class Solution
{
    static int M = 6;
    static int N = 6;
    static void floodFillUtil(char mat[][], int x, int y, char prevV, char newV)
    {
        
        if (x < 0 || x >= M || y < 0 || y >= N)
            return;
             
        if (mat[x][y] != prevV)
            return;
     
        
        mat[x][y] = newV;
     
        
        floodFillUtil(mat, x + 1, y, prevV, newV);
        floodFillUtil(mat, x - 1, y, prevV, newV);
        floodFillUtil(mat, x, y + 1, prevV, newV);
        floodFillUtil(mat, x, y - 1, prevV, newV);
    }
     
    
    static void replaceSurrounded(char mat[][])
    {
         
    
    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
            if (mat[i][j] == 'O')
                mat[i][j] = '-';
     
    
    for (int i = 0; i < M; i++) 
        if (mat[i][0] == '-')
            floodFillUtil(mat, i, 0, '-', 'O');
    for (int i = 0; i < M; i++) 
        if (mat[i][N - 1] == '-')
            floodFillUtil(mat, i, N -1, '-', 'O');
    for (int i = 0; i < N; i++) 
        if (mat[0][i] == '-')
            floodFillUtil(mat, 0, i, '-', 'O');
    for (int i = 0; i < N; i++)
        if (mat[M - 1][i] == '-')
            floodFillUtil(mat, M - 1, i, '-', 'O');
     
    
    for (int i = 0; i < M; i++)
        for (int j = 0; j < N; j++)
            if (mat[i][j] == '-')
                mat[i][j] = 'X';
    }
  return mat;
  }
}
