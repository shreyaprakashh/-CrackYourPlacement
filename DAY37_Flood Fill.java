// An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
// You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
// Return the modified image after performing the flood fill.
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       
        if(image[sr][sc] == color) return image;
        
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void fill(int[][] image, int sr, int sc, int color, int cur) {
        
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) return;
        
        if(cur != image[sr][sc]) return;
        
        image[sr][sc] = color;
        
        fill(image, sr-1, sc, color, cur);
        fill(image, sr+1, sc, color, cur);
        fill(image, sr, sc-1, color, cur);
        fill(image, sr, sc+1, color, cur);
    }
}
