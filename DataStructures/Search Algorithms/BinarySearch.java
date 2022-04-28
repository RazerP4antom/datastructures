public class BinarySearch {
    // for sorted array

    public int binarySearch(int[] nums, int key){
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = (high+low)/2;
            if(nums[mid] == key)
                return mid;
            if(key < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {1,10,20,47,59,65,75,88,99};
        int temp = bs.binarySearch(nums, 100);
        if(temp != -1)
            System.out.println("Element found at index: " + temp);
        else
            System.out.println("Element is not found");
        
    }
    
}
