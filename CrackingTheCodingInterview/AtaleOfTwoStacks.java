import java.util.*;

public class ATaleOfTwoStacks {

  private static class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();

    public void enqueue(T value) {
      stackNewestOnTop.push(value);
    }

    public T peek() {
      if (stackOldestOnTop.isEmpty()) {
        while (!stackNewestOnTop.isEmpty()) {
          stackOldestOnTop.push(stackNewestOnTop.pop());
        }
      }
      return stackOldestOnTop.peek();
    }

    public T dequeue() {
      if (stackOldestOnTop.isEmpty()) {
        while (!stackNewestOnTop.isEmpty()) {
          stackOldestOnTop.push(stackNewestOnTop.pop());
        }
      }
      return stackOldestOnTop.pop();
    }
  }

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) {
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) {
        queue.dequeue();
      } else if (operation == 3) {
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}
