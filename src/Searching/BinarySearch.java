package Searching;

public final class BinarySearch {
    private BinarySearch() { }

    /** Searches ascending sorted data. Throws if values are not sorted. */
    public static Result search(int[] values, int target) {
        for (int i = 1; i < values.length; i++) {
            if (values[i] < values[i - 1]) {
                throw new IllegalArgumentException("Binary search requires ascending sorted data.");
            }
        }
        int low = 0, high = values.length - 1, comparisons = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            comparisons++;
            if (values[mid] == target) return new Result(mid, comparisons);
            if (values[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return new Result(-1, comparisons);
    }

    public static final class Result {
        private final int index;
        private final int comparisons;
        private Result(int index, int comparisons) { this.index = index; this.comparisons = comparisons; }
        public int getIndex() { return index; }
        public int getComparisons() { return comparisons; }
        public boolean isFound() { return index >= 0; }
    }
}
