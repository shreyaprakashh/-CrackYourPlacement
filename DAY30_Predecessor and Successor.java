// There is BST given with the root node with the key part as an integer only. You need to find the in-order successor and predecessor of a given key. If either predecessor or successor is not found, then set it to NULL.
lass Solution {
    static Node floor  = null;
    static Node ceil = null;
    
    public static void findfloor(Node root, int key){
        if(root == null) return;
        if(root.data < key){
            floor = root;
            findfloor(root.right, key);
        }
        else if(key <= root.data){
            findfloor(root.left, key);
        }
    }
    
    public static void findceil(Node root, int key){
        if(root == null) return;
        if(root.data <= key){
            findceil(root.right, key);
        }
        else if(key < root.data){
            ceil = root;
            findceil(root.left, key);
        }
    }
    
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        floor  = null;
        ceil = null;
        
        findfloor(root, key);
        findceil(root, key);
        pre[0] = floor;
        suc[0] = ceil;
    }
}
