// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> mp = new HashMap<>(); 
        for(int i = 0; i < beginWord.length(); ++i){
                    StringBuilder tmp = new StringBuilder();
                    tmp.append(beginWord.substring(0,i));
                    tmp.append('*');
                    tmp.append(beginWord.substring(i+1));
                    String str = tmp.toString();
                    mp.computeIfAbsent(str,k -> new ArrayList<>()).add(beginWord);
        }
        
        for(String w: wordList){
             for(int i = 0; i <w.length(); ++i){
                    StringBuilder tmp = new StringBuilder();
                    tmp.append(w.substring(0,i));
                    tmp.append('*');
                    tmp.append(w.substring(i+1));
                    String str = tmp.toString();
                    mp.computeIfAbsent(str,k -> new ArrayList<>()).add(w);
             }
        }
        
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int count = 0;
        Set<String> visited = new HashSet<>();
        while(!queue.isEmpty()){
            count++;
            int size = queue.size();
            for(int iter = 0; iter < size; ++iter){
                String cur = queue.poll();
                if(cur.equals(endWord)) return count;
                for(int i = 0; i < cur.length(); ++i){
                    StringBuilder tmp = new StringBuilder();
                    tmp.append(cur.substring(0,i));
                    tmp.append('*');
                    tmp.append(cur.substring(i+1));
                    String str = tmp.toString();
                    if(mp.containsKey(str)){
                        for(String s : mp.get(str)){
                            if(!visited.contains(s)){
                                visited.add(s);
                                queue.offer(s);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
