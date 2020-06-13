import java.util.Comparator;

public class Watki {

    private static final String data = "data.csv";

    public static void main(String[] args) {
        FileUtils.fillFileWithData(data);
        int[][] arrayToSort = FileUtils.readDataFromFile(data);

        System.out.println("Czas działania dla 1,2,3,4,8 wątków:\n");

        long duration = createMultipleThreads(1, arrayToSort);
        System.out.println("Sorting time in single thread (in ms): " + duration);

        duration = createMultipleThreads(2, arrayToSort);
        System.out.println("Sorting time in 2 threads (in ms): " + duration);

        duration = createMultipleThreads(3, arrayToSort);
        System.out.println("Sorting time in 3 threads (in ms): " + duration);

        duration = createMultipleThreads(4, arrayToSort);
        System.out.println("Sorting time in 4 threads(in ms): " + duration);

        duration = createMultipleThreads(8, arrayToSort);
        System.out.println("Sorting time in 8 threads (in ms): " + duration);
    }

    public static long createMultipleThreads(int numberOfThreads, int[][] array) {
        Thread[] threads = new Thread[numberOfThreads];
        long startTime = System.nanoTime();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> java.util.Arrays.sort(array, Comparator.comparingInt(a -> a[0])));
            threads[i].start();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000;
    }
}


