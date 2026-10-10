package Stack;

public class CustomStack {
    private final int[] data;
    private int top = -1;
    public CustomStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        data = new int[capacity];
    }
    public boolean push(int value) { if (top == data.length - 1) return false; data[++top] = value; return true; }
    public Integer pop() { return isEmpty() ? null : data[top--]; }
    public Integer peek() { return isEmpty() ? null : data[top]; }
    public boolean isEmpty() { return top < 0; }
    public void display() {
        if (isEmpty()) { System.out.println("Stack is empty."); return; }
        System.out.print("Stack (top to bottom): "); for (int i = top; i >= 0; i--) System.out.print(data[i] + (i == 0 ? "" : " ")); System.out.println();
    }
}
