package src;

import java.util.List;
import java.util.Scanner;

import src.Graph.Graph;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        Graph graph = new Graph();
        boolean running = true;
        while (running) {
            System.out.println("\n--- Graph (undirected) ---\n1. Add Vertex\n2. Add Edge\n3. Display Graph\n4. BFS Traversal\n5. DFS Traversal\n6. Exit");
            switch (readInt("Choose: ", 1, 6)) {
                case 1:
                    int label = readInt("Vertex label: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println(graph.addVertex(label) ? "Vertex added." : "Vertex already exists.");
                    break;
                case 2:
                    if (graph.isEmpty()) System.out.println("Add vertices before creating an edge.");
                    else {
                        int from = readInt("First vertex: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                        int to = readInt("Second vertex: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                        if (!graph.containsVertex(from) || !graph.containsVertex(to)) System.out.println("Both vertices must exist.");
                        else System.out.println(graph.addEdge(from, to) ? "Edge added." : "Edge already exists or self-edges are not supported.");
                    }
                    break;
                case 3: graph.display(); break;
                case 4: traverse(graph, true); break;
                case 5: traverse(graph, false); break;
                case 6: running = false; break;
                default: break;
            }
        }
        System.out.println("Goodbye.");
    }

    private static void traverse(Graph graph, boolean breadthFirst) {
        if (graph.isEmpty()) {
            System.out.println("Cannot traverse: graph is empty.");
            return;
        }
        int start = readInt("Starting vertex: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (!graph.containsVertex(start)) {
            System.out.println("Starting vertex does not exist.");
            return;
        }
        List<Integer> order = breadthFirst ? graph.bfs(start) : graph.dfs(start);
        System.out.println((breadthFirst ? "BFS" : "DFS") + " traversal: " + order);
        if (order.size() < graph.vertexCount()) System.out.println("Note: traversal covers only the connected component containing the start vertex.");
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(INPUT.nextLine().trim());
                if (value >= min && value <= max) return value;
            } catch (NumberFormatException ignored) { }
            System.out.println("Enter a whole number from " + min + " to " + max + ".");
        }
    }
}
