import java.util.EmptyStackException;

// USING LINKED LISTS

public class stack {

    private ListNode top;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public stack(){
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return top.data;
    }

    public void printStack(stack s1){
        stack s2 = new stack();

        while(!s1.isEmpty()){
            s2.push(s1.peek());

            System.out.println(s2.peek() + " ");

             s1.pop();
        }

        
        
    }

    public static void main(String[] args) {

        stack s1 = new stack();
        s1.push(10);
        s1.push(15);
        s1.push(20);
        s1.push(25);

        s1.printStack(s1);

        // System.out.println(s1.peek()); 
        // s1.pop();
        // System.out.println(s1.peek()); 
    }
    
}
