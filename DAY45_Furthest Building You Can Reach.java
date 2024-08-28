// You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
// You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
// Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int bricksUsed = 0;
        for(int i=1; i<n; i++){
            int diff = heights[i]-heights[i-1];
            if(diff>0){
                pq.add(diff);
                if(pq.size()>ladders){
                    bricksUsed+=pq.remove();
                }
                if(bricksUsed>bricks){
                    return i-1;
                }
            }
        }
        return n-1;
        
    }
}
