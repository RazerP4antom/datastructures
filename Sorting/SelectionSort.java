// The selection sort algorithm sorts an array by r
// epeatedly finding the minimum element from unsorted part 
// and putting it at the beginning.
// The algorithm maintains two subarrays in a given array.

public class SelectionSort {

    public void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void sortAscending(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){ // one by one moving the boundary of the unsorted array
            int minIndex = i;

            // Find the minimum element in unsorted array
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }

            // Swap the found minimum element with the first element

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

    }

    public void sortDescending(int[] arr){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int maxIndex = i;

            for(int j = i + 1; j < n; j++){
                if(arr[j] > arr[maxIndex])
                    maxIndex = j;
            }

            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[] {3,1,2,5,9,7};
        SelectionSort ss = new SelectionSort();
        ss.printArray(arr);
        ss.sortDescending(arr);
        ss.printArray(arr);
    }
    
}
