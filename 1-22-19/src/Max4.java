import java.util.Arrays;
import java.util.Random;

class Max4 {
    double returnMax() {
        Timer t = new Timer();

        int[] n = new int[Main.SIZE];

        // Fill the array with random numbers
        Random r = new Random(Main.NUM_LOOPS);
        Arrays.setAll(n, i -> r.nextInt());

        // Find the largest number
        Arrays.sort(n);
        int max = n[n.length - 1];

        System.out.println("Max4: max = " + max);

        return t.getTime();
    }
}
