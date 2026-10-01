import java.util.Scanner;

public class Array {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int size = 0;
        int choice;

        do {
            System.out.println("\n--- ARRAY MENU ---");
            System.out.println("1. Add at end");
            System.out.println("2. Insert at index");
            System.out.println("3. Fill multiple values");
            System.out.println("4. Delete last");
            System.out.println("5. Delete by index");
            System.out.println("6. Display");
            System.out.println("7. Search");
            System.out.println("8. Get value at index");
            System.out.println("9. Update value");
            System.out.println("10. Show size");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    if (size == arr.length) {
                        System.out.println("Array is full");
                    } else {
                        arr[size] = value;
                        size++;
                    }
                    break;

                case 2:
                    System.out.println("Enter index: ");
                    int index = sc.nextInt();
                    if (index < 0 || index > size) {
                        System.out.println("Invalid index");
                    } else if (size == arr.length) {
                        System.out.println("array is full");
                    } else {
                        System.out.println("Enter value: ");
                        int V = sc.nextInt();
                        for (int i = size; i > index; i--) {
                            arr[i] = arr[i - 1];
                        }
                        arr[index] = V;
                        size++;
                        System.out.println("Value inserted");
                    }
                    break;

                case 3:
                    while (size < arr.length) {
                        System.out.println("Enter value:");
                        int val = sc.nextInt();
                        arr[size] = val;
                        size++;
                        if (size == arr.length) {
                            System.out.println("array is full");
                            break;
                        }
                        System.out.println("Do you want to insert more value (Yes=1,N0=0)");
                        int again = sc.nextInt();
                        if (again == 0) {
                            break;
                        }
                    }
                    break;

                case 4:
                    if (size == 0) {
                        System.out.println("array is empty");
                    } else {
                        size--;
                        System.out.println("Last value deleted");
                    }
                    break;

                case 5:
                    System.out.print("Enter Index: ");
                    int Index = sc.nextInt();
                    if (size == 0) {
                        System.out.println("array is empty");
                    } else if (Index < 0 || Index >= size) {
                        System.out.println("Invalid index");
                    } else {
                        for (int l = Index; l < size - 1; l++) {
                            arr[l] = arr[l + 1];
                        }
                        size--;
                    }
                    break;

                case 6:
                    if (size == 0) {
                        System.out.println("array is empty");
                    } else {
                        for (int j = 0; j < size; j++) {
                            System.out.println(arr[j]);
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter value for search: ");
                    int Value = sc.nextInt();
                    boolean found = false;
                    for (int k = 0; k < size; k++) {
                        if (Value == arr[k]) {
                            System.out.println("value found at index " + k);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("value not found");
                    }
                    break;

                case 8:
                    System.out.print("Enter Index: ");
                    int getIndex = sc.nextInt();
                    if (size == 0) {
                        System.out.println("array is empty");
                    } else if (getIndex < 0 || getIndex >= size) {
                        System.out.println("Invalid index");
                    } else {
                        System.out.println("The value at " + getIndex + ":" + arr[getIndex]);
                    }
                    break;

                case 9:
                    System.out.print("Enter value of index: ");
                    int updateIndex = sc.nextInt();
                    if (size == 0) {
                        System.out.println("array is empty");
                    } else if (updateIndex < 0 || updateIndex >= size) {
                        System.out.println("Invalid index");
                    } else {
                        System.out.print("Enter new value: ");
                        int newValue = sc.nextInt();
                        arr[updateIndex] = newValue;
                        System.out.println("value updated");
                    }
                    break;

                case 10:
                    System.out.println("Current size: " + size);
                    System.out.println("empty spaces: "+(arr.length-size));
                    break;

                case 11:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 11);
    }
}