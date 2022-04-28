// Insertion sort is a simple sorting algorithm that works similar 
// to the way you sort playing cards in your hands. 
// The array is virtually split into a sorted and an unsorted part. 
// Values from the unsorted part are picked and placed at the correct position in the sorted part.



public class InsertionSort {

    public void printArray(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void sortAscending(int[] arr){
        int n = arr.length;

        for(int i = 1; i < n; i++){ // unsorted part
            int temp = arr[i];
            int j = i -1; // sorted part

            while(j >= 0 && arr[j] > temp){
                arr[j + 1] = arr[j]; // shifting larger elements to temp by 1 position
                j = j -1;
            }
            arr[j + 1] = temp;
        }
    }

    public void sortDescending(int[] arr){
        int n = arr.length;

        for(int i = 1; i < n; i++){
            int temp = arr[i];
            int j = i - 1;

            while(j>=0 && arr[j] < temp){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = temp;
        }
}


    public static void main(String[] args) {
        int[] arr = new int[] {5,1,2,9,10};
        InsertionSort is = new InsertionSort();
        is.printArray(arr);
        is.sortDescending(arr);
        is.printArray(arr);

    }
    
}
