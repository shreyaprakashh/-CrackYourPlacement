//You are given an array points containing the coordinates of points on a 2D plane, sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all 1 <= i < j <= points.length. You are also given an integer k.
//Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and 1 <= i < j <= points.length.
//It is guaranteed that there exists at least one pair of points that satisfy the constraint |xi - xj| <= k.
class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE; 
        int result = 0;
        int mod = 0;
        int flag = 1;
        for(int i = 0;i<points.length-1;i++) 
        {
            if(flag<i+1)
                flag = i+1;
            for(int j = flag;j<points.length;j++) 
			
            {
                mod = points[i][0]-points[j][0]; 
                if(mod<0)
                    mod = -mod;
                if(mod>k)
                    break;
                result = points[i][1]+points[j][1]+mod;  
                if(max<result)
                {
                    max = result; 
                    flag = j-1;
                }
            }
        }
        return max;
    }
}
