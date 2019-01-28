public class Timer {
    private long start;

    Timer() {
        start = System.nanoTime();
    }

    void reset() {
        start = 0;
    }

    double getTime() {
        return (System.nanoTime() - start)/1E9;
    }
}
