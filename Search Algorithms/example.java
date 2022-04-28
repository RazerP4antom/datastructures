public class example {

    // Given a sorted array of distinct integers and a target value
    // return the idex if the target is found\
    // if not return the index where it would be if it were inserted in order
    // Time complexity = logn
    
    public int searchInsert(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target){
                System.out.println("Element at index: " + mid);
                return mid;
            } 
            if(target < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println("Element should be at index: " + low);
        return low;
    }


    public static void main(String[] args) {
        int[] arr = {1,10,20,47,59,65,75,88,99};
        example si = new example();
        si.searchInsert(arr, 23);
        //System.out.println("Element found at index OR Element will be inserted at index: " + si.searchInsert(arr, 66)); 
        

    }
}