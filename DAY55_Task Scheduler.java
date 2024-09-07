// You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. 
// Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
// ​Return the minimum number of intervals required to complete all tasks.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];
        for(char c : tasks){
            freq[c-'A']++;
        }
        Arrays.sort(freq);
        int batch = freq[25];
        int slots = --batch*n;
        for(int i = 0;i<25; i++){
            slots -= Math.min(freq[i],batch);
        }
        return slots>0 ? tasks.length+slots:tasks.length;
    }
}
