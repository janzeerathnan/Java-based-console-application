package Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        int[] values = readValues();
        boolean running = true;
        while (running) {
            System.out.println("\n--- Searching ---\n1. Linear Search\n2. Binary Search (sort a copy)\n3. Compare both\n4. Exit");
            int choice = readInt("Choose: ", 1, 4);
            if (choice == 4) { running = false; continue; }
            int target = readInt("Target value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (choice == 1) print("Linear Search", LinearSearch.search(values, target));
            else {
                int[] sorted = Arrays.copyOf(values, values.length);
                Arrays.sort(sorted);
                if (choice == 2) print("Binary Search (sorted data)", BinarySearch.search(sorted, target));
                else {
                    print("Linear Search", LinearSearch.search(values, target));
                    print("Binary Search (sorted data)", BinarySearch.search(sorted, target));
                    System.out.println("Binary search uses sorted data; sorting is not included in its comparison count.");
                }
            }
        }
        System.out.println("Goodbye.");
    }

    private static int[] readValues() {
        int count = readInt("Number of values: ", 0, Integer.MAX_VALUE);
        int[] values = new int[count];
        for (int i = 0; i < count; i++) values[i] = readInt("Value " + (i + 1) + ": ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        return values;
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

    private static void print(String name, LinearSearch.Result result) {
        System.out.println(name + ": " + (result.isFound() ? "found at index " + result.getIndex() : "not found")
                + " (" + result.getComparisons() + " comparisons).");
    }

    private static void print(String name, BinarySearch.Result result) {
        System.out.println(name + ": " + (result.isFound() ? "found at index " + result.getIndex() : "not found")
                + " (" + result.getComparisons() + " comparisons).");
    }
}
