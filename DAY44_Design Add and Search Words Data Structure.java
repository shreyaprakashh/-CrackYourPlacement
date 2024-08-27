// Design a data structure that supports adding new words and finding if a string matches any previously added string.
class WordDictionary {

    public class Node {
        boolean isWord;
        Node[] next;
        
        public Node() {
            isWord = false;
            next = new Node[26];
        }
    }
    
    Node start;
    
    public WordDictionary() {
        start = new Node();
    }
    
    public void addWord(String word) {
        Node root = start;
        
        int n = word.length();
        
        for (int i = 0 ; i < n ; i++) {
            int index = word.charAt(i) - 'a';
            
            if (root.next[index] == null) {
                root.next[index] = new Node();
            }
            
            root = root.next[index];
        }
        
        root.isWord = true; 
    }
    
    public boolean searchUtil(String word, Node root) {
        int n = word.length();
        
        for (int i = 0 ; i < n ; i++) {
            char c = word.charAt(i);
            
            if (c == '.') {
                for (int j = 0 ; j < 26 ; j++) {
                    if (root.next[j] == null) continue;
                    
                    if (searchUtil(word.substring(i+1), root.next[j])) return true; 
                }
                
                return false; 
            } else {
                int index  = c - 'a';
                
                if (root.next[index] == null) return false;
                root = root.next[index];
            }
        }
        
        return root.isWord; 
    }
    
    public boolean search(String word) {
        return searchUtil(word, start);
    }
}
