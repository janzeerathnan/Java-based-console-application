package Performance;

import Graph.Graph;
import Searching.BinarySearch;
import Searching.LinearSearch;
import java.util.Arrays;
import java.util.List;

public class PerformanceAnalyzer {
    private String lastReport = "No performance comparison has been run yet.";

    public String compareSearches(int[] values, int target) {
        long started = System.nanoTime();
        LinearSearch.Result linear = LinearSearch.search(values, target);
        long linearNanos = System.nanoTime() - started;
        int[] sorted = Arrays.copyOf(values, values.length);
        Arrays.sort(sorted);
        started = System.nanoTime();
        BinarySearch.Result binary = BinarySearch.search(sorted, target);
        long binaryNanos = System.nanoTime() - started;
        lastReport = "Search target: " + target + "\n"
                + "Linear Search: " + found(linear.getIndex()) + ", " + linear.getComparisons() + " comparisons, " + linearNanos + " ns (O(n))\n"
                + "Binary Search: " + found(binary.getIndex()) + ", " + binary.getComparisons() + " comparisons, " + binaryNanos + " ns (O(log n))\n"
                + "Binary search ran on a sorted copy; sorting time is excluded from its measured search time.\n";
        return lastReport;
    }

    public String compareTraversals(Graph graph, int start) {
        if (graph.isEmpty()) return "BFS and DFS unavailable: graph is empty. Add a vertex first.\n";
        if (!graph.containsVertex(start)) return "BFS and DFS unavailable: starting vertex does not exist.\n";
        long started = System.nanoTime(); List<Integer> bfs = graph.bfs(start); long bfsNanos = System.nanoTime() - started;
        started = System.nanoTime(); List<Integer> dfs = graph.dfs(start); long dfsNanos = System.nanoTime() - started;
        lastReport = "Traversal start: " + start + "\n"
                + "BFS: " + bfs + " (" + bfs.size() + " vertices, " + bfsNanos + " ns, O(V + E))\n"
                + "DFS: " + dfs + " (" + dfs.size() + " vertices, " + dfsNanos + " ns, O(V + E))\n";
        return lastReport;
    }

    public String getLastReport() { return lastReport; }
    private String found(int index) { return index < 0 ? "not found" : "found at index " + index; }
}
