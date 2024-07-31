// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next==null){
			return head;
		}

		ListNode fastPointer=head, slowPointer= head;
		while(fastPointer!=null && fastPointer.next!=null){
			fastPointer =fastPointer.next;
			if(fastPointer!=null){
				fastPointer =fastPointer.next;
			}
			slowPointer = slowPointer.next;

		}
		return slowPointer;
        
    }
}
