// Design an algorithm to serialize and deserialize a binary tree.
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> que = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(que);
    }
    
    private TreeNode helper(Queue<String> que) {
        String s = que.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(que);
        root.right = helper(que);
        return root;
    }
}
