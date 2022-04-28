

public class circularLinkedList {

    private ListNode last;
    private int length;

    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public circularLinkedList(){
        last = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    // public void createCircularLinkedList(){
    //     ListNode first = new ListNode(1);
    //     ListNode second = new ListNode(2);
    //     ListNode third = new ListNode(3);
    //     ListNode fourth = new ListNode(4);
    //     ListNode fifth = new ListNode(5);

    //     first.next = second;
    //     second.next = third;
    //     third.next = fourth;
    //     fourth.next = fifth;
    //     fifth.next = first;

    //     last = fifth;
    // }

    public void insertFirst(int data) {
		ListNode temp = new ListNode(data);
		if(last == null) {
			last = temp;
		} else {
			temp.next = last.next;
		}
		last.next = temp;
		length++;
	}

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);
        if(last == null){
            last = newNode;
            last.next = last;
        }
        else{
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }


    public void displayList(){
        if(last == null)
            return;
        
        ListNode first = last.next;
        while(first != last){
            System.out.println(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data);
    }




    public static void main(String[] args) {

        circularLinkedList cll = new circularLinkedList();
        cll.insertFirst(10);
        cll.insertFirst(15);
        cll.insertFirst(12);
        cll.insertFirst(6);
        cll.insertLast(0);
        cll.displayList();
        
    }
    
}
