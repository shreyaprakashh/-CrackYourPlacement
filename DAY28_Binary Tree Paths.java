// Given the root of a binary tree, return all root-to-leaf paths in any order.
class Solution {
    
    ArrayList<String> list=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        
        String ans="";
        path(root,ans);
        return list;
    }
    void path(TreeNode root, String ans) {
        if(root==null) return;
        ans=ans+root.val;
        if(root.left==null && root.right==null){
            list.add(ans);
            return;
        }
        ans=ans+"->";
        path(root.left,ans);
        path(root.right,ans);
    }

    
}
