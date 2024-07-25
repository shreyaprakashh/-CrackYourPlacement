//Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.
//Note: The final output will be in lexicographic order.

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        for (String s:string_list){
            char[] temp=s.toCharArray();
            Arrays.sort(temp);
            String str=new String(temp);
            if (!map.containsKey(str)){
                List<String> tempArr=new ArrayList<>();
                tempArr.add(s);
                map.put(str,tempArr);
            }
            else{
                 List<String> tempArr=map.get(str);
                 tempArr.add(s);
                 map.put(str,tempArr);

            }
            
       }
        for (Map.Entry<String,List<String>> entry:map.entrySet()){
            List<String> t1=entry.getValue();
            if (t1.size()!=0) result.add(t1);
        }
        return result;
    }
}
