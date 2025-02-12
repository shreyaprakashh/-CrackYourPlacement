// Construct a binary tree of size N using two given arrays pre[] and preLN[].
class Solution{
    Node construct(int pre[],int index[],char preLN[]){
        Node root=new Node(pre[index[0]]);
        
        if(preLN[index[0]]=='L'){
            root.left=null;
            root.right=null;
         
            return root;
        } 
        index[0]=index[0]+1;
        root.left=construct(pre,index,preLN);
        index[0]=index[0]+1;
        root.right=construct(pre,index,preLN);
        return root;
    }
    
    Node constructTree(int n, int pre[], char preLN[]){
	    // code here
	     if(n==0){
            return null;
        }
        int index[]=new int [1];
        index[0]=0;
        return  construct(pre,index,preLN);
    }
}
