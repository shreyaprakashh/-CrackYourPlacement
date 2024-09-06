// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the above operations.

class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int result = 0;
        int max = 0;
        
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            arr[s.charAt(r) - 'A']++;
            max = Math.max(max, arr[s.charAt(r) - 'A']);
            
            if (r - l + 1 - max > k) { 
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
