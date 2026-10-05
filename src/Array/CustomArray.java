package Array;

/** Fixed-capacity integer array with basic mutable operations. */
public class CustomArray {
    private final int[] values;
    private int size;

    public CustomArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        values = new int[capacity];
    }

    public boolean insert(int value) {
        if (size == values.length) {
            return false;
        }
        values[size++] = value;
        return true;
    }

    /** Deletes and shifts left the element at a zero-based index. */
    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return true;
    }

    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(values[i] + (i + 1 == size ? "" : " "));
        }
        System.out.println();
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == values.length; }
    public int size() { return size; }
    public int capacity() { return values.length; }

    /** Returns a copy containing only current elements. */
    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(values, 0, copy, 0, size);
        return copy;
    }
}
