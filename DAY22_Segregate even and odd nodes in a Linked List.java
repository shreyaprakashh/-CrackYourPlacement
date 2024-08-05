// Given a link list, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be the same as that in the original list.
// NOTE: Don't create a new linked list, instead rearrange the provided one.

class Solution {
    Node divide(Node head) {
        // code here
        Node even=new Node(0);
        Node odd= new Node(0);
        Node evenstart=even;
        Node oddstart=odd;
        Node temp=head;
        while(temp!=null){
            if(temp.data%2==0){
                evenstart.next=temp;
                evenstart=temp;
            }
            else{
                oddstart.next=temp;
                oddstart=temp;
            }
            temp=temp.next;
        }
        evenstart.next=odd.next;
        oddstart.next=null;
        return even.next;
    }
}
