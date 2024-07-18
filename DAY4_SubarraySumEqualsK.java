//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//A subarray is a contiguous non-empty sequence of elements within an array.

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
		mp.put(0,1);
		int ans = 0;
		int sum = 0;
		for(int i =0;i<nums.length;i++){

			sum += nums[i];
			if(mp.containsKey(sum- k)){
				ans += mp.get(sum-k);
			}

			mp.put(sum, mp.getOrDefault(sum,0)+1);
		}
		return ans;
    }
}
