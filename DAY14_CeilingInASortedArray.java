//Given a sorted array and a value x, the ceiling of x is the smallest element in an array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. 
//Assume that the array is sorted in non-decreasing order. 
//Write efficient functions to find the floor and ceiling of x. 
class Solution
{
    
    static int ceilSearch(int arr[], int low, int high, int x)
    {
      int i;    
      
      
      if(x <= arr[low])
        return low;  
      
      
      for(i = low; i < high; i++)
      {
        if(arr[i] == x)
          return i;
      
        
        if(arr[i] < x && arr[i+1] >= x)
           return i+1;
      }         
      
      
      return -1;
    }
      
