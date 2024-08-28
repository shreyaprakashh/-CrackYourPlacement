// Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<matrix.length;i++)

            for(int j=0;j<matrix[0].length;j++)

                pq.add(matrix[i][j]);

        while(k-- > 1)

            pq.poll();

        return pq.poll();
    }
}
