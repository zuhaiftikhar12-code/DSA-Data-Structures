import java.util.Scanner;

public class Stack_using_LL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {

        static Node head = null;

        // 1. isEmpty
        public Boolean isEmpty() {
            return head == null;
        }

        // 2. Push
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;

            System.out.println("Value pushed successfully");
        }

        // 3. Pop
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = head.data;
            head = head.next;

            System.out.println("Popped value: " + top);
            return top;
        }

        // 4. Peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            return head.data;
        }

        // 5. Display
        public void print() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
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

        Stack s = new Stack();

        int choice;

        do {

            System.out.println("\n--- STACK USING LINKED LIST ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
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

                    s.push(value);
                    break;

                case 2:
                    s.pop();
                    break;

                case 3:
                    if (!s.isEmpty()) {
                        System.out.println("Peek element: " + s.peek());
                    } else {
                        System.out.println("Stack is empty");
                    }
                    break;

                case 4:
                    s.print();
                    break;

                case 5:
                    if (s.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Stack is not empty");
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