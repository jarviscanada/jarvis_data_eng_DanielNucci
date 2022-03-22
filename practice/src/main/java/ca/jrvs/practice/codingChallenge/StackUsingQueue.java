package ca.jrvs.practice.codingChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	
	private Queue<Integer> q;

    public StackUsingQueue() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        int len = q.size();
        
        while (len > 1) {
        	q.add(q.remove());
        	len--;
        }
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */