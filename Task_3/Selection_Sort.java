import java.util.*;
public class Selection_Sort {
    public static void printArray(int A[]){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr=new int[1000];
        Random random=new Random(12345);
        // input elements in array
        for(int i=0;i<arr.length;i++){
            arr[i]=random.nextInt(1000);
        }
        
        long start=System.nanoTime();
        //Selection sorting
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest=i;//0
            for (int j = i+1; j <arr.length; j++) {
                if (arr[smallest]>arr[j]) {
                    smallest=j;
                }
            }
            //Swap
            int temp=arr[i];
            arr[i]=arr[smallest];
            arr[smallest]=temp;
        }
        long end =System.nanoTime();
        long time=end-start;
        System.out.println("=====selection Sorted Array=====");
        System.out.println("Total elements: "+arr.length);
        System.out.println("Execution Time in NanoSeconds: "+time);
        System.out.println("Execution Time in MilliSeconds: "+time/1_000_000.0);
        printArray(arr);
    }
}
