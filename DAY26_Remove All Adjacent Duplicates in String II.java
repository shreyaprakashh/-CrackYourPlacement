// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
// We repeatedly make k duplicate removals on s until we no longer can.
// Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
class Solution {
    public String removeDuplicates(String s, int k) {
        
        ArrayDeque<Adjacent> st = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peekLast().ch == c) {
                st.peekLast().freq++; 
            } else {
                st.addLast(new Adjacent(c, 1));
            }
            if (st.peekLast().freq == k) 
                st.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        for (Adjacent a : st) {
            sb.append(String.valueOf(a.ch).repeat(a.freq));
        }
        return sb.toString();
    }
    class Adjacent {
        char ch;
        int freq;
        public Adjacent(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}
