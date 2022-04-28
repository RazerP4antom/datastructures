public class stack2 {
    private final int MAX = 1000;
    private int top;
    private int[] a = new int[MAX];

    public stack2(){
        top = -1;
    }

    boolean isEmpty(){
        return (top < 0);
    }


    boolean push(int x){
        if(top >= (MAX-1)){
            System.out.println("Stack Overflow");
            return false;
        }
        else{
            a[++top] = x;
            return true;
        }
    }

    public int pop(){
        if(top < 0){
            System.out.println("Stack Underflow");
        }
        else{
            int x = a[top--];
            return x;
        }
        return MAX;
    }

    public int peek(){
        if(top < 0){
            System.out.println("Stack Underflow");
        }
        else{
            int x = a[top];
            return x;
        }
        return MAX;
    }

    public void printStack(stack2 s){
        stack2 s1 = new stack2();

        while(!s.isEmpty()){
            s1.push(s.peek());
            System.out.println(s1.peek() + " ");
            s.pop();
        }
    }


    public static void main(String[] args) {
        stack2 stack = new stack2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printStack(stack);
    }

    
}
