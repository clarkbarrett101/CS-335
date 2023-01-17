import java.util.*;

public class Smallest_Largest {
    public static void main(String[] args) {
        Integer[] workingArray = new Integer[0];
        Integer highscore = 0;
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            // loop until quit
            System.out.println(
                    "Type a whole number to add to your array, type 's' to find the smallest and largest values, type nothing to quit.");
            input = scanner.nextLine().toLowerCase();
            // toLowerCase so 'S' and 's' can work
            if (input.equals("")) {
                // checking for quit command
                System.exit(0);
            } else if (input.equals("s")) {
                if (workingArray.length < 1) {
                    // check if array is empty
                    System.out.println("Sorry, your array is empty..");
                } else {
                    // replaces highscore if there's a new one
                    highscore = GetSmallestAndLargest(workingArray, highscore);
                }
            } else {
                try {
                    // replaces array with one that is 1 element larger
                    workingArray = AddToArray(workingArray, Integer.parseInt(input));
                } catch (Exception e) {
                    // if parse doesn't work (a letter other than s or a non int number)
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
        // returns the highscore
        // (the highscore can't technically go down because you can't remove elements)
        if (large - small > highscore) {
            System.out.println("***NEW HIGHSCORE***");
        }
        return large - small;
    }

    static Integer[] AddToArray(Integer[] args, int n) {
        // creates new array with +1 length
        Integer[] newArgs = new Integer[args.length + 1];
        // Copies over all elements
        for (int i = 0; i < args.length; i++) {
            newArgs[i] = args[i];
        }
        // last element is the new element
        newArgs[args.length] = n;
        // return the new and improved array
        return newArgs;
    }
}