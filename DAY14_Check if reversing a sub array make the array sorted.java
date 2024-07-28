//Given an array of n distinct integers. 
//The task is to check whether reversing any one sub-array can make the array sorted or not. 
//If the array is already sorted or can be made sorted by reversing any one subarray, print “Yes“, else print “No“.
class Solution{ 
  
    static boolean checkReverse(int arr[], int n) { 
       
        int temp[] = new int[n]; 
        for (int i = 0; i < n; i++) { 
            temp[i] = arr[i]; 
        } 
  
       
        Arrays.sort(temp); 
  
       
        int front; 
        for (front = 0; front < n; front++) { 
            if (temp[front] != arr[front]) { 
                break; 
            } 
        } 
  
        
        int back; 
        for (back = n - 1; back >= 0; back--) { 
            if (temp[back] != arr[back]) { 
                break; 
            } 
        } 
  
        
        if (front >= back) { 
            return "Yes"; 
        } 
  
       
        do { 
            front++; 
            if (arr[front - 1] < arr[front]) { 
                return "No"; 
            } 
        } while (front != back); 
  
        return "Yes"; 
    } 
