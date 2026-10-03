package Queue;

import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue(readInt("Queue capacity (1-100000): ", 1, 100000));
        boolean running = true;
        while (running) {
            System.out.println("\n--- Queue ---\n1. Enqueue\n2. Dequeue\n3. Peek / Front\n4. Display\n5. Exit");
            switch (readInt("Choose: ", 1, 5)) {
                case 1:
                    int value = readInt("Value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println(queue.enqueue(value) ? "Value enqueued." : "Queue is full (overflow)."); break;
                case 2:
                    Integer removed = queue.dequeue();
                    System.out.println(removed == null ? "Cannot dequeue: queue is empty." : "Dequeued: " + removed); break;
                case 3:
                    Integer first = queue.peek();
                    System.out.println(first == null ? "Cannot peek: queue is empty." : "Front: " + first); break;
                case 4: queue.display(); break;
                case 5: running = false; break;
                default: break;
            }
        }
        System.out.println("Goodbye.");
    }
    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try { int value = Integer.parseInt(INPUT.nextLine().trim()); if (value >= min && value <= max) return value; }
            catch (NumberFormatException ignored) { }
            System.out.println("Enter a whole number from " + min + " to " + max + ".");
        }
    }
}
