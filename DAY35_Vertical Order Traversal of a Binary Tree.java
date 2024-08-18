// Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
class Solution {
    
    Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
            return null;
        mp = new TreeMap<>();
        dfs(root, 0, 0);
        List<List<Integer>> res = new LinkedList<>();
        for (int key : mp.keySet()){
            List<Integer> list = new LinkedList<>();
            TreeMap<Integer, PriorityQueue<Integer>> tm = mp.get(key);
            for (int k : tm.keySet()){
                PriorityQueue<Integer> pq = tm.get(k);
                while (!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
    
    private void dfs(TreeNode root, int index, int level){
        if (root == null)
            return;
        
        mp.putIfAbsent(index, new TreeMap<>());
        mp.get(index).putIfAbsent(level, new PriorityQueue<>());
        mp.get(index).get(level).add(root.val);
        dfs(root.left, index - 1, level + 1);
        dfs(root.right, index + 1, level + 1);
    }
}
