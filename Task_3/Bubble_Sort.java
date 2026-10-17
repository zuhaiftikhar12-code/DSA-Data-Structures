import java.util.*;

public class Bubble_Sort {
    // Method to print all elements of the array
    public static void PrintArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Create array of thousand random Elements
        int arr[] = new int[1000];
        Random random = new Random(12345);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }

        // Record the end time before sorting
        long start = System.nanoTime();
        // Bubble Sort
        for (int i = 0; i < arr.length - 1; i++) { // n-1
            for (int j = 0; j < arr.length - i - 1; j++) { // n(n-1)/2
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            } // Time Complexity = O(n^2)
        }

        // Record the end time after sorting
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("===== Bubble Sorted Array =====");
        System.out.println("Total Elements:" + arr.length);
        System.out.println("Execution time in NanoSeconds:" + time);
        System.out.println("Execution time in MilliSeconds:" + time / 1_000_000.0);
        PrintArr(arr);
    }

}