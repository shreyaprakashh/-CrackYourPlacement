// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
class LRUCache {
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    
    class DoublyLinkedList {
        ListNode head; 
        ListNode tail; 
        int capacity;
        int size;

        public DoublyLinkedList(int capacity) {
            this.capacity = capacity;
            this.head = new ListNode(0,0);
            this.tail = new ListNode(0,0);
            head.next = tail;
            tail.next = head;
            this.size = 0;
        }

        public void insertAtHead(ListNode node) {
            ListNode next = head.next;
            head.next = node;
            node.prev = head;
            next.prev = node;
            node.next = next;
            size++;
        }
        
        public void remove(ListNode node) {
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
            size--;
        }
        
        private void moveToHead(ListNode node) {
            if (node.prev != null && node.next != null) {
                remove(node);
            }
            insertAtHead(node);
        }
        
        private ListNode removeTail() {
            ListNode node = tail.prev;
            remove(node);
            return node;
        }
    }

    private DoublyLinkedList dll;
    private Map<Integer, ListNode> mp;

    public LRUCache(int capacity) {
        this.dll = new DoublyLinkedList(capacity);
        this.mp = new HashMap<>();
    }
    
    public int get(int key) {
        if (!mp.containsKey(key)) return -1;
        ListNode node = mp.get(key);
        dll.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = mp.containsKey(key) ? mp.get(key): new ListNode(key, value);
        node.val = value;
        dll.moveToHead(node);
        mp.put(key, node);
        if (dll.size > dll.capacity) {
            mp.remove(dll.removeTail().key);
        }
    }
}
