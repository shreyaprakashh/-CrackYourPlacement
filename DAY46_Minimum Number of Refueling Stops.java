// A car travels from a starting position to a destination which is target miles east of the starting position.
// Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
    for (int[] p : points) {
        pq.offer(p);
        if (pq.size() > k) {
            pq.poll();
        }
    }
    int[][] res = new int[k][2];
    while (k > 0) {
        res[--k] = pq.poll();
    }
    return res;
    }
}
