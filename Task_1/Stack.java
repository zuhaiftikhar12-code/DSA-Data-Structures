import java.util.Scanner;

public class Stack {

    static int[] stack = new int[10];
    static int top = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- STACK MENU ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value=sc.nextInt();
                    if(top==stack.length-1){
                        System.out.println("Stack is full");
                    }
                    else{
                        top++;
                        stack[top]=value;
                        System.out.println("values pushed");
                    }
                    break;
                case 2:
                    if(top==-1){
                        System.out.println("stack is empty");
                    }else{
                        System.out.println("popped value: "+stack[top]);
                        top--;
                    }
                    break;
                case 3:
                    if(top==-1){
                        System.out.println("stack is empty");
                    }else{
                        for(int i=0;i<top+1;i++){
                            System.out.println(stack[i]);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Size of stack: "+(top+1));
                    break;
                case 5:
                    if(top==-1){
                        System.out.println("Stack is empty");
                    }else{
                        System.out.println("Stack is not empty");
                    }
                    break;
                case 6:
                    if(top==stack.length-1){
                        System.out.println("Stack is full");
                    }else{
                        System.out.println("Stack is not full");
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