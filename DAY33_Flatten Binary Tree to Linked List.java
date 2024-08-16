// Given the root of a binary tree, flatten the tree into a "linked list":
class Solution {
    Queue<TreeNode> queue = new LinkedList<>(); 
    public void addToQueue(TreeNode root)
    {   
        if(root == null)
            return;
        
        queue.add(root);         
        addToQueue(root.left);
        addToQueue(root.right);
    }
    public void flatten(TreeNode root) {
        addToQueue(root); 
        
        while(!queue.isEmpty())
        {   
            TreeNode temp = queue.poll();
            temp.right = queue.peek();
            temp.left = null;
        }

        
    }
}
