//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.


class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int maxArea = 0;
        int[] stack = new int[heights.length + 1];
        int top = -1;
        
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            while (top >= 0 && h < heights[stack[top]]) {
                int height = heights[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++top] = i;
        }
        
        return maxArea;
    }
}
