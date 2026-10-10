import Array.CustomArray;
import Graph.Graph;
import LinkedList.CustomLinkedList;
import Performance.PerformanceAnalyzer;
import Queue.CustomQueue;
import Searching.BinarySearch;
import Searching.LinearSearch;
import Stack.CustomStack;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/** Integrated console entry point for the standalone final project. */
public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private final CustomArray array = new CustomArray(100);
    private final CustomStack stack = new CustomStack(100);
    private final CustomQueue queue = new CustomQueue(100);
    private final CustomLinkedList linkedList = new CustomLinkedList();
    private final Graph graph = new Graph();
    private final PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

    public static void main(String[] args) { new Main().run(); }

    private void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n====================================================\nDATA STRUCTURE & GRAPH PERFORMANCE ANALYZER\n====================================================");
            System.out.println("1. Array Operations\n2. Stack Operations\n3. Queue Operations\n4. Linked List Operations\n5. Searching Operations\n6. Graph Operations\n7. Performance Comparison\n8. Display All Results\n9. Exit");
            switch (readInt("Enter your choice: ", 1, 9)) {
                case 1: arrayMenu(); break;
                case 2: stackMenu(); break;
                case 3: queueMenu(); break;
                case 4: linkedListMenu(); break;
                case 5: searchingMenu(); break;
                case 6: graphMenu(); break;
                case 7: performanceMenu(); break;
                case 8: displayAll(); break;
                case 9: running = false; break;
                default: break;
            }
        }
        System.out.println("Application closed.");
    }

    private void arrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Array Operations ---\n1. Insert\n2. Delete\n3. Search\n4. Display\n5. Return to Main Menu");
            switch (readInt("Choice: ", 1, 5)) {
                case 1:
                    int value = readInt("Value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println(array.insert(value) ? "Inserted." : "Array is full."); break;
                case 2:
                    if (array.isEmpty()) System.out.println("Array is empty.");
                    else { int index = readInt("Index (0-" + (array.size() - 1) + "): ", 0, array.size() - 1); System.out.println(array.delete(index) ? "Deleted." : "Invalid index."); }
                    break;
                case 3:
                    int target = readInt("Value to search: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    int foundAt = array.search(target); System.out.println(foundAt < 0 ? "Value not found." : "Found at index " + foundAt + "."); break;
                case 4: array.display(); break;
                case 5: back = true; break;
                default: break;
            }
        }
    }

    private void stackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Stack Operations ---\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Return to Main Menu");
            switch (readInt("Choice: ", 1, 5)) {
                case 1:
                    int value = readInt("Value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println(stack.push(value) ? "Pushed." : "Stack is full (overflow)."); break;
                case 2:
                    Integer popped = stack.pop(); System.out.println(popped == null ? "Stack is empty." : "Popped: " + popped); break;
                case 3:
                    Integer top = stack.peek(); System.out.println(top == null ? "Stack is empty." : "Top: " + top); break;
                case 4: stack.display(); break;
                case 5: back = true; break;
                default: break;
            }
        }
    }

    private void queueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Queue Operations ---\n1. Enqueue\n2. Dequeue\n3. Peek / Front\n4. Display\n5. Return to Main Menu");
            switch (readInt("Choice: ", 1, 5)) {
                case 1:
                    int value = readInt("Value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println(queue.enqueue(value) ? "Enqueued." : "Queue is full (overflow)."); break;
                case 2:
                    Integer removed = queue.dequeue(); System.out.println(removed == null ? "Queue is empty." : "Dequeued: " + removed); break;
                case 3:
                    Integer front = queue.peek(); System.out.println(front == null ? "Queue is empty." : "Front: " + front); break;
                case 4: queue.display(); break;
                case 5: back = true; break;
                default: break;
            }
        }
    }

    private void linkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Linked List Operations ---\n1. Insert\n2. Delete\n3. Search\n4. Display\n5. Return to Main Menu");
            switch (readInt("Choice: ", 1, 5)) {
                case 1: linkedList.insert(readInt("Value: ", Integer.MIN_VALUE, Integer.MAX_VALUE)); System.out.println("Inserted."); break;
                case 2:
                    if (linkedList.isEmpty()) System.out.println("List is empty.");
                    else { int value = readInt("Value to delete: ", Integer.MIN_VALUE, Integer.MAX_VALUE); System.out.println(linkedList.delete(value) ? "First matching value deleted." : "Value not found."); }
                    break;
                case 3:
                    int target = readInt("Value to search: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    int index = linkedList.search(target); System.out.println(index < 0 ? "Value not found." : "Found at index " + index + "."); break;
                case 4: linkedList.display(); break;
                case 5: back = true; break;
                default: break;
            }
        }
    }

    private void searchingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Searching Operations ---\n1. Linear Search\n2. Binary Search\n3. Compare Performance\n4. Return to Main Menu");
            int choice = readInt("Choice: ", 1, 4);
            if (choice == 4) { back = true; continue; }
            int target = readInt("Target value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (choice == 1) {
                LinearSearch.Result result = LinearSearch.search(array.toArray(), target);
                System.out.println("Linear Search: " + (result.isFound() ? "found at index " + result.getIndex() : "not found") + " (" + result.getComparisons() + " comparisons).");
            } else if (choice == 2) {
                int[] sorted = array.toArray(); Arrays.sort(sorted);
                BinarySearch.Result result = BinarySearch.search(sorted, target);
                System.out.println("Sorted data: " + Arrays.toString(sorted));
                System.out.println("Binary Search: " + (result.isFound() ? "found at sorted index " + result.getIndex() : "not found") + " (" + result.getComparisons() + " comparisons).");
            } else System.out.print(analyzer.compareSearches(array.toArray(), target));
        }
    }

    private void graphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Graph Operations ---\n1. Add Vertex\n2. Add Edge\n3. Display Graph\n4. BFS Traversal\n5. DFS Traversal\n6. Return to Main Menu");
            switch (readInt("Choice: ", 1, 6)) {
                case 1:
                    int label = readInt("Vertex label: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println(graph.addVertex(label) ? "Vertex added." : "Duplicate vertex."); break;
                case 2:
                    if (graph.isEmpty()) System.out.println("Add vertices before adding edges.");
                    else {
                        int from = readInt("First vertex: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                        int to = readInt("Second vertex: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                        if (!graph.containsVertex(from) || !graph.containsVertex(to)) System.out.println("Both vertices must exist.");
                        else System.out.println(graph.addEdge(from, to) ? "Edge added." : "Edge exists already or self-edges are not supported.");
                    }
                    break;
                case 3: graph.display(); break;
                case 4: traverse(false); break;
                case 5: traverse(true); break;
                case 6: back = true; break;
                default: break;
            }
        }
    }

    private void traverse(boolean depthFirst) {
        if (graph.isEmpty()) { System.out.println("Graph is empty."); return; }
        int start = readInt("Starting vertex: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (!graph.containsVertex(start)) { System.out.println("Starting vertex does not exist."); return; }
        List<Integer> order = depthFirst ? graph.dfs(start) : graph.bfs(start);
        System.out.println((depthFirst ? "DFS" : "BFS") + " traversal: " + order);
        if (order.size() < graph.vertexCount()) System.out.println("Traversal covers the connected component containing the start vertex.");
    }

    private void performanceMenu() {
        System.out.println("\n====================================================\nPERFORMANCE COMPARISON\n====================================================");
        if (array.isEmpty()) System.out.println("Search data is empty; add values through Array Operations.");
        else {
            int target = readInt("Search target: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.print(analyzer.compareSearches(array.toArray(), target));
        }
        if (graph.isEmpty()) System.out.println("BFS/DFS: graph is empty; add vertices and edges through Graph Operations.");
        else {
            int start = readInt("Traversal start vertex: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            System.out.print(analyzer.compareTraversals(graph, start));
        }
        System.out.println("Timing varies with input size, system load, and implementation. Graph complexity: BFS O(V + E), DFS O(V + E).");
    }

    private void displayAll() {
        System.out.println("\n=== Current Data Structure Results ===");
        array.display(); stack.display(); queue.display(); linkedList.display();
        System.out.println("Graph:"); graph.display();
        System.out.println("\nLast performance report:\n" + analyzer.getLastReport());
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(INPUT.nextLine().trim());
                if (value >= min && value <= max) return value;
            } catch (NumberFormatException ignored) { }
            System.out.println("Invalid input. Enter a whole number from " + min + " to " + max + ".");
        }
    }
}
