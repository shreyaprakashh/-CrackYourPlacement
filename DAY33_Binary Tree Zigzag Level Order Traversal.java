// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res =new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q =new LinkedList<>();
        q.offer(root);
        int level=0;

        while(!q.isEmpty()){
            int lsize=q.size();
            List<Integer>sub=new LinkedList<>();

            for(int i=0;i<lsize;i++){
                TreeNode node=q.poll();
                
                if(level%2==0){
                    sub.add(node.val);
                }
                else{
                    sub.add(0,node.val);
                }
                if(node.left!=null){
                   q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            res.add(sub);
            level++;
        }
        return res;
    }
}
