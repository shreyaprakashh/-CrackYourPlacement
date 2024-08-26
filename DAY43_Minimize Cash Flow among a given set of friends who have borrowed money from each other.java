// Given a number of friends who have to give or take some amount of money from one another. Design an algorithm by which the total cash flow among all the friends is minimized. 
class Cmp implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            if (a[0] < 0 && b[0] < 0) return Integer.compare(a[1], b[1]);
            else return Integer.compare(b[1], a[1]);
        } else {
            return Integer.compare(a[0], b[0]);
        }
    }
}
class Solution {
    
    public int[][] minCashFlow(int[][] t, int n) {
        // code here
        TreeSet<int[]> s = new TreeSet<>(new Cmp());
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i] -= t[i][j];
                arr[j] += t[i][j];
            }
        }
        
        for (int i = 0; i < n; i++) {
            s.add(new int[]{arr[i], i});
        }
        
        int[][] ans = new int[n][n];
        
        while (s.size() > 1) {
            int[] f = s.first();
            int[] l = s.last();
            int mini = Math.min(Math.abs(f[0]), l[0]);
            ans[f[1]][l[1]] = mini;
            
            if (mini == Math.abs(f[0])) {
                if (l[0] - mini > 0) s.add(new int[]{l[0] - mini, l[1]});
            } else {
                s.add(new int[]{mini + f[0], f[1]});
            }
            
            s.remove(f);
            s.remove(l);
        }
        
        return ans;
        
    }
}
