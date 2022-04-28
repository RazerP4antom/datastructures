// Bubble Sort is the simplest sorting algorithm that works 
// by repeatedly swapping the adjacent elements if they are in the wrong order.
public class BubbleSort {

    public void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void sortAscending(int[] arr){
        int n = arr.length;
        boolean isSwapped;

        for(int i = 0; i < n - 1; i++){
            isSwapped = false;
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false)
                break;
        }
    }

    public void sortDescending(int[] arr){
        int n = arr.length;
        boolean isSwapped;

        for(int i = 0; i < n - 1; i++){
            isSwapped = false;
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false)
                break;
        }
    }


    public static void main(String[] args) {
        int arr[] = new int[] {5,1,2,9,10};
        BubbleSort bs = new BubbleSort();
        bs.printArray(arr);
        bs.sortDescending(arr);
        bs.printArray(arr);
    }

    
}


// Worst and Average Case Time Complexity: O(n*n). 
// The worst-case occurs when an array is reverse sorted.
// Best Case Time Complexity: O(n). 
// The best-case occurs when an array is already sorted.
