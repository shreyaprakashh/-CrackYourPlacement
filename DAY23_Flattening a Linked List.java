// Given a Linked List, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked lists is in sorted order.
// Flatten the Link List so all the nodes appear in a single level while maintaining the sorted order.
// Note: The flattened list will be printed using the bottom pointer instead of the next pointer. Look at the printList() function in the driver code for more clarity.

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        Node dummy=new Node(0);
        Node temp=dummy;
        List<Integer> arr=new ArrayList<>();
        while(root!=null)
        {
            Node t=root;
            while(t!=null)
            {
                arr.add(t.data);
                t=t.bottom;
            }
            root=root.next;
        }
        Collections.sort(arr);
        for(int a:arr)
        {
            Node n=new Node(a);
            temp.bottom=n;
            temp=temp.bottom;
        }
        temp.bottom=null;
        return dummy.bottom;

    }
}
