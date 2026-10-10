package Searching;

public final class BinarySearch {
    private BinarySearch() { }
    public static Result search(int[] values, int target) {
        for (int i = 1; i < values.length; i++) if (values[i] < values[i - 1]) throw new IllegalArgumentException("Binary search requires ascending sorted data.");
        int low = 0, high = values.length - 1, comparisons = 0;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            comparisons++;
            if (values[middle] == target) return new Result(middle, comparisons);
            if (values[middle] < target) low = middle + 1; else high = middle - 1;
        }
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
