//Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
//A subarray is a contiguous part of an array.

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        
        mp.put(0, 1);
        
        int result = 0;
        
        for(int i = 0; i<nums.length ;i++) {
            sum += nums[i];
            
            int rem = sum%k;
            
            if(rem < 0) {
                rem += k;
            }
            
            if(mp.containsKey(rem)) {
                result += mp.get(rem);
            }
            
            mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }
        
        return result;
    }
}
