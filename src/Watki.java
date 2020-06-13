import java.util.Comparator;

public class Watki {

    public static void createMultipleThreads(int numberOfThreads, int[][] array) {
        Thread[] threads = new Thread[numberOfThreads];
        long startTime = System.nanoTime();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> java.util.Arrays.sort(array, Comparator.comparingInt(a -> a[0])));
            threads[i].start();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.out.println("Sorting time in " + numberOfThreads + " threads (in ms): " + duration);
    }

    public static void sortArray(int[][] array) {
        long startTime = System.nanoTime();

        java.util.Arrays.sort(array, Comparator.comparingInt(a -> a[0]));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
        System.out.println("Sorting time without threads (in ms): " + duration);
    }
}


