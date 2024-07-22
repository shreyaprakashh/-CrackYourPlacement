//Given an absolute path for a Unix-style file system, which begins with a slash '/', transform this path into its simplified canonical path.
class Solution {
    public String simplifyPath(String path) {
        String token = "";
        
        String[] tokens = path.split("/");
        Stack<String> st = new Stack<>();
        
        for (String t : tokens) {
            if (t.isEmpty() || t.equals(".")) continue;
            
            if (!t.equals("..")) 
                st.push(t);
            else if (!st.isEmpty()) 
                st.pop();
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!st.isEmpty()) { 
            result.insert(0, "/" + st.pop());
        }
        
        if (result.length() == 0) 
            result.append("/"); 
        
        return result.toString();
    }
}
