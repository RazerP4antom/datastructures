import java.util.Stack;

public class StringReverse {

    public static int[] printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;

    }

    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();

        for(char c : chars){
            stack.push(c);
        }

        for(int i = 0; i < str.length(); i++){
            chars[i] = stack.pop();
        }

        return new String(chars);

    }

    public static int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() <= arr[i])       
                    stack.pop();
            }

            if(stack.isEmpty())
            result[i] = -1;
            else
            result[i] = stack.peek();

            stack.push((arr[i]));
        }

        return printArray(result);

    }

    public static void main(String[] args) {
        String str = "ABCDEFG";
        System.out.println("Before reverse - " + str);
        System.out.println("After reverse - " + reverse(str));

        int[] arr = {4,7,3,4,8,1};
        printArray(arr);
        nextGreaterElement(arr);
     }
    
}
