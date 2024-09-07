// Given a string s, return the minimum number of characters you need to delete to make s good.
class Solution {
    public int minDeletions(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int max = 0;
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            max = Math.max(max,mp.get(ch));
        }
        int res = 0,size=(int)1e5+1;
        int[] hash = new int[size];
        for(char ch:mp.keySet()){
            int val = mp.get(ch);
            hash[val]++;
        }
        for(int i=max;i>0;i--){
            int count = hash[i];
            if(count>1){
                res+=(count-1);
                hash[i] = 1;
                if(i>0) hash[i-1]+=count-1;
            }
        }
        return res;
    }
}
