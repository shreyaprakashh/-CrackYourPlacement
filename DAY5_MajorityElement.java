//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0], result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (result == 0) {
                result++;
                majority = nums[i];
            } 
            else if (majority == nums[i]) {
                result++;
            } 
            else result--;
        }
        return majority;
    }
}
