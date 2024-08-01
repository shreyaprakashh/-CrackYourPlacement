// Given elements as nodes of the two singly linked lists. The task is to multiply these two linked lists, say L1 and L2.
// Note: The output could be large take modulo 10^9+7.

class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        long m = 1000000007;
        long n1 =0, n2=0;
        Node temp = first;
        while(temp!=null){
            n1 = (n1*10)%m+temp.data;
            temp = temp.next;
            
        }
        temp = second;
        while(temp!=null){
            n2 = (n2*10)%m + temp.data;
            temp = temp.next;
            
        }
        return (n1*n2) % m;
    }
}
