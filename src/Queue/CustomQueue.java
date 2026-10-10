package Queue;

public class CustomQueue {
    private final int[] data;
    private int front, rear, size;
    public CustomQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        data = new int[capacity];
    }
    public boolean enqueue(int value) {
        if (size == data.length) return false;
        data[rear] = value; rear = (rear + 1) % data.length; size++; return true;
    }
    public Integer dequeue() {
        if (isEmpty()) return null;
        int value = data[front]; front = (front + 1) % data.length; size--; return value;
    }
    public Integer peek() { return isEmpty() ? null : data[front]; }
    public boolean isEmpty() { return size == 0; }
    public void display() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        System.out.print("Queue (front to rear): "); for (int i = 0; i < size; i++) System.out.print(data[(front + i) % data.length] + (i + 1 == size ? "" : " ")); System.out.println();
    }
}
