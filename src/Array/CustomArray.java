package Array;

public class CustomArray {
    private final int[] data;
    private int size;
    public CustomArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive.");
        data = new int[capacity];
    }
    public boolean insert(int value) { if (size == data.length) return false; data[size++] = value; return true; }
    public boolean delete(int index) {
        if (index < 0 || index >= size) return false;
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        size--; return true;
    }
    public int search(int value) { for (int i = 0; i < size; i++) if (data[i] == value) return i; return -1; }
    public int[] toArray() { int[] copy = new int[size]; System.arraycopy(data, 0, copy, 0, size); return copy; }
    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
    public void display() {
        if (isEmpty()) { System.out.println("Array is empty."); return; }
        System.out.print("Array: "); for (int i = 0; i < size; i++) System.out.print(data[i] + (i + 1 == size ? "" : " ")); System.out.println();
    }
}
