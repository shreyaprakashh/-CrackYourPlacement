// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.
class Solution {
    ListNode curr;

    void solve(ListNode head) {
        if (head == null) {
            return;
        }

        solve(head.next);
        ListNode tempn = curr.next;
        if (tempn == null) {
            return;
        } else if (head == curr) {
            head.next = null;
            return;
        }

        curr.next = head;
        head.next = tempn == head ? null : tempn;

        curr = tempn;
    }

    public void reorderList(ListNode head) {
        curr = head;
        solve(head);
        
    }
}
