import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

class Max2 {
    double returnMax() {
        Timer t = new Timer();

//        // Fill the array with random numbers
//        int[] n = new Random(Main.NUM_LOOPS)
//                .ints()
//                .limit(Main.SIZE)
//                .toArray();
//
//        // Find the largest number
//        OptionalInt max = Arrays.stream(n).max();

        // Fill the array with random numbers
        OptionalInt max = new Random(Main.NUM_LOOPS)
                        .ints()
                        .limit(Main.SIZE)
                        .max();

        System.out.println("Max2: max = " + max.orElse(0));

        return t.getTime();
    }
}
