import java.util.*;
public class Merge_sort {
    public static void printArray(int A[]){
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
    public static void conquer(int arr[],int si,int mid,int ei){
        int[] merged=new int[ei-si+1];
        int idx1=si;
        int idx2=mid+1;
        int x=0;
        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<arr[idx2]){
                merged[x++]=arr[idx1++];
            }else{
                merged[x++]=arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++]=arr[idx1++];
        }
        while(idx2<=ei){
            merged[x++]=arr[idx2++];
        }
        for(int i=0,j=si;i<merged.length;i++,j++){
            arr[j]=merged[i];
        }
    }
    public static void divide(int arr[],int si,int ei) {
        if(si>=ei){
            return;
        }
        int mid=si+(ei-si)/2;
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid, ei);
    }
    public static void main(String[] args){
        Random random=new Random(12345);
        int[] arr=new int[1000];
        int n=arr.length;
        // inserting array elements
        for(int i=0;i<n;i++){
            arr[i]=random.nextInt(1000);
        }
        //merge sorting
        long start=System.nanoTime();
        divide(arr,0,n-1);
        long end=System.nanoTime();
        long time=end-start;
        System.out.println("===== Merge Sorted Array =====");
        System.out.println("Execution time in nanoseconds: "+time);
        System.out.println("Execution time in milliseconds: "+time/1_000_000.0);
        printArray(arr);
    }
}
