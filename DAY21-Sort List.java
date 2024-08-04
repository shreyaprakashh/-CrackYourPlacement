// Given the head of a linked list, return the list after sorting it in ascending order.
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode nextToMiddle = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(nextToMiddle);
        return merge(left,right);
    }
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(list1 !=null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;
                list1 = list1.next;
            }else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if(list1 != null){
            current.next = list1;
        }else{
            current.next = list2;
        }
        return dummy.next;
    }
    public ListNode getMiddle(ListNode head){
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
