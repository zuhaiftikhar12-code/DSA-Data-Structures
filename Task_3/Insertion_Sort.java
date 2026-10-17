import java.util.*;

public class Insertion_Sort{
    // Method to print all elements of the array
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr=new int[1000];
        Random random=new Random(123456);
        // input elements in array
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(1000);
        }
        // Record the end time before sorting
        long start=System.nanoTime();
        // insertion sort
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                // Keep swapping
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
        long end=System.nanoTime();
        // Record the end time after sorting
        long time=end-start;
        System.out.println("===== Insertion Sorted Array =====");
        System.out.println("Total elements: "+arr.length);
        System.out.println("Execution Time in nanoseconds: "+time);
        System.out.println("Execution Time in milliseconds: "+time/1_000_000.0);
        printArray(arr);
    }
}
