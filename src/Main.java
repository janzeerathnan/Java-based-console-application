package LinkedList;

import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        boolean running = true;
        while (running) {
            System.out.println("\n--- Singly Linked List ---\n1. Insert\n2. Delete\n3. Search\n4. Display\n5. Size\n6. Exit");
            switch (readInt("Choose: ", 1, 6)) {
                case 1:
                    list.insert(readInt("Value to insert: ", Integer.MIN_VALUE, Integer.MAX_VALUE));
                    System.out.println("Value inserted.");
                    break;
                case 2:
                    if (list.isEmpty()) System.out.println("Cannot delete: list is empty.");
                    else {
                        int deleteValue = readInt("Value to delete: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                        System.out.println(list.delete(deleteValue) ? "First matching value deleted." : "Value not found.");
                    }
                    break;
                case 3:
                    int target = readInt("Value to search: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    int index = list.search(target);
                    System.out.println(index < 0 ? "Value not found." : "Value found at index " + index + ".");
                    break;
                case 4: list.display(); break;
                case 5: System.out.println("List size: " + list.size()); break;
                case 6: running = false; break;
                default: break;
            }
        }
        System.out.println("Goodbye.");
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
}
