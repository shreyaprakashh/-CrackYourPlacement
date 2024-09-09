// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            
            if (i > 0 && nums[i] == nums[i-1]) {
                start = end + 1;
            }
            end = output.size() - 1;
            int n = output.size();
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(output.get(j));
                internal.add(nums[i]);
                output.add(internal);
            }
        }
        return output;
    }
}
