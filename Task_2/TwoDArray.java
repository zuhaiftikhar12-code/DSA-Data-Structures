import java.util.Scanner;

class TwoDArray {

    static int[][] arr = new int[3][3];
    static int size = 0;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== 2D ARRAY MENU =====");
            System.out.println("1. Add Value");
            System.out.println("2. Insert at Position");
            System.out.println("3. Fill Array");
            System.out.println("4. Delete Last Element");
            System.out.println("5. Delete by Position");
            System.out.println("6. Display");
            System.out.println("7. Search Value");
            System.out.println("8. Get Value");
            System.out.println("9. Update Value");
            System.out.println("10. Size");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    add();
                    break;

                case 2:
                    insert();
                    break;

                case 3:
                    fill();
                    break;

                case 4:
                    deleteLast();
                    break;

                case 5:
                    deletePosition();
                    break;

                case 6:
                    display();
                    break;

                case 7:
                    search();
                    break;

                case 8:
                    getValue();
                    break;

                case 9:
                    update();
                    break;

                case 10:
                    showSize();
                    break;

                case 11:
                    System.out.println("Program Ended");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 11);
    }


    // 1. Add Value
    static void add() {

        if (size == 9) {
            System.out.println("Array is Full!");
            return;
        }

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        int row = size / 3;
        int col = size % 3;

        arr[row][col] = value;

        size++;

        System.out.println("Value Added!");
    }


    // 2. Insert at Position
    static void insert() {

        if (size == 9) {
            System.out.println("Array is Full!");
            return;
        }

        System.out.print("Enter row (0-2): ");
        int row = sc.nextInt();

        System.out.print("Enter column (0-2): ");
        int col = sc.nextInt();

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid Position!");
            return;
        }

        System.out.print("Enter value: ");
        int value = sc.nextInt();

        int position = row * 3 + col;

        // Values ko right side shift karna
        for (int i = size; i > position; i--) {

            int oldRow = (i - 1) / 3;
            int oldCol = (i - 1) % 3;

            int newRow = i / 3;
            int newCol = i % 3;

            arr[newRow][newCol] = arr[oldRow][oldCol];
        }

        arr[row][col] = value;

        size++;

        System.out.println("Value Inserted!");
    }


    // 3. Fill Array
    static void fill() {

        if (size == 9) {
            System.out.println("Array is already Full!");
            return;
        }

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (size < 9) {

                    System.out.print(
                        "Enter value for [" + i + "][" + j + "]: "
                    );

                    arr[i][j] = sc.nextInt();

                    size++;
                }
            }
        }

        System.out.println("Array Filled!");
    }


    // 4. Delete Last Element
    static void deleteLast() {

        if (size == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        size--;

        int row = size / 3;
        int col = size % 3;

        arr[row][col] = 0;

        System.out.println("Last Value Deleted!");
    }


    // 5. Delete by Position
    static void deletePosition() {

        if (size == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        System.out.print("Enter row: ");
        int row = sc.nextInt();

        System.out.print("Enter column: ");
        int col = sc.nextInt();

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid Position!");
            return;
        }

        int position = row * 3 + col;

        if (position >= size) {
            System.out.println("No Value at this Position!");
            return;
        }

        // Values ko left side shift karna
        for (int i = position; i < size - 1; i++) {

            int currentRow = i / 3;
            int currentCol = i % 3;

            int nextRow = (i + 1) / 3;
            int nextCol = (i + 1) % 3;

            arr[currentRow][currentCol] =
                    arr[nextRow][nextCol];
        }

        size--;

        int lastRow = size / 3;
        int lastCol = size % 3;

        arr[lastRow][lastCol] = 0;

        System.out.println("Value Deleted!");
    }


    // 6. Display
    static void display() {

        if (size == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        System.out.println("\nArray:");

        int count = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (count < size) {
                    System.out.print(arr[i][j] + "\t");
                    count++;
                }
            }

            System.out.println();
        }
    }


    // 7. Search
    static void search() {

        if (size == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        System.out.print("Enter value to search: ");
        int value = sc.nextInt();

        int count = 0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (count < size && arr[i][j] == value) {

                    System.out.println(
                        "Value found at [" + i + "][" + j + "]"
                    );

                    return;
                }

                count++;
            }
        }

        System.out.println("Value Not Found!");
    }


    // 8. Get Value
    static void getValue() {

        if (size == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        System.out.print("Enter row: ");
        int row = sc.nextInt();

        System.out.print("Enter column: ");
        int col = sc.nextInt();

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid Position!");
            return;
        }

        int position = row * 3 + col;

        if (position >= size) {
            System.out.println("No Value at this Position!");
            return;
        }

        System.out.println("Value = " + arr[row][col]);
    }


    // 9. Update Value
    static void update() {

        if (size == 0) {
            System.out.println("Array is Empty!");
            return;
        }

        System.out.print("Enter row: ");
        int row = sc.nextInt();

        System.out.print("Enter column: ");
        int col = sc.nextInt();

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid Position!");
            return;
        }

        int position = row * 3 + col;

        if (position >= size) {
            System.out.println("No Value at this Position!");
            return;
        }

        System.out.print("Enter new value: ");
        int value = sc.nextInt();

        arr[row][col] = value;

        System.out.println("Value Updated!");
    }


    // 10. Size
    static void showSize() {

        System.out.println("Filled Boxes = " + size);
        System.out.println("Empty Boxes = " + (9 - size));
        System.out.println("Total Boxes = 9");
    }
}