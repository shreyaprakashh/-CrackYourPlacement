// You are given two linked lists that represent two large positive numbers. These two numbers are represented by the linked lists, subtract the smaller number from the larger one. 
// Look at the examples to get a better understanding of the task.

class Solution {
    int length(Node n){
        int ret =0;
        while(n!=null){
            ret++;
            n = n.next;
        }
        return ret;
    }
    
    Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        while(head1 !=null && head1.data ==0){
            head1 = head1.next;
        }
        while(head2 !=null && head2.data ==0){
            head2 = head2.next;
        }
        int n1 = length(head1);
        int n2 = length(head2);
        if(n1==0 && n2 ==0){
            return new Node(0);
        }
        if(n2>n1){
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        if(n1==n2){
            Node tmp1 = head1;
            Node tmp2 = head2;
            while(tmp1.data == tmp2.data){
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
                if(tmp1 == null){
                    return new Node(0);
                }
            }
            if(tmp2.data>tmp1.data){
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }
        head1 = reverse(head1);
        head2 = reverse(head2);
        Node ans = null;
        Node tmp1 = head1;
        Node tmp2 = head2;
        while(tmp1 != null){
            int less =0;
            if(tmp2!= null){
                less = tmp2.data;
            }
            if(tmp1.data<less){
                if(tmp1.next!=null){
                    tmp1.next.data-=1;
                }
                tmp1.data+=10;
            }
            Node ne = new Node(tmp1.data-less);
            ne.next = ans;
            ans = ne;
            tmp1=tmp1.next;
            if(tmp2!=null){
                tmp2= tmp2.next;
            }
        }
        while(ans!=null && ans.next !=null && ans.data==0){
            ans = ans.next;
        }
        return ans;
    }
}
