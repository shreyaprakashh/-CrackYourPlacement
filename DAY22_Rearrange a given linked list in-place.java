// Given a singly linked list, the task is to rearrange it in a way that all odd position nodes are together and all even position nodes are together. (Considering 1-based indexing.)
// Note: You should place all odd-positioned nodes first and then the even-positioned ones. Also, the relative order of odd-positioned nodes and even-positioned nodes should be maintained. 

class Solution {

    // Should rearrange given linked list such that all even
    // positioned Nodes are before odd positioned.
    // Returns nothing
    void rearrangeEvenOdd(Node head) {
        //  The task is to complete this method
        if(head.next==null || head.next.next==null)
            return;
            
          Node odd=head;
          Node even=head.next;
          Node evenStart=even;
          while(odd.next!=null && even.next!=null)
          {
              odd.next=even.next;
              odd=odd.next;
              even.next=odd.next;
              even=even.next;

          }
          odd.next=evenStart;
          return;
    }
}
