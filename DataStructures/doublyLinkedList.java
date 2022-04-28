import java.util.NoSuchElementException;

public class doublyLinkedList{

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;


        public ListNode(int data){
            this.data = data;
        }
    }

    public doublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0; // head == null
    }

    public int length(){
        return length;
    }

    public void displayForward(){
        if(head == null)
            return;
        
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println("\n");
    }

    public void displayBackward(){
        if(tail == null)
            return;
        
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.previous;
        }
        System.out.print("null");
        System.out.println("\n");
    }

    public void insertFirst(int value) { // push basically 
        ListNode newNode = new ListNode(value);

        if(isEmpty())
            tail = newNode;
        
        else{
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertLast(int value) { // append basically
        ListNode newNode = new ListNode(value);

        if(isEmpty())
            head = newNode;
        else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public void insertBefore(ListNode nextNode, int value){

        if(nextNode == null){
            System.out.println("The given next node cannot be NULL");
            return;
        }

        ListNode newNode = new ListNode(value);
        newNode.previous = nextNode.previous;
        nextNode.previous = newNode;
        newNode.next = nextNode;

        if(newNode.previous != null){
            newNode.previous.next = newNode;
        }
        else
            head = newNode;
    }

    public void insertAfter(ListNode prevNode, int value){

        if(prevNode == null){
            System.out.println("The given previous node cannot be NULL");
            return;
        }

        ListNode newNode = new ListNode(value);
        newNode.previous = prevNode;
        newNode.next = prevNode.next;
        prevNode.next = newNode;

        if(newNode.next != null){
            newNode.next.previous = newNode;
        }
        else
            tail = newNode;

    }

    public ListNode deleteAtStart() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = head;
        if(head == tail){
            tail = null;
        }
        else{
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteAtEnd() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = tail;
        if(head == tail){
            head = null;
        }
        else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;

        
    }

    public void deleteNode(ListNode del){

        if(head == null || del == null){
            return;
        }

        if(head == del){
            head = del.next;
            length--;
        }

        if(del.next != null){
            del.next.previous = del.previous;
            length--;
        }

        if(del.previous != null){
            del.previous.next = del.next;
            length--;
        }

        return;
     }




    public static void main(String[] args) {
        doublyLinkedList dll = new doublyLinkedList();

        dll.insertFirst(1);
        dll.insertFirst(3);
        dll.insertFirst(10);
        dll.insertFirst(14);
        dll.insertFirst(18);
        dll.insertLast(0);
    
        
        dll.insertBefore(dll.head.next.next, 11);
        dll.insertAfter(dll.head.next.next.next, 7);
        dll.displayForward();
        dll.deleteNode(dll.head.next);
        dll.displayForward();

        // dll.deleteAtStart();
        // dll.displayForward();
        // // dll.displayBackward();

        // dll.deleteAtEnd();
        // dll.displayForward();
        
    

    }


}