// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode preTail = null;
        ListNode curHead = head; 
        ListNode curTail = head; 
        ListNode nextHead = null;

        while(curHead != null)
        {
            int count = 1;

            while(curTail.next != null && count < k)
            {
                curTail = curTail.next;
                count++;
            }

            if(count != k)
            {
                break;
            }
            
            nextHead = curTail.next;

            curTail.next = null;

            if(preTail != null)
            {
                preTail.next = null;
            }
            curTail = reverse(curHead);

            if(preTail != null)
            {
                preTail.next = curTail;
            }
            else
            {
                head = curTail;
            }
            curHead.next = nextHead;
            
            preTail = curHead;
            curHead = nextHead;
            curTail = nextHead;
        }

        return head;
        
    }
    private ListNode reverse(ListNode head)
    {
        ListNode preNode = null;
        ListNode curNode = head;

        ListNode nextNode = head;

        while(curNode != null)
        {
            nextNode = nextNode.next;
            
            curNode.next = preNode;

            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
