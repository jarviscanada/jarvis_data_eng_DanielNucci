package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

public class QueueUsingStack {
	
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	private int front;
	
	public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        front = 0;
    }
    
    public void push(int x) {
    	if (stack1.empty()) {
            front = x;
    	}
        stack1.push(x);
    }
    
    public int pop() {
    	if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop(); 
    }
    
    public int peek() {
    	if (!stack2.isEmpty()) {
            return stack2.peek();
    }
    	return front;
    }
    
    public boolean empty() {
    	return stack1.isEmpty() && stack2.isEmpty();
    }
}
