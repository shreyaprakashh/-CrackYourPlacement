// Given a singly linked list, remove all the nodes in the list which have any node on their right whose value is greater. 
// (Not just immediate Right , but entire List on the Right)

class Solution
{
    Node compute(Node head)
    {
        // your code here
        head = rev(head);
        int maxVal = head.data;
        Node curr = head.next, prev= head;
        while(curr !=null ){
            if(curr.data >=maxVal){
                prev=curr;
                maxVal = curr.data;
            }
            else{
                prev.next = curr.next;
            }
            curr =curr.next;
        }
        return rev(head);
    }
    Node rev(Node head){
        Node curr=head , prev=null, temp=null;
        while(curr !=null){
            temp =curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        return prev;
    }
    
    
}
