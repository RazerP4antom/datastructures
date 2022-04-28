public class LinearSearchAlgo {
    
    public static int search(int[] arr, int n, int x){
        for(int i = 0; i < n; i++){
            if(arr[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,9,2,10,15,20};
        int temp = search(arr, arr.length, 15);
        if(temp != -1)
            System.out.println("Element found at index: " + temp);
        else
            System.out.println("Element not found");

        
    }
}
