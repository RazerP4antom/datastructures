public class LinkedList {
  private static ListNode head;

  private static class ListNode{
      private int data;
      private ListNode next;

      public ListNode(int data){
          this.data = data;
          this.next = null;
      }
  }

  

  public void printList(){
      ListNode n = head;
      while (n != null){
          System.out.println(n.data + " ");
          n = n.next;
      }
  }

  public int lengthList(){
      int count = 0;
      ListNode n = head;
      while (n != null){
        count++;
        n = n.next;
      }
      return count;
  }

  public void insertFirst(int value){
    ListNode newNode = new ListNode(value);
    newNode.next = head;
    head = newNode;
  }

  public void insertLast(int value){
      ListNode newNode = new ListNode(value);
      if (head == null){
          head = newNode;
          return;
      }
      ListNode n = head;
      while (null != n.next){
          n = n.next;
      }
      n.next = newNode;
  }

  public void insertAtPosition(int position, int value){
    ListNode newNode = new ListNode(value);
    if(position == 1){
        newNode.next = head;
        head = newNode;
    }else{
        ListNode previous = head;
        int count = 1;
        while (count < position-1){
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        newNode.next = current;
        previous.next = newNode;

    }

  }

  public ListNode deleteFirst(){
      if(head == null)
        return null;
      ListNode temp = head;
      head = head.next;
      temp.next = null;
      return temp;
  }

  public ListNode deleteLast(){
    if(head == null || head.next == null)
        return head;
    ListNode current = head;
    ListNode previous = null;
    while(current.next != null){
        previous = current;
        current = current.next;
    }
    previous.next = null;
    return current;
      
  }

  public void delete(int position){
    if(position == 1)
        head = head.next;
    else{
        ListNode previous = head;
        int count = 1;
        while(count < position - 1){
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = current.next;
    }

}

public boolean searchElement(ListNode head, int key){
    if(head == null){
        return false;
    }

    ListNode current = head;
    while (current != null){
        if(current.data == key)
            return true;
        current = current.next;
    }
    return false;
}

public ListNode reverseList(ListNode head){
    ListNode current = head;
    ListNode previous = null;
    ListNode next = null;
    while(current != null){
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }
    
    return previous;
}

public ListNode middleNode(){
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    while(fastPtr != null && fastPtr.next != null){
        slowPtr = slowPtr.next;
        fastPtr = fastPtr.next.next;
    
    }
    return slowPtr;
}

public ListNode nthNodeFromEnd(int n){
    ListNode mainPtr = head;
    ListNode refPtr = head;
    int count = 0;
    while(count < n){
        refPtr = refPtr.next;
        count++;
    }
    while(refPtr != null){
        refPtr = refPtr.next;
        mainPtr = mainPtr.next;
    }
    
    return mainPtr;
}


public void removeDuplicate(){
    if(head == null){
        return;
    }

    ListNode current = head;
    while(current != null && current.next != null){
        if(current.data == current.next.data){
            current.next = current.next.next;
        }else{
            current = current.next;
        }
    }
}

public ListNode insertInSortedList(int value){
    ListNode newNode = new ListNode(value);
    if(head == null)
        return newNode;
    
    ListNode current = head;
    ListNode temp = null;
    while(current != null && current.data < newNode.data){
        temp = current;
        current = current.next;
    }
    newNode.next = current;
    temp.next = newNode;
    return head;
}

public void deleteNode(int key){
    ListNode current = head;
    ListNode temp = null;

    if(current != null && current.data == key){
        head = current.next;
        return;
    }

    while(current != null && current.data != key){
        temp = current;
        current = current.next;
    }
    if(current == null)
        return;
     temp.next = current.next;
}

// Floyd's cycle  detection algorithm

public boolean containsLoop(){
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    
    while(fastPtr != null && fastPtr.next != null){
        fastPtr = fastPtr.next.next;
        slowPtr = slowPtr.next;

        if(slowPtr == fastPtr)
            return true;
    }
    return false;
}

public ListNode startingNodeInALoop(){
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    
    while(fastPtr != null && fastPtr.next != null){
        fastPtr = fastPtr.next.next;
        slowPtr = slowPtr.next;

        if(slowPtr == fastPtr)
            return getStartingNode(slowPtr);
    }
    return null;
}

private ListNode getStartingNode (ListNode slowPtr){
    ListNode temp = head;
    while(temp != slowPtr){
        temp = temp.next;
        slowPtr = slowPtr.next;
    }
    
    return temp; // starting node of the loop
}

public ListNode removingLoop(){
    ListNode slowPtr = head;
    ListNode fastPtr = head;
    
    while(fastPtr != null && fastPtr.next != null){
        fastPtr = fastPtr.next.next;
        slowPtr = slowPtr.next;

        if(slowPtr == fastPtr){
            removeLoop(slowPtr);
        }
        
    }
    return null;
}

private void removeLoop(ListNode slowPtr){
    ListNode temp = head;
    while(temp.next != slowPtr.next){
        temp = temp.next;
        slowPtr = slowPtr.next;
    }

    slowPtr.next = null;
}


public void creatALoopInLinkedList(){
    ListNode first = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    ListNode fouth = new ListNode(4);
    ListNode fifth = new ListNode(5);
    ListNode sixth = new ListNode(6);

    head = first;
    first.next = second;
    second.next = third;
    third.next = fouth;
    fouth.next = fifth;
    fifth.next = sixth;
    sixth.next = third;

}




public static ListNode merge(ListNode a, ListNode b){
    ListNode dummy = new ListNode(0); // provides a concrete object in the heap so that one can avoid null pointer exception
    ListNode tail = dummy;

    while(a != null && b != null){
        if(a.data <= b.data){
            tail.next = a;
            a = a.next;
        }else{
            tail.next = b;
            b = b.next;
        }
        tail = tail.next;
    }
    if(a == null){
        tail.next = b;
    }else{
        tail.next = a;
    }

    return dummy.next;
}



  public static void main(String[] args) {

    //   LinkedList sil = new LinkedList();

    //   LinkedList sil1 = new LinkedList();
    //   sil1.insertLast(1);
    //   sil1.insertLast(4);
    //   sil1.insertLast(8);
    //   //sil1.printList();

    //   System.out.println("////////");

    //   LinkedList sil2 = new LinkedList();
    //   sil2.insertLast(3);
    //   sil2.insertLast(5);
    //   sil2.insertLast(8);
    //   sil2.insertLast(9);
    //   sil2.insertLast(14);
    //   sil2.insertLast(18);
    //   sil2.printList();

    //   LinkedList sil3 = new LinkedList();
    //   sil3.insertFirst(18);
    //   sil3.insertFirst(14);
    //   sil3.insertFirst(9);
    //   sil3.insertFirst(8);
    //   sil3.insertFirst(5);
    //   sil3.insertFirst(3);
     // sil3.printList();
      
     
      
    //   LinkedList result = new LinkedList();
    //   LinkedList.head = merge(LinkedList.head, LinkedList.head);
    //   result.printList();

    //   sil.head = new ListNode(1);
    //   ListNode second = new ListNode(2);
    //   ListNode third = new ListNode(3);

    //   sil.head.next = second;
    //   second.next = third;
    //  //   sil.insertFirst(0);
    //   sil.insertLast(4);
    //   sil.insertAtPosition(3, -5);

    //   sil.insertFirst(16);
    //   sil.insertFirst(10);
    //   sil.insertFirst(8);
    //   sil.insertFirst(1);
     


    //   sil.printList(head);
    //   sil.insertInSortedList(11);
    //   System.out.println("/////////////////");
    //   sil.printList(head);
    //   sil.deleteNode(11);
    //   System.out.println("//////////////");
    //   sil.printList(head);
    //   System.out.println("Length of list is: " + sil.lengthList());
    //   sil.removeDuplicate();
    //   System.out.println("After removing duplicates: \n");
    //   sil.printList(head);
      

     //   System.out.println("Head deleted is: " + sil.deleteFirst().data);
     //   sil.printList();
    

     //   System.out.println("Tail deleted is: " + sil.deleteLast().data);
     //   sil.printList();



     //   sil.delete(3);
     //   System.out.println("///////////////////");
     //   sil.printList();



     // if(sil.searchElement(head, 2)){
     //     System.out.println("Key is found");
     // }else{
     //     System.out.println("Key not found");
     // }



        // ListNode reverseListHead = sil.reverseList(head);
        // sil.printList(reverseListHead);



        // System.out.println("Middle node is: " + sil.middleNode().data);
  
        // System.out.println("2nd element from the end: " + sil.nthNodeFromEnd(2).data);


        // sil.creatALoopInLinkedList();
        // System.out.println(sil.containsLoop());
        // System.out.println(sil.startingNodeInALoop().data);
        // System.out.println("Removing loop");
        // sil.removingLoop();
        // System.out.println(sil.containsLoop());






    }

}
