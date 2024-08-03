// Given the head of a linked list, remove the nth node from the end of the list and return its head.
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = new ListNode(-1);
        slow.next = head;
        if (head.next == null) return null;
        while (n > 1) {
            if (fast.next == null) { fast = null; break; }
            fast = fast.next;
            n -= 1;
        }
       
        int flag = 0;
        while (fast != null && fast.next != null) {
            flag = 1;
            fast = fast.next;
            slow = slow.next;
        }
        if (flag == 0) { return head.next; }
        else {
            slow.next = slow.next.next;
        }
        return head;
        
    }
}
