//Given an input string s, reverse the order of the words.
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//Return a string of the words in reverse order concatenated by a single space.
class Solution {
    public String reverseWords(String s) {
        String result = new String();
        int i = 0;
        int n = s.length();
        
        while(i < n) {
            while(i < n && s.charAt(i) == ' ') i++;
            if(i >= n) break;
            int j = i+1;
            while(j < n && s.charAt(j) !=' ') j++;
            String sub = s.substring(i,j);
            if(result.length() == 0) result = sub;
            else result = sub + " " + result;
            i = j + 1;
        }
        return result;
    }
}

