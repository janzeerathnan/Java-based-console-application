package Array;

import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        int capacity = readInt("Enter array capacity: ", 1, Integer.MAX_VALUE);
        CustomArray array = new CustomArray(capacity);
        boolean running = true;
        while (running) {
            System.out.println("\n--- Custom Array ---\n1. Insert\n2. Delete by index\n3. Search\n4. Display\n5. Exit");
            int choice = readInt("Choose: ", 1, 5);
            switch (choice) {
                case 1:
                    if (array.isFull()) System.out.println("Array is full.");
                    else if (array.insert(readInt("Value: ", Integer.MIN_VALUE, Integer.MAX_VALUE))) System.out.println("Value inserted.");
                    break;
                case 2:
                    if (array.isEmpty()) System.out.println("Array is empty.");
                    else {
                        int index = readInt("Zero-based index to delete (0-" + (array.size() - 1) + "): ", 0, array.size() - 1);
                        System.out.println(array.delete(index) ? "Element deleted." : "Invalid index.");
                    }
                    break;
                case 3:
                    int value = readInt("Value to search: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    int index = array.search(value);
                    System.out.println(index < 0 ? "Value not found." : "Value found at index " + index + ".");
                    break;
                case 4: array.display(); break;
                case 5: running = false; break;
                default: break;
            }
        }
        System.out.println("Goodbye.");
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String line = INPUT.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= min && value <= max) return value;
            } catch (NumberFormatException ignored) { }
            System.out.println("Enter a whole number from " + min + " to " + max + ".");
        }
    }
}
