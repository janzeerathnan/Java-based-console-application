package LinkedList;

public class CustomLinkedList {
    private Node head;
    private int size;
    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) head = node;
        else { Node current = head; while (current.getNext() != null) current = current.getNext(); current.setNext(node); }
        size++;
    }
    public boolean delete(int value) {
        if (head == null) return false;
        if (head.getValue() == value) { head = head.getNext(); size--; return true; }
        Node current = head;
        while (current.getNext() != null && current.getNext().getValue() != value) current = current.getNext();
        if (current.getNext() == null) return false;
        current.setNext(current.getNext().getNext()); size--; return true;
    }
    public int search(int value) {
        Node current = head; int index = 0;
        while (current != null) { if (current.getValue() == value) return index; current = current.getNext(); index++; }
        return -1;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public void display() {
        if (isEmpty()) { System.out.println("List is empty."); return; }
        Node current = head; System.out.print("List: ");
        while (current != null) { System.out.print(current.getValue()); current = current.getNext(); System.out.print(current == null ? " -> null" : " -> "); }
        System.out.println();
    }
}
