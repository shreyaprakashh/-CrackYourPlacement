// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode();
        ListNode curr = ans;
        while (head != null) {
            if (head.val != val) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;
        return ans.next;
    }
}
