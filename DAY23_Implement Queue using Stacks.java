// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
// Implement the MyQueue class:
// void push(int x) Pushes element x to the back of the queue.
// int pop() Removes the element from the front of the queue and returns it.
// int peek() Returns the element at the front of the queue.
// boolean empty() Returns true if the queue is empty, false otherwise.

class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> val = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(st.size()==0 && st.size()==0){
            st.push(x);
        }else{
            if(val.size()!=0) val.push(x);
            else st.push(x);
        }
    }
    
    public int pop() {
        if(st.size()!=0){
            while(st.size()>1){
                val.push(st.pop());
            }
            int a = st.pop();

            while(val.size()>0){
                st.push(val.pop());
            }
            return a;
        }else{
            while(val.size()>1){
                st.push(val.pop());
            }
            int a = val.pop();

            while(st.size()>0){
                val.push(st.pop());
            }
            return a;
        }
    }
    
    public int peek() {
        if(st.size()!=0){
            while(st.size()>1){
                val.push(st.pop());
            }
            int a = st.peek();

            while(val.size()>0){
                st.push(val.pop());
            }
            return a;
        }else{
            while(val.size()>1){
                st.push(val.pop());
            }
            int a = val.peek();

            while(st.size()>0){
                val.push(st.pop());
            }
            return a;
        }
    }
    
    public boolean empty() {
        if(st.size()==0 && val.size()==0) return true;
        else return false;
    }
}
