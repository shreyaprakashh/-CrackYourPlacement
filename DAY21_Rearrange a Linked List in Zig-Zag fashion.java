// Given a linked list, rearrange it such that the converted list should be of the form a < b > c < d > e < f … where a, b, c… are consecutive data nodes of the linked list.
class Solution {
    static class Node {
        int data;
        Node next;
    }
    static Node head = null;
    static int temp = 0;
    static void zigZagList(Node head)
    {
        boolean flag = true;
        Node current = head;
        while (current != null && current.next != null) {
            if (flag == true) 
            {
                if (current.data > current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
            else
            {
                if (current.data < current.next.data) {
                    temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
            }
 
            current = current.next;
            flag = !(flag);
        }
    }
 
    static void push(int new_data)
    {
        Node new_Node = new Node();
        new_Node.data = new_data;
        new_Node.next = (head);
        (head) = new_Node;
    }
 
    static void printList(Node Node)
    {
        while (Node != null) {
            return Node.data;
            Node = Node.next;
        }
        return "NULL";
    }
}
