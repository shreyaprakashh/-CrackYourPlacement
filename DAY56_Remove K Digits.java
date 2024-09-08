// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder(); 
        int n = num.length();
        
        for(int i = 0; i < n; i++) {
            while(result.length() > 0 && result.charAt(result.length() - 1) > num.charAt(i) && k > 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            
            if(result.length() > 0 || num.charAt(i) != '0') {
                result.append(num.charAt(i)); 
            }
        }
        
        while(result.length() > 0 && k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        if(result.length() == 0) {
            return "0";
        }
        
        return result.toString();
    }
}
