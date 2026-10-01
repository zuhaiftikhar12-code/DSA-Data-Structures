import java.util.*;

public class LL {
    Node head;
    private int size;
    LL(){
        size=0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("Null");
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }
    public void removeLast(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }

        Node secondLast=head;
        Node lastNode=head.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
            secondLast=secondLast.next;
        }
        secondLast.next=null;
    }
    public int getSize(){
        return size;
    }
    public void addInMiddle(int index,String data){
        if(index>size||index<0){
            System.out.println("Invalid index");
        }
        size++;
        Node newNode=new Node(data);
        if(head==null||index==0){
            newNode.next=head;
            head=newNode;
            return;
        }
        Node currNode=head;
        for(int i=1;i<size;i++){
            if(i==index){
                Node nextNode=currNode.next;
                currNode.next=newNode;
                newNode.next=nextNode;
                break;
            }
            currNode=currNode.next;
        }
        
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.printList();
        list.addLast("list");
        list.addFirst("This");
        list.printList();
        list.removeFirst();
        list.printList();
        list.removeLast();
        list.printList();
        System.out.println("size: "+list.getSize());
        list.addLast("list");
        System.out.println("size: "+list.getSize());
        list.addFirst("This");
        System.out.println("size: "+list.getSize());
        list.addInMiddle(3,"big");
        list.printList();
    }
}

// import java.util.LinkedList;
// public class LL {

//     public static void main(String[] args) {
//         LinkedList<String> list =new LinkedList<>();
//         list.add("is");
//         list.addFirst("this");
//         list.addLast("a");
//         list.addLast("list");
//         System.out.println(list);
//         list.removeFirst();
//         list.remove("a");
//         System.out.println(list);
//         list.add(1,"a");
//         System.out.println(list);
//         System.out.println(list.size());
//         System.out.println(list.get(1));
//     }
// }