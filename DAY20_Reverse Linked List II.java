// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null)
            return head;

       ListNode dummy=new ListNode(0);
       dummy.next=head;

       ListNode curr=head;
       ListNode prev=dummy;

       for(int i=1;i<left;i++){
           curr=curr.next;
           prev=prev.next;
       }
       ListNode sublisthead=curr;
       
       ListNode prevnode=null;
       ListNode next;

       for(int i=1;i<=right-left+1;i++){
           next=curr.next;
           curr.next=prevnode;
           prevnode=curr;
           curr=next;
       }
       prev.next=prevnode;
       sublisthead.next=curr;

       return dummy.next;
    }
}
