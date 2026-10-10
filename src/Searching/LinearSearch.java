package Searching;

public final class LinearSearch {
    private LinearSearch() { }
    public static Result search(int[] values, int target) {
        int comparisons = 0;
        for (int i = 0; i < values.length; i++) { comparisons++; if (values[i] == target) return new Result(i, comparisons); }
        return new Result(-1, comparisons);
    }
    public static final class Result {
        private final int index, comparisons;
        private Result(int index, int comparisons) { this.index = index; this.comparisons = comparisons; }
        public int getIndex() { return index; }
        public int getComparisons() { return comparisons; }
        public boolean isFound() { return index >= 0; }
    }
}
