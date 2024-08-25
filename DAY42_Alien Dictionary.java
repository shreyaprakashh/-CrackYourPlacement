// Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break; 
                }
            }
        }
        
        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int v : adj.get(i)) {
                inDegree[v]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        StringBuilder order = new StringBuilder();
        
        
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        
        while (!q.isEmpty()) {
            int u = q.poll();
            order.append((char)(u + 'a'));
            
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
        
        
        if (order.length() == k) {
            return order.toString();
        }
        
        return "";
    }
}
