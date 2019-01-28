import java.util.Random;

class Max1 {
    double returnMax() {
        Timer t = new Timer();

        int[] n = new int[Main.SIZE];

        // Fill the array with random numbers
        Random r = new Random(Main.NUM_LOOPS);
        for (int i = 0; i < n.length; i++) {
            n[i] = r.nextInt();
        }

        // Find the largest number
        int max = n[0];
        for (int i = 1; i < n.length; i++) {
            if (max < n[i]) {
                max = n[i];
            }
        }

        System.out.println("Max1: max = " + max);

        return t.getTime();
    }
}
