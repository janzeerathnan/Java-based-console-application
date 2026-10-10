package Graph;

/** Graph vertex identified by its integer label. */
public class Vertex {
    private final int label;

    public Vertex(int label) { this.label = label; }
    public int getLabel() { return label; }

    @Override
    public String toString() { return Integer.toString(label); }
}
