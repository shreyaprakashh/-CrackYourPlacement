// Given a Binary Tree (BT), convert it to a Doubly Linked List (DLL) in place.
class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	ArrayList<Integer> al = new ArrayList<>();
    
    getData(root,al);
    Node head=null;
    Node temp=null;
    for(int i=0;i<al.size();i++){
        Node temp2= new Node(al.get(i));
        if(head==null){
           head=temp2;
           temp=head;
       }else{
           temp.right=temp2;
           temp2.left=temp;
           
           temp=temp2;
       }
    }
    return head;
    }
    
    void getData(Node root,ArrayList<Integer> al){
        
        if(root==null){
            return;
        }
        getData(root.left,al);
        al.add(root.data);
        getData(root.right,al);
    }

}
