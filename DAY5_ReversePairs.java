//Given an integer array nums, return the number of reverse pairs in the array.
//A reverse pair is a pair (i, j) where:
//1. 0 <= i < j < nums.length and
//2. nums[i] > 2 * nums[j].

class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length; 
        return mergeSort(nums,0,n-1);
    }
    
    private int mergeSort(int[]nums,int strtIdx, int endIdx){

        if (strtIdx>=endIdx){
            return 0;
        }
        int count = 0; 
        int mid = strtIdx + (endIdx - strtIdx)/2; 
        count +=mergeSort(nums,strtIdx,mid); 
        count +=mergeSort(nums,mid+1,endIdx);
        count +=merge(nums,strtIdx,mid,endIdx);
        return count;
    }
    private int merge(int[]nums,int strtIdx,int mid, int endIdx){ 
        int count = 0;
        int[]a = new int[endIdx-strtIdx+1];
        int index = 0;
        int i = strtIdx,j = mid+1;
        while(i<=mid && j<= endIdx){
            if((long) nums[i] > 2*(long) nums[j]){
                count+= mid - i+1; 
                j++;
            }
            else
            {
                i++;
            }
        }
         
        i = strtIdx;
        j = mid +1 ;
        while (i<= mid && j <= endIdx) {
            if(nums[i]>nums[j]){
                a[index++] = nums[j++];
            }
            else {
                a[index++] = nums[i++];
            }


        }
        while (i <= mid ){
            a[index++]=nums[i++];
        }
        while (j <= endIdx){
            a[index++] = nums[j++];
        }
        System.arraycopy(a,0,nums,strtIdx,endIdx-strtIdx+1);
        return count ;
    }


}
