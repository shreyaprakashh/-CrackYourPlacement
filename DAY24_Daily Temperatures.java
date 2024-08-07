// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
// If there is no future day for which this is possible, keep answer[i] == 0 instead.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[temperatures.length];
        for(int i = 0;i < temperatures.length;i++)
        {
           while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i])
           {
               int top = st.pop();
               ans[top] = i - top;
           }
           st.push(i);
        }
        return ans;
    }
}
