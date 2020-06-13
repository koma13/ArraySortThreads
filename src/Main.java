public class Main {

    private static final String data = "data.csv";

    public static void main(String[] args) {
        FileUtils.fillFileWithData(data);
        int[][] arrayToSort = FileUtils.readDataFromFile(data);

        Watki.sortArray(arrayToSort);

        System.out.println("Czas działania dla 1,2,3,4,8 wątków:\n");
        Watki.createMultipleThreads(1, arrayToSort);
        Watki.createMultipleThreads(2, arrayToSort);
        Watki.createMultipleThreads(3, arrayToSort);
        Watki.createMultipleThreads(4, arrayToSort);
        Watki.createMultipleThreads(8, arrayToSort);
    }
}
