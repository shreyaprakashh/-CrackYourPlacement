//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.There is only one repeated number in nums, return this repeated number.

class Solution {
    public int findDuplicate(int[] nums) {
        int i = nums[0];
        int j = nums[0];

        do {
            i = nums[i];
            j = nums[nums[j]];
        } while (i != j);

        j = nums[0];
        while (i != j) {
            i = nums[i];
            j = nums[j];
        }

        return i;
    }
}
