import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class DataHelper {

    public static void fillFileWithData(String fileName) {
        Random random = new Random();
        try {
            PrintWriter out = new PrintWriter(fileName);
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 999; j++) {
                    out.print(random.nextInt(1000001));
                    out.print(", ");
                }
                out.println(random.nextInt(1000001));
            }
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Sorry, I can not create file!");
        }
    }

    public static int[][] readDataToSort(String fileRead) {
        File dataFile = new File(fileRead);
        String line;
        int[][] array = new int[16][1000];

        try {
            Scanner scanner = new Scanner(dataFile);

            int wers = 0;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                String[] arrLine = line.split(", ");
                int number = 0;
                int num = 0;
                for (String a : arrLine) {
                    number = Integer.parseInt(a);
                    array[wers][num] = number;
                    num++;
                }
                wers++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No file to read!");
        }
        return array;
    }

    public static void sortArray(int[][] array) {
        java.util.Arrays.sort(array, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Double.compare(a[0], b[0]);
            }
        });
    }
}
