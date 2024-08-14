// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
class Solution {
    Set<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    
        Deque<TreeNode> ancestors = new ArrayDeque<>();
        findAncestors(ancestors, root, target);
        
    
        List<Integer> res = new ArrayList<>();
        while (!ancestors.isEmpty()) {
            if (k == 0) {
                res.add(ancestors.pop().val);
                break;
            }
            visited.add(ancestors.peek());
            childrenNodeWithDistance(ancestors.pop(), k--, res);
        }
        return res;
    }

    private boolean findAncestors(Deque<TreeNode> ancestors, TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        ancestors.push(root);
        if (root == target) {
            return true;
        }
        if (findAncestors(ancestors, root.left, target) || findAncestors(ancestors, root.right, target)) {
            return true;
        }
        ancestors.pop();
        return false;
    }

    private void childrenNodeWithDistance(TreeNode root, int k, List<Integer> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null && !visited.contains(curr.left)) {
                    queue.offer(curr.left);
                }
                if (curr.right != null && !visited.contains(curr.right)) {
                    queue.offer(curr.right);
                }
            }
            k--;

            if (k == 0) {
                while (!queue.isEmpty()) {
                    res.add(queue.poll().val);
                }
            }
        }
    }

}
