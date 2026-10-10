package Performance;

import java.util.Scanner;

/** Standalone example for the searching performance analyzer. */
public class PerformanceMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter integer values separated by spaces: ");
        String line = input.nextLine().trim();
        String[] tokens = line.isEmpty() ? new String[0] : line.split("\\s+");
        int[] values = new int[tokens.length];
        try {
            for (int i = 0; i < tokens.length; i++) values[i] = Integer.parseInt(tokens[i]);
            System.out.print("Target: ");
            int target = Integer.parseInt(input.nextLine().trim());
            System.out.print(new PerformanceAnalyzer().compareSearches(values, target));
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Enter whole numbers only.");
        }
    }
}
