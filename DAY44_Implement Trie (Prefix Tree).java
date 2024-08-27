// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
// Implement the Trie class:

class Trie {
    class TrieNode{
        boolean isEnd;
        TrieNode arr[] =new TrieNode[26];
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch =word.charAt(i);
            if(node.arr[ch-'a']==null){
                TrieNode curr = new TrieNode(); 
                node.arr[ch-'a']=curr;
            }
            node=node.arr[ch-'a'];
        }
        node.isEnd =true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            char ch =word.charAt(i);
            if(node.arr[ch-'a']==null){
                return false;
            }
            node =node.arr[ch-'a'];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) { 
        TrieNode node = root;
        for(int i=0;i<prefix.length();i++){
            char ch =prefix.charAt(i);
            if(node.arr[ch-'a']==null){
                return false;
            }
            node =node.arr[ch-'a'];
        }
        return true;
    }
}
