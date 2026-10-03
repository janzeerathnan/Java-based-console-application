package Stack;

/** Fixed-capacity integer stack backed by an array. */
public class CustomStack {
    private final int[] values;
    private int top = -1;

    public CustomStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be greater than zero.");
        values = new int[capacity];
    }

    public boolean push(int value) {
        if (isFull()) return false;
        values[++top] = value;
        return true;
    }
    public Integer pop() { return isEmpty() ? null : values[top--]; }
    public Integer peek() { return isEmpty() ? null : values[top]; }
    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == values.length - 1; }
    public int size() { return top + 1; }

    public void display() {
        if (isEmpty()) { System.out.println("Stack is empty."); return; }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) System.out.print(values[i] + (i == 0 ? "" : " "));
        System.out.println();
    }
}
