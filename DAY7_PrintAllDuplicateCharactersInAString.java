//Given a string S, the task is to print all the duplicate characters with their occurrences in the given string.
class Solution
{
  
  
  static void printDups(String str)
  {
    Map<Character, Integer> count = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if(count.containsKey(str.charAt(i)))
        count.put(str.charAt(i) , count.get(str.charAt(i))+1); 
      else count.put(str.charAt(i),1);
      
    }

    for (Map.Entry<Character,Integer> mapElement : count.entrySet()) {   
      if (mapElement.getValue() > 1)   
        return (mapElement.getKey() + ", count = " + mapElement.getValue());
    }
  }
}
