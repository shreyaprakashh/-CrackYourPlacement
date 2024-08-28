// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
     Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            
            (a, b) -> b.getValue() - a.getValue()
     );
     for(int key:mp.keySet()){
         pq.offer(new Pair<Integer, Integer>(key, mp.get(key)));
        }
        int[] sum=new int[k]; 
        for(int i=0;i<k;i++){
            sum[i] = pq.poll().getKey();
        }
                
        return sum;
    }
}
