public class Main {
    static final int SIZE = 100000;
    static final int NUM_LOOPS = 5;

    static double run1() {
        double avg = 0.0;
        for (int i = 0; i < NUM_LOOPS; i++) {
            avg += new Max1().returnMax();
            System.out.println("Max1: time = "+avg);
        }

        return avg/NUM_LOOPS;
    }

    static double run2() {
        double avg = 0.0;
        for (int i = 0; i < NUM_LOOPS; i++) {
            avg += new Max2().returnMax();
            System.out.println("Max2: time = "+avg);
        }

        return avg/NUM_LOOPS;
    }

    static double run3() {
        double avg = 0.0;
        for (int i = 0; i < NUM_LOOPS; i++) {
            avg += new Max3().returnMax();
            System.out.println("Max3: time = "+avg);
        }

        return avg/NUM_LOOPS;
    }

    static double run4() {
        double avg = 0.0;
        for (int i = 0; i < NUM_LOOPS; i++) {
            avg += new Max4().returnMax();
            System.out.println("Max4: time = "+avg);
        }

        return avg/NUM_LOOPS;
    }

    public static void main(String[] args) throws InterruptedException {
        org.openjdk.jmh.Main.main(args);
//        System.out.println("avg1: "+run1());
        System.out.println("avg2: "+run2());
//        System.out.println("avg3: "+run3());
//        System.out.println("avg4: "+run4());
    }
}
