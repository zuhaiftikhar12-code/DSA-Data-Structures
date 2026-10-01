import java.util.Scanner;

public class Queue {
    static int[] queue = new int[10];
    static int front = -1;
    static int rear = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Value: ");
                    int value = sc.nextInt();

                    if (rear == queue.length - 1) {
                        System.out.println("Queue is full");
                    } else {
                        if (front == -1) {
                            front = 0;
                        }

                        rear++;
                        queue[rear] = value;
                    }
                    break;

                case 2:
                    if (front == -1 || front > rear) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Dequeue value: " + queue[front]);
                        front++;

                        // Queue empty ho gayi
                        if (front > rear) {
                            front = -1;
                            rear = -1;
                        }
                    }
                    break;

                case 3:
                    if (front == -1 || front > rear) {
                        System.out.println("Queue is empty");
                    } else {
                        for (int i = front; i <= rear; i++) {
                            System.out.println(queue[i]);
                        }
                    }
                    break;

                case 4:
                    if (front == -1) {
                        System.out.println("Size of queue: 0");
                    } else {
                        System.out.println("Size of queue: " + (rear - front + 1));
                    }
                    break;

                case 5:
                    if (front == -1) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Queue is not empty");
                    }
                    break;

                case 6:
                    if (rear == queue.length - 1) {
                        System.out.println("Queue is full");
                    } else {
                        System.out.println("Queue is not full");
                    }
                    break;

                case 7:
                    System.out.println("Program ended");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 7);
    }
}