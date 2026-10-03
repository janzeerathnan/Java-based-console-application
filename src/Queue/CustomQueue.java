package Queue;

/** Fixed-capacity FIFO queue implemented as a circular array. */
public class CustomQueue {
    private final int[] values;
    private int front;
    private int rear;
    private int size;

    public CustomQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be greater than zero.");
        values = new int[capacity];
    }
    public boolean enqueue(int value) {
        if (isFull()) return false;
        values[rear] = value;
        rear = (rear + 1) % values.length;
        size++;
        return true;
    }
    public Integer dequeue() {
        if (isEmpty()) return null;
        int value = values[front];
        front = (front + 1) % values.length;
        size--;
        return value;
    }
    public Integer peek() { return isEmpty() ? null : values[front]; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == values.length; }
    public int size() { return size; }

    public void display() {
        if (isEmpty()) { System.out.println("Queue is empty."); return; }
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % values.length;
            System.out.print(values[index] + (i + 1 == size ? "" : " "));
        }
        System.out.println();
    }
}
