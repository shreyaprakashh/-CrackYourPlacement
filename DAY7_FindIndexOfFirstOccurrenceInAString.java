//Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        
        for (int i = 0; i <= m - n; i++) { 
            
            for (int j = 0; j < n; j++) { 
                
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                
                if (j == n - 1)
                    return i;
                
            }
            
        }
        
        return -1;
    }
}
