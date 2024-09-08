// Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int c = 0;
        int end = intervals[0][1]; 

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                c++;
            } else {
                end = intervals[i][1];
            }
        }

        return c;
    }
}
