// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
class Solution {
    int maxLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> al = new ArrayList<>();
        right(root, 1, al);
        return al;
    }
    
    void right(TreeNode root,int level,ArrayList<Integer> al){
        if(root==null){
            return ;
        }
        if(maxLevel<level){
            al.add(root.val);
            maxLevel=level;
        }
        right(root.right,level+1,al);
        right(root.left,level+1,al);
        
    }
}
