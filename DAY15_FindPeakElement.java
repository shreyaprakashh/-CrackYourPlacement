// Given an array which contains integer values, we need to make all values of this array equal to some integer value with minimum cost where the cost of changing an array value x to y is abs(x-y).
public class Solution {
    public static int computeCost(int arr[], int N,int X)
    {
        int cost = 0;
        for (int i = 0; i < N; i++)
            cost += Math.abs(arr[i] - X);
        return cost;
    }
 
    public static int minCostToMakeElementEqual(int arr[], int N)
    {
        int low, high;
        low = high = arr[0];
        for (int i = 0; i < N; i++) {
            if (low > arr[i])
                low = arr[i];
            if (high < arr[i])
                high = arr[i];
        }
        while ((high - low) > 2) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
 
            int cost1 = computeCost(arr, N, mid1);
            int cost2 = computeCost(arr, N, mid2);

            if (cost1 < cost2)
                high = mid2;
 
            else
                low = mid1;
        }
        return computeCost(arr, N, (low + high) / 2);
    }
