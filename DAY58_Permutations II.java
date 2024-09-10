// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
class Solution {
    Set<List<Integer>> list = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int n = nums.length;
        boolean[] bool = new boolean[n];
        solve(nums, arr, n, bool);
        return new ArrayList<>(list);
    }

    public void solve(int[] num, List<Integer> arr, int n, boolean[] bool) {
        if (arr.size() == n) {
            list.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!bool[i]) {
                bool[i] = true;
                arr.add(num[i]);
                solve(num, arr, n, bool);
                arr.remove(arr.size() - 1);
                bool[i] = false;
            }
        }
        return;
    }
}
