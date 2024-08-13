// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST)
class BSTIterator {
    private Stack<TreeNode> st = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode tmpNode = st.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(TreeNode node) {
        for (; node != null; st.push(node), node = node.left);
    }
}
