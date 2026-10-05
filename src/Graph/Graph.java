package src.Graph;

import java.util.ArrayList;
import java.util.List;

/** Undirected graph using custom vertex and adjacency arrays. */
public class Graph {
    private Vertex[] vertices = new Vertex[4];
    private int vertexCount;

    public boolean addVertex(int label) {
        if (indexOf(label) >= 0) return false;
        if (vertexCount == vertices.length) {
            Vertex[] expanded = new Vertex[vertices.length * 2];
            System.arraycopy(vertices, 0, expanded, 0, vertexCount);
            vertices = expanded;
        }
        vertices[vertexCount++] = new Vertex(label);
        return true;
    }

    /** Adds one undirected edge between existing, distinct vertices. */
    public boolean addEdge(int from, int to) {
        int fromIndex = indexOf(from), toIndex = indexOf(to);
        if (fromIndex < 0 || toIndex < 0 || fromIndex == toIndex || vertices[fromIndex].hasNeighborIndex(toIndex)) return false;
        vertices[fromIndex].addNeighborIndex(toIndex);
        vertices[toIndex].addNeighborIndex(fromIndex);
        return true;
    }

    public void display() {
        if (isEmpty()) { System.out.println("Graph is empty."); return; }
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(vertices[i].getLabel() + " -> ");
            int[] neighbors = vertices[i].getNeighborIndexes();
            if (neighbors.length == 0) System.out.println("(no neighbors)");
            else {
                for (int j = 0; j < neighbors.length; j++) {
                    System.out.print(vertices[neighbors[j]].getLabel() + (j + 1 == neighbors.length ? "" : ", "));
                }
                System.out.println();
            }
        }
    }

    /** BFS traverses with a custom array queue. */
    public List<Integer> bfs(int start) {
        int startIndex = indexOf(start);
        if (startIndex < 0) throw new IllegalArgumentException("Starting vertex " + start + " does not exist.");
        boolean[] visited = new boolean[vertexCount];
        int[] queue = new int[vertexCount];
        int front = 0, rear = 0;
        List<Integer> order = new ArrayList<>();
        visited[startIndex] = true;
        queue[rear++] = startIndex;
        while (front < rear) {
            int current = queue[front++];
            order.add(vertices[current].getLabel());
            for (int neighbor : vertices[current].getNeighborIndexes()) {
                if (!visited[neighbor]) { visited[neighbor] = true; queue[rear++] = neighbor; }
            }
        }
        return order;
    }

    /** Iterative DFS traverses with a custom array stack. */
    public List<Integer> dfs(int start) {
        int startIndex = indexOf(start);
        if (startIndex < 0) throw new IllegalArgumentException("Starting vertex " + start + " does not exist.");
        boolean[] visited = new boolean[vertexCount];
        int[] stack = new int[vertexCount];
        int top = 0;
        List<Integer> order = new ArrayList<>();
        stack[top++] = startIndex;
        visited[startIndex] = true;
        while (top > 0) {
            int current = stack[--top];
            order.add(vertices[current].getLabel());
            int[] neighbors = vertices[current].getNeighborIndexes();
            for (int i = neighbors.length - 1; i >= 0; i--) {
                int neighbor = neighbors[i];
                if (!visited[neighbor]) { visited[neighbor] = true; stack[top++] = neighbor; }
            }
        }
        return order;
    }

    public boolean containsVertex(int label) { return indexOf(label) >= 0; }
    public boolean isEmpty() { return vertexCount == 0; }
    public int vertexCount() { return vertexCount; }

    private int indexOf(int label) {
        for (int i = 0; i < vertexCount; i++) if (vertices[i].getLabel() == label) return i;
        return -1;
    }
}
