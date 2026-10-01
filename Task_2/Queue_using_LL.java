import java.util.Scanner;

public class Queue_using_LL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {

        static Node head = null;
        Node tail = null;

        // 1. isEmpty
        public Boolean isEmpty() {
            return (head == null || tail == null);
        }

        // 2. Enqueue
        public void enqueue(int data) {
            Node newNode = new Node(data);

            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            System.out.println("Value enqueued successfully");
        }

        // 3. Dequeue
        public int dequeue() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int top = head.data;
            head = head.next;

            if (head == null) {
                tail = null;
            }

            System.out.println("Dequeued value: " + top);
            return top;
        }

        // 4. Peek
        public int peek() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return head.data;
        }

        // 5. Display
        public void print() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue q = new Queue();

        int choice;

        do {

            System.out.println("\n--- QUEUE USING LINKED LIST ---");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. isEmpty");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();

                    q.enqueue(value);
                    break;

                case 2:
                    q.dequeue();
                    break;

                case 3:
                    if (!q.isEmpty()) {
                        System.out.println("Peek element: " + q.peek());
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;

                case 4:
                    q.print();
                    break;

                case 5:
                    if (q.isEmpty()) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Queue is not empty");
                    }
                    break;

                case 6:
                    System.out.println("Program ended");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}