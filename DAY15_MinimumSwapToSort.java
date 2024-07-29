// Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.
class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public void swap(int[] arr, int x, int y)
    {
        int temp= arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    } 
    
    public int minSwaps(int nums[])
    {
        // Code here
        int count=0;
        int n=nums.length;
        HashMap<Integer, Integer> mp= new HashMap<>();
        for(int x=0;x<n;x++)
            mp.put(nums[x],x);
        Arrays.sort(nums);
        
        for(int x=0; x<n; x++)
        {
            if(x == mp.get(nums[x]))
                continue;
            else
            {
                count++;
                swap(nums,x,mp.get(nums[x]));
                x--;
            }
        }
        return count;
        
    }
}
