//Given a text txt[0..n-1] and a pattern pat[0..m-1] where n is the length of the text and m is the length of the pattern,.
//write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.


class Solution {

	static int NO_OF_CHARS = 256;

	static int max(int a, int b) { return (a > b) ? a : b; }

	
	static void badCharHeuristic(char[] str, int size,
								int badchar[])
	{

		
		for (int i = 0; i < NO_OF_CHARS; i++)
			badchar[i] = -1;

		
		for (int i = 0; i < size; i++)
			badchar[(int)str[i]] = i;
	}

	
	static void search(char txt[], char pat[])
	{
		int m = pat.length;
		int n = txt.length;

		int badchar[] = new int[NO_OF_CHARS];

		
		badCharHeuristic(pat, m, badchar);

		int s = 0; 
		while (s <= (n - m)) {
			int j = m - 1;

			
			while (j >= 0 && pat[j] == txt[s + j])
				j--;

			
			if (j < 0) {
				return s;

				s += (s + m < n) ? m - badchar[txt[s + m]]
								: 1;
			}

			else
				s += max(1, j - badchar[txt[s + j]]);
		}
	}
}
