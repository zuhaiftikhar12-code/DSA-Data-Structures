public class Stack_using_LL {
    static class Node{
        int data;
        Node next;
        Node(int data){
        this.data=data;
        this.next=null;
        }
    }
    static class Stack{
        static Node head=null;

        public Boolean isEmpty(){
            return head==null;
        }

        public void push(int data){
        Node newNode = new Node(data);
        newNode.next=head;
        head=newNode;
        }

        public  int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("stack is empty");
                return -1;
            }
            return head.data;
        }

        public void print(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ->" );
                temp=temp.next;
            }
            System.out.println("null");
        }

    }
    public static void main(String[] args) {
        Stack s =new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.print();
        System.out.println("Peek element: "+s.peek());
        s.pop();
        s.pop();
        s.print();
    }

}
