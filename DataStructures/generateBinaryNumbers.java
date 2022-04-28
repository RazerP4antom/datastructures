import java.util.LinkedList;
import java.util.Queue;

public class generateBinaryNumbers {

    public static String[] printArray(String[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;

    }

    public static String[] generateBinary(int n){
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for(int i = 0; i < n; i++){
            result[i] = q.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            q.offer(n1);
            q.offer(n2);
        }
        return printArray(result);
    }


    public static void main(String[] args) {
        generateBinary(5);
    }


    
}
