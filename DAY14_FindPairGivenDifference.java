// Given an array arr[] of size n and an integer x, return 1 if there exists a pair of elements in the array whose absolute difference is x, otherwise, return -1.
class Solution {
    public int findPair(int n, int x, int[] arr) {
        // code here
        HashSet<Integer> set = new HashSet<>();
    
        for(int i=0; i<n; i++){
          if (set.contains(arr[i] - x) || set.contains(arr[i] + x)) 
            return 1;
            else set.add(arr[i]);
        }
        return -1;
    }
}
