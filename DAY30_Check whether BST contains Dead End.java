// Given a Binary Search Tree that contains unique positive integer values greater than 0. The task is to complete the function isDeadEnd which returns true if the BST contains a dead end else returns false. 
// Here Dead End means a leaf node, at which no other node can be inserted.

class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return containDeadEnd(root, 1, Integer.MAX_VALUE);
    }
    
    private static boolean containDeadEnd(Node root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (min == max) {
            return true;
        }
        return containDeadEnd(root.left, min, root.data - 1)
                || containDeadEnd(root.right, root.data + 1, max);
    }
}
