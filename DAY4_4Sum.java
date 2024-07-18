//Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();

        
        if (start == nums.length) {
            return result;
        }

        long average_value = target / k;

    
        if (
            nums[start] > average_value || average_value > nums[nums.length - 1]
        ) {
            return result;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(
                    nums,
                    target - nums[i],
                    i + 1,
                    k - 1
                )) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(subset);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        int low = start, high = nums.length - 1;

        while (low < high) {
            int currSum = nums[low] + nums[high];
            if (currSum < target || (low > start && nums[low] == nums[low - 1])) {
                ++low;
            } else if (
                currSum > target ||
                (high < nums.length - 1 && nums[high] == nums[high + 1])
            ) {
                --high;
            } else {
                result.add(Arrays.asList(nums[low++], nums[high--]));
            }
        }

        return result;
    }
}
