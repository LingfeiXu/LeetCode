class MyStack {
    // Push element x onto stack.
    private Queue queue;
    
    public void push(int x) {
        Queue temp = new LinkedList();
        temp.add(x);
        temp.add(queue);
        queue = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
        queue = (Queue)queue.peek();
    }

    // Get the top element.
    public int top() {
        return (int)queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue==null;
    }
}