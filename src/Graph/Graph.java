package Graph;

import java.util.ArrayList;
import java.util.List;

/** Undirected graph stored as custom vertex and adjacency arrays. */
public class Graph {
    private Vertex[] vertices = new Vertex[4];
    private int[][] adjacency = new int[4][];
    private int count;

    public boolean addVertex(int label) {
        if (indexOf(label) >= 0) return false;
        if (count == vertices.length) {
            Vertex[] expandedVertices = new Vertex[vertices.length * 2];
            int[][] expandedAdjacency = new int[adjacency.length * 2][];
            System.arraycopy(vertices, 0, expandedVertices, 0, count);
            System.arraycopy(adjacency, 0, expandedAdjacency, 0, count);
            vertices = expandedVertices;
            adjacency = expandedAdjacency;
        }
        vertices[count] = new Vertex(label);
        adjacency[count] = new int[0];
        count++;
        return true;
    }

    public boolean addEdge(int from, int to) {
        int fromIndex = indexOf(from), toIndex = indexOf(to);
        if (fromIndex < 0 || toIndex < 0 || fromIndex == toIndex || contains(adjacency[fromIndex], toIndex)) return false;
        adjacency[fromIndex] = append(adjacency[fromIndex], toIndex);
        adjacency[toIndex] = append(adjacency[toIndex], fromIndex);
        return true;
    }

    public boolean containsVertex(int label) { return indexOf(label) >= 0; }
    public boolean isEmpty() { return count == 0; }
    public int vertexCount() { return count; }

    public void display() {
        if (isEmpty()) { System.out.println("Graph is empty."); return; }
        for (int i = 0; i < count; i++) {
            System.out.print(vertices[i].getLabel() + " -> ");
            if (adjacency[i].length == 0) System.out.println("(no neighbors)");
            else {
                for (int j = 0; j < adjacency[i].length; j++) System.out.print(vertices[adjacency[i][j]].getLabel() + (j + 1 == adjacency[i].length ? "" : ", "));
                System.out.println();
            }
        }
    }

    /** BFS uses a queue stored in an array. */
    public List<Integer> bfs(int start) {
        int startIndex = indexOf(start);
        if (startIndex < 0) throw new IllegalArgumentException("Starting vertex does not exist.");
        boolean[] visited = new boolean[count];
        int[] queue = new int[count];
        int front = 0, rear = 0;
        List<Integer> order = new ArrayList<>();
        visited[startIndex] = true;
        queue[rear++] = startIndex;
        while (front < rear) {
            int current = queue[front++];
            order.add(vertices[current].getLabel());
            for (int next : adjacency[current]) {
                if (!visited[next]) { visited[next] = true; queue[rear++] = next; }
            }
        }
        return order;
    }

    /** Iterative DFS uses a stack stored in an array. */
    public List<Integer> dfs(int start) {
        int startIndex = indexOf(start);
        if (startIndex < 0) throw new IllegalArgumentException("Starting vertex does not exist.");
        boolean[] visited = new boolean[count];
        int[] stack = new int[count];
        int top = 0;
        List<Integer> order = new ArrayList<>();
        stack[top++] = startIndex;
        visited[startIndex] = true;
        while (top > 0) {
            int current = stack[--top];
            order.add(vertices[current].getLabel());
            for (int i = adjacency[current].length - 1; i >= 0; i--) {
                int next = adjacency[current][i];
                if (!visited[next]) { visited[next] = true; stack[top++] = next; }
            }
        }
        return order;
    }

    private int indexOf(int label) {
        for (int i = 0; i < count; i++) if (vertices[i].getLabel() == label) return i;
        return -1;
    }
    private int[] append(int[] source, int value) {
        int[] result = new int[source.length + 1];
        System.arraycopy(source, 0, result, 0, source.length);
        result[source.length] = value;
        return result;
    }
    private boolean contains(int[] values, int target) { for (int value : values) if (value == target) return true; return false; }
}
