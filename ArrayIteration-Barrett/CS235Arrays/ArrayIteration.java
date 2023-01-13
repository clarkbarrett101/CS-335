import java.util.*;

public class ArrayIteration {
    public static void main(String[] args) {
        int itemCount = 100;
        int[] output = new int[1];
        Long highScore = (long) 0;
        long startTime = (long) 0;
        long endTime = (long) 0;
        Scanner scanner = new Scanner(System.in);
        String input;
        Boolean running = true;
        Boolean valid;
        GenerateRandomArray(1);
        // The first array seems much faster than the following ones, so to keep things
        // more consistent I had it generate a seed first
        while (running) {
            System.out.println(
                    "Type the number of elements then 'S' for sequential Array or 'R' for randomized array, then press ENTER.");
            input = scanner.nextLine().toLowerCase();
            if (input.equals("")) {
                System.exit(0);
            }
            valid = false;
            if (input.contains("s")) {
                valid = true;
                String[] s = input.split("s");
                try {
                    itemCount = Integer.parseInt(s[0]);
                } catch (Exception e) {
                    itemCount = Integer.parseInt(s[1]);
                }
                startTime = System.nanoTime();
                output = GenerateSequentialArray(itemCount);
                endTime = System.nanoTime();
            } else if (input.contains("r")) {
                valid = true;
                String[] s = input.split("r");
                try {
                    itemCount = Integer.parseInt(s[0]);
                } catch (Exception e) {
                    itemCount = Integer.parseInt(s[1]);
                }
                startTime = System.nanoTime();
                output = GenerateRandomArray(itemCount);
                endTime = System.nanoTime();
            } else {
                valid = false;
                System.out.println("Sorry, didn't quite catch that...");
            }
            if (valid) {
                System.out.println("Displaying all " + itemCount + " values:");
                System.out.println(Arrays.toString(output));
                long time = (endTime - startTime);
                System.out.println("Elapsed time: " + time + " ms");
                if (time > highScore) {
                    System.out.println("*NEW HIGHSCORE*");
                    highScore = time;
                }
                System.out.println("HIGHSCORE: " + highScore + " ms");
                System.out.println("Type nothing and press ENTER to quit.");
            }
        }
    }

    static int[] GenerateRandomArray(int itemCount) {
        Random randomizer = new Random();
        int[] genArray = new int[itemCount];
        for (int i = 0; i < itemCount; i++) {
            genArray[i] = randomizer.nextInt(Integer.MAX_VALUE);
        }
        return genArray;
    }

    static int[] GenerateSequentialArray(int itemCount) {

        int[] genArray = new int[itemCount];
        for (int i = 0; i < itemCount; i++) {
            genArray[i] = i + 1;
        }
        return genArray;
    }
}
