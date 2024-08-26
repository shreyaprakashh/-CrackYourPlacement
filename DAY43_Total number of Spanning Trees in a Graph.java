// Given a connected undirected graph of N vertices and M edges. The task is the find the total number of spanning trees possible in the graph.
class Solution {
    public static int countSpanningTrees(int[][] graph,int n,int m) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int  i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
            for(int j=0;j<n;j++)
                adj.get(i).add(0);
        }
        for(int i =0;i<m;i++){
            adj.get(graph[i][0]).set(graph[i][1],1);
            adj.get(graph[i][1]).set(graph[i][0],1);
        }
        
        ArrayList<Integer> degree = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			degree.add(0);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (adj.get(i).get(j).intValue() == 1) {
					
					degree.set(i, degree.get(i) + 1);
				}

			}

		}

		
		for (int i = 0; i < n; i++) {
			adj.get(i).set(i, degree.get(i));
		}

		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i != j) && adj.get(i).get(j) == 1) {
					adj.get(i).set(j, -1);
				}

			}

		}

		
		ArrayList<ArrayList<Integer>> submatrix = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n - 1; i++) {
			submatrix.add(new ArrayList<Integer>());
			for (int j = 0; j < n - 1; j++) {
				submatrix.get(i).add(adj.get(i + 1).get(j + 1));
			}
		}

		
		return findDeterminant(submatrix);
    }
    
    private static int findDeterminant(ArrayList<ArrayList<Integer>> Matrix) {
		
		int det = 0;
		if (Matrix.size() == 1) {
			return Matrix.get(0).get(0);
		}

		else if (Matrix.size() == 2) {
			det = (Matrix.get(0).get(0) * Matrix.get(1).get(1) - Matrix.get(0).get(1) * Matrix.get(1).get(0));
			return det;
		}

		else {

			for (int p = 0; p < Matrix.get(0).size(); p++) {
				ArrayList<ArrayList<Integer>> tempMatrix = new ArrayList<ArrayList<Integer>>();
				for (int i = 1; i < Matrix.size(); i++) {
					ArrayList<Integer> row = new ArrayList<Integer>();
					for (int j = 0; j < Matrix.get(i).size(); j++) {
						if (j != p) {
							row.add(Matrix.get(i).get(j));
						}

					}

					if (row.size() > 0) {
						tempMatrix.add(row);
					}

				}

				det = det + Matrix.get(0).get(p) * (int) Math.pow(-1, p) * findDeterminant(tempMatrix);

			}

			return det;
		}

	}
}
