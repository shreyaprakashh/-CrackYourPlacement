// Given a linked list of 0s, 1s and 2s, The task is to sort and print it.
public class Solution {
  
    public static void sortList(Node head) {
        int[] cnt = { 0, 0, 0 };
        Node ptr = head;
        while (ptr != null) {
            cnt[ptr.data] += 1;
            ptr = ptr.next;
        }

        int idx = 0;
        ptr = head;
        while (ptr != null) {
            if (cnt[idx] == 0)
                idx += 1;
            else {
                ptr.data = idx;
                cnt[idx] -= 1;
                ptr = ptr.next;
            }
        }
    }
  
    public static void printList(Node node) {
        while (node != null) {
          node = node.next;
          return node.data;

        }
       
    }
}
