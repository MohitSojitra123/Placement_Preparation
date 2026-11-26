import java.util.Stack;

public class Implement_Queue_Using_Stack_Question_232 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Push element to the back of queue
    public void push(int x) {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    // Remove front element
    public int pop() {
        return stack1.pop();
    }

    // Get front element
    public int peek() {
        return stack1.peek();
    }

    // Check queue is empty or not
    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {

        Implement_Queue_Using_Stack_Question_232 queue = new Implement_Queue_Using_Stack_Question_232();

        // Static Input
        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front Element: " + queue.peek());

        System.out.println("Removed: " + queue.pop());

        System.out.println("Front Element After Pop: " + queue.peek());

        System.out.println("Is Queue Empty? " + queue.empty());

        queue.push(40);

        System.out.println("Removed: " + queue.pop());

        System.out.println("Front Element: " + queue.peek());

        System.out.println("Is Queue Empty? " + queue.empty());
    }
}