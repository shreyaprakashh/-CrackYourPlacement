//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = target - nums[i];
            
            if (mp.containsKey(x)) {
                return new int[]{mp.get(x), i};
            }
            
            mp.put(nums[i], i);
        }

        return new int[]{};
    }
}
