import java.util.Scanner;

public class Circular_Queue {

    static Scanner sc = new Scanner(System.in);

    static int Front = -1;
    static int Rear = -1;

    static int size = 5;
    static int[] queue = new int[size];

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n------ CIRCULAR QUEUE MENU ------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter value to enqueue:");
                    int value = sc.nextInt();
                    enqueue(value);
                    break;

                case 2:
                    dequeue();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    size();
                    break;

                case 5:
                    System.out.println("isEmpty: " + isEmpty());
                    break;

                case 6:
                    System.out.println("isFull: " + isFull());
                    break;

                case 7:
                    System.out.println("---- Exiting ----");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }


    // Enqueue Function
    static void enqueue(int value) {

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (Front == -1) {
            Front = 0;
        }


        Rear = (Rear + 1) % size;

        queue[Rear] = value;

        System.out.println(value + " added to the queue");
    }


    // DEQUEUE Function
    static void dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Removed Value: " + queue[Front]);

        if (Front == Rear) {
            Front = -1;
            Rear = -1;
        }
        else {
            Front = (Front+ 1) % size;
        }
    }


    // DISPLAY
    static void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println("Queue values from front to rear:");

        int i = Front;

        while (true) {

            System.out.print(queue[i] + " ");

            if (i == Rear) {
                break;
            }

            i = (i + 1) % size;
        }

        System.out.println();
    }


    // Size Function
    static void size() {

        if (isEmpty()) {
            System.out.println("Queue size: 0");
        }
        else if (Rear >= Front) {
            int count = Rear - Front + 1;
            System.out.println("Queue size: " + count);
        }
        else {
            int count = (size - Front) + (Rear + 1);
            System.out.println("Queue size: " + count);
        }
    }


    // IsEmpty Function
    static boolean isEmpty() {
        return Front == -1;
    }


    // is Full Function
    static boolean isFull() {
        return (Rear + 1) % size == Front;
    }
}