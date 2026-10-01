import java.util.Scanner;

public class circular_LL {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class circularList {

        public static Node head;
        static Node tail;

        // 1. isEmpty
        public Boolean isEmpty() {
            return head == null;
        }

        // 2. Add First
        public void addFirst(int data) {

            Node newNode = new Node(data);

            if (isEmpty()) {
                head = tail = newNode;
                tail.next = head;
                return;
            }

            newNode.next = head;
            head = newNode;
            tail.next = head;

            System.out.println("Value added at first");
        }

        // 3. Add Last
        public void addLast(int data) {

            Node newNode = new Node(data);

            if (isEmpty()) {
                head = tail = newNode;
                tail.next = head;
                return;
            }

            tail.next = newNode;
            tail = newNode;
            tail.next = head;

            System.out.println("Value added at last");
        }

        // 4. Remove First
        public void removeFirst() {

            if (isEmpty()) {
                System.out.println("List is empty");
                return;
            }

            // Agar sirf ek node hai
            if (head == tail) {
                head = tail = null;
                System.out.println("First value removed");
                return;
            }

            Node temp = head;

            head = head.next;
            tail.next = head;
            temp.next = null;

            System.out.println("First value removed");
        }

        // 5. Remove Last
        public void removeLast() {

            if (isEmpty()) {
                System.out.println("List is empty");
                return;
            }

            // Agar sirf ek node hai
            if (head == tail) {
                head = tail = null;
                System.out.println("Last value removed");
                return;
            }

            Node prev = head;

            while (prev.next != tail) {
                prev = prev.next;
            }

            tail.next = null;
            tail = prev;
            tail.next = head;

            System.out.println("Last value removed");
        }

        // 6. Display
        public void print() {

            if (isEmpty()) {
                System.out.println("Circular list is empty");
                return;
            }

            System.out.print("Circular List: ");

            System.out.print(head.data + " -> ");

            Node temp = head.next;

            while (temp != head) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }

            System.out.println("Back to Head");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        circularList c = new circularList();

        int choice;

        do {

            System.out.println("\n--- CIRCULAR LINKED LIST ---");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Remove First");
            System.out.println("4. Remove Last");
            System.out.println("5. Display");
            System.out.println("6. isEmpty");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    int firstValue = sc.nextInt();

                    c.addFirst(firstValue);
                    break;

                case 2:
                    System.out.print("Enter value: ");
                    int lastValue = sc.nextInt();

                    c.addLast(lastValue);
                    break;

                case 3:
                    c.removeFirst();
                    break;

                case 4:
                    c.removeLast();
                    break;

                case 5:
                    c.print();
                    break;

                case 6:
                    if (c.isEmpty()) {
                        System.out.println("Circular List is empty");
                    } else {
                        System.out.println("Circular List is not empty");
                    }
                    break;

                case 7:
                    System.out.println("Program ended");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 7);

        sc.close();
    }
}