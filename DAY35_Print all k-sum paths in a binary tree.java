// Given a binary tree and an integer k, the task is to count the number of paths in the tree such that the sum of the nodes in each path equals k.
class Solution {
    int count = 0;
    
    void helper(Node root,int k,ArrayList<Integer> al){
        if(root == null){
            return;
        }
        al.add(root.data);
        int size = al.size();
        int sum = 0;
        for(int i=size-1;i >=0;i--){
            sum += al.get(i);
            if(sum == k){
                count++;
            }
        }
        helper(root.left,k,al);
        helper(root.right,k,al);
        al.remove(al.size()-1);
    }
    
    public int sumK(Node root, int k) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        helper(root, k, al);
        return count;
    }
}
