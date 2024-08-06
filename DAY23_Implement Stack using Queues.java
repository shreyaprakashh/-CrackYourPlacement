// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        for(int i = 1; i<q.size(); ++i) {
            q.add(q.remove());
        }
        return q.remove();
    }
    
    public int top() {
        for(int i = 1; i<q.size(); ++i) {
            q.add(q.remove());
        }
        int x = q.remove();
        q.add(x);
        return x;
    }
    
    public boolean empty() {
        if(q.size() > 0) return false;
        return true;
    }
}
