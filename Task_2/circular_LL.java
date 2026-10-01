public class circular_LL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class circularList{
        public static Node head;
        static Node tail;

        public Boolean isEmpty(){
            return (head==null);
        }
        public void addFirst(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=tail=newNode;
                tail.next=head;
                return;
            }
            newNode.next=head;
            head=newNode;
            tail.next=head;
        }
        public void addLast(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=tail=newNode;
                tail.next=head;
                return;
            }
            tail.next=newNode;
            tail=newNode;
            tail.next=head;
        }
        public void removeFirst(){
            if(isEmpty()){
                System.out.println("List is empty");
                return;
            }
            Node temp=head;
            head=head.next;
            tail.next=head;
            temp.next=null;
        }public  void removeLast(){
            if(isEmpty()){
                System.out.println("List is empty");
                return;
            }
            Node prev=head;
            while(prev.next!=tail){
                prev=prev.next;
            }
            tail.next=null;
            tail=prev;
            tail.next=head;
        }
        public void print(){
            if(isEmpty()){
                System.out.println("Circular list is empty");
                return;
            }
            System.out.print(head.data+"->");
            Node temp=head.next;
            while(temp!=head){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
            System.out.print(temp.data);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        circularList c = new circularList();
        c.addFirst(1);
        c.addFirst(2);
        c.addFirst(3);
        c.addFirst(4);
        c.print();
        c.addLast(5);
        c.addLast(6);
        c.print();
        c.removeFirst();
        c.removeFirst();
        c.print();
        c.removeLast();
        c.removeLast();
        c.print();
    }
}