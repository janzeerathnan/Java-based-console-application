
import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(readInt("Stack capacity (1-100000): ", 1, 100000));
        boolean running = true;
        while (running) {
            System.out.println("\n--- Stack ---\n1. Push\n2. Pop\n3. Peek\n4. Display\n5. Exit");
            switch (readInt("Choose: ", 1, 5)) {
                case 1:
                    int value = readInt("Value: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
                    System.out.println(stack.push(value) ? "Value pushed." : "Stack is full (overflow)."); break;
                case 2:
                    Integer removed = stack.pop();
                    System.out.println(removed == null ? "Cannot pop: stack is empty." : "Popped: " + removed); break;
                case 3:
                    Integer top = stack.peek();
                    System.out.println(top == null ? "Cannot peek: stack is empty." : "Top: " + top); break;
                case 4: stack.display(); break;
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
