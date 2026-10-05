package Graph;

/** Graph vertex with a custom dynamic array of adjacent vertex indexes. */
public class Vertex {
    private final int label;
    private int[] neighbors = new int[2];
    private int neighborCount;

    public Vertex(int label) { this.label = label; }
    public int getLabel() { return label; }
    public boolean hasNeighborIndex(int index) {
        for (int i = 0; i < neighborCount; i++) if (neighbors[i] == index) return true;
        return false;
    }
    public void addNeighborIndex(int index) {
        if (neighborCount == neighbors.length) {
            int[] expanded = new int[neighbors.length * 2];
            System.arraycopy(neighbors, 0, expanded, 0, neighbors.length);
            neighbors = expanded;
        }
        neighbors[neighborCount++] = index;
    }
    public int[] getNeighborIndexes() {
        int[] copy = new int[neighborCount];
        System.arraycopy(neighbors, 0, copy, 0, neighborCount);
        return copy;
    }
    @Override
    public String toString() { return Integer.toString(label); }
}
