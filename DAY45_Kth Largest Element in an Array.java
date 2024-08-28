// Given an integer array nums and an integer k, return the kth largest element in the array.
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq =new PriorityQueue<>(k);
    
        for(int num:nums){
            pq.add(num);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
