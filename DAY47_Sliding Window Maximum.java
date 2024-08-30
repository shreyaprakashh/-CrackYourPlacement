// You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
// Return the max sliding window.

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
     
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < nums.length; i++) {
          
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
           
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = nums[q.peek()];
            }
        }
        return r;  
    }
}
