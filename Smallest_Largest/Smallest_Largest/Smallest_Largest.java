import java.util.*;

public class Smallest_Largest {
    public static void main(String[] args) {
        Integer[] workingArray = new Integer[0];
        Integer highscore = 0;
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println(
                    "Type a whole number to add to your array, type 's' to find the smallest and largest values, type nothing to quit.");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("")) {
                System.exit(0);
            } else if (input.equals("s")) {
                if (workingArray.length < 1) {
                    System.out.println("Sorry, your array is empty..");
                } else {
                    highscore = GetSmallestAndLargest(workingArray, highscore);
                }
            } else {
                try {
                    workingArray = AddToArray(workingArray, Integer.parseInt(input));
                } catch (Exception e) {
                    System.out.println("Sorry, didn't quite catch that...");
                }
            }
        }
    }

    static Integer GetSmallestAndLargest(Integer[] args, Integer highscore) {
        int large = args[0];
        int small = args[0];
        // loop is starting at args[1] because large and small start at args[0]
        // loop checks args[i] and replaces large or small as nessecary
        for (int i = 1; i < args.length; i++) {
            if (args[i] > large) {
                large = args[i];
            } else if (args[i] < small) {
                small = args[i];
            }
        }
        System.out.println("Largest: " + large);
        System.out.println("Smallest: " + small);
        System.out.println("Difference Score: " + (large - small));
        if (large - small > highscore) {
            System.out.println("***NEW HIGHSCORE***");
        }
        return large - small;
    }

    static Integer[] AddToArray(Integer[] args, int n) {
        Integer[] newArgs = new Integer[args.length + 1];
        for (int i = 0; i < args.length; i++) {
            newArgs[i] = args[i];
        }
        newArgs[args.length] = n;
        return newArgs;
    }
}