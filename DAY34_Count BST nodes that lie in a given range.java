//Given a Binary Search Tree (BST) and a range l-h(inclusive), count the number of nodes in the BST that lie in the given range.
class Solution
{
    //Function to count number of nodes in BST that lie in the given range.
    int getCount(Node root,int l, int h)
    {
        //Your code here
        ArrayList<Integer> al =new ArrayList<>();
        inorder(root,al);
        int count=0;
        for(int i=0;i<al.size();i++){
            if(l<=al.get(i) && al.get(i)<=h) count++;
        }
        return count;
    }
    
    void inorder(Node root,ArrayList<Integer> al){
        if(root==null) return;
        inorder(root.left,al);
        al.add(root.data);
        inorder(root.right,al);
    }
}
