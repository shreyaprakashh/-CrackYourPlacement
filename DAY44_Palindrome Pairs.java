// You are given a 0-indexed array of unique strings words.
// Return an array of all the palindrome pairs of words.

class Solution {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(words == null || words.length == 0){
			return res;
		}
		int[] hasLength = new int[5002];
		
		HashMap<String, Integer> mp = new HashMap<>();
		for(int i = 0; i < words.length; i++){
			mp.put(words[i], i);
			hasLength[words[i].length()]++;
		}

		if(mp.containsKey("")){
			int blankIdx = mp.get("");
			for(int i = 0; i < words.length; i++){
				if(isPalindrome(words[i], 0, words[i].length() - 1)){
					if(i == blankIdx) continue;
					res.add(Arrays.asList(blankIdx, i));
					res.add(Arrays.asList(i, blankIdx));
				}
			}
		}

		for(int i = 0; i < words.length; i++){
			String cur_r = reverseStr(words[i]);
			if(mp.containsKey(cur_r)){
				int found = mp.get(cur_r);
				if(found == i) continue;
				res.add(Arrays.asList(i, found));
			}
		}

		for(int i = 0; i < words.length; i++){
			String cur = words[i];

			for(int cut = 1; cut < cur.length(); cut++){
				if(hasLength[cur.length() - cut] > 0 && isPalindrome(cur, 0, cut - 1)){
					String cut_r = reverseStr(cur.substring(cut));
					if(mp.containsKey(cut_r)){
						int found = mp.get(cut_r);
						if(found == i) continue;
						res.add(Arrays.asList(found, i));
					}
				}
				if(hasLength[cut] > 0 && isPalindrome(cur, cut, cur.length() - 1)){
					String cut_r = reverseStr(cur.substring(0, cut));
					if(mp.containsKey(cut_r)){
						int found = mp.get(cut_r);
						if(found == i) continue;
						res.add(Arrays.asList(i, found));
					}
				}
			}
		}

		return res;
	}

	public String reverseStr(String str){
		StringBuilder sb= new StringBuilder(str);
		return sb.reverse().toString();
	}

	public boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
