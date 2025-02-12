// Given an integer array nums, return the length of the longest strictly increasing subsequence.
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] subsequenceLengths = new int[nums.length];
        subsequenceLengths[0] = 1;
        int maxLengthFound = 1;
        for (int curIdx = 1; curIdx < nums.length; curIdx++) {
            int curMax = 0;
            for (int prevIdx = curIdx - 1; prevIdx >= 0; prevIdx--) {
                if (nums[prevIdx] < nums[curIdx]) {
                    curMax = Math.max(subsequenceLengths[prevIdx], curMax);
                }
            }
            subsequenceLengths[curIdx] = curMax + 1;
            maxLengthFound = Math.max(subsequenceLengths[curIdx], maxLengthFound);
        }
        return maxLengthFound;
    }
}
