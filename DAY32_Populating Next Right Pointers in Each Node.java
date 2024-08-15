// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node node = root;
        while (node != null) {
            Node curr = node;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            node = node.left;
        }
        return root;
    }
}
