// Given string S representing a postfix expression, the task is to evaluate the expression and find the final value. Operators will only include the basic arithmetic operators like *, /, + and -.
class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> st=new Stack<>();
        for(char ch:S.toCharArray()){
            if(Character.isDigit(ch)){
                st.push(ch-'0');
            }
            else{
                int v1=st.pop(),v2=st.pop();
                if(ch=='+')st.push(v2+v1);
                else if(ch=='-')st.push(v2-v1);
                else if(ch=='*')st.push(v2*v1);
                else st.push(v2/v1);
            }
        }
        return st.pop();
    }
}
